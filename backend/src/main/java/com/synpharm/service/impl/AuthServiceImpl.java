package com.synpharm.service.impl;

import com.synpharm.dto.request.LoginRequest;
import com.synpharm.dto.request.RegisterRequest;
import com.synpharm.dto.response.LoginResponse;
import com.synpharm.dto.response.UserResponse;
import com.synpharm.exception.BusinessException;
import com.synpharm.exception.ErrorCode;
import com.synpharm.model.entity.SysUser;
import com.synpharm.repository.SysUserRepository;
import com.synpharm.service.AuthService;
import com.synpharm.utils.JwtUtils;
import com.synpharm.utils.PasswordUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * 认证服务实现
 */
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final SysUserRepository userRepository;
    private final JwtUtils jwtUtils;

    @Override
    public LoginResponse login(LoginRequest request) {
        // 1. 查询用户
        SysUser user = userRepository.findByEmail(request.getEmail());
        if (user == null) {
            throw new BusinessException(ErrorCode.USER_NOT_FOUND);
        }

        // 2. 验证密码
        if (!PasswordUtils.verify(request.getPassword(), user.getPassword())) {
            throw new BusinessException(ErrorCode.PASSWORD_ERROR);
        }

        // 3. 检查用户状态
        if (user.getStatus() != 1) {
            throw new BusinessException(ErrorCode.USER_DISABLED);
        }

        // 4. 生成Token
        String token = jwtUtils.generateToken(user.getId(), user.getEmail(), user.getRole());

        // 5. 更新最后登录时间
        user.setLastLoginAt(LocalDateTime.now());
        userRepository.updateById(user);

        // 6. 返回响应
        return LoginResponse.builder()
                .token(token)
                .user(convertToUserResponse(user))
                .build();
    }

    @Override
    public LoginResponse register(RegisterRequest request) {
        // 1. 检查邮箱是否已存在
        SysUser existUser = userRepository.findByEmail(request.getEmail());
        if (existUser != null) {
            throw new BusinessException(ErrorCode.USER_EXISTS);
        }

        // 2. 创建用户
        SysUser user = new SysUser();
        user.setEmail(request.getEmail());
        user.setPassword(PasswordUtils.encrypt(request.getPassword()));
        user.setNickname(request.getNickname());
        user.setRole("user");
        user.setStatus(1);
        user.setEmailVerified(0);
        userRepository.insert(user);

        // 3. 生成Token
        String token = jwtUtils.generateToken(user.getId(), user.getEmail(), user.getRole());

        // 4. 返回响应
        return LoginResponse.builder()
                .token(token)
                .user(convertToUserResponse(user))
                .build();
    }

    @Override
    public LoginResponse guestLogin() {
        // 1. 创建游客用户
        SysUser guestUser = new SysUser();
        guestUser.setEmail("guest_" + System.currentTimeMillis() + "@guest.local");
        guestUser.setPassword(PasswordUtils.encrypt("guest"));
        guestUser.setNickname("游客");
        guestUser.setRole("guest");
        guestUser.setStatus(1);
        guestUser.setEmailVerified(1);
        userRepository.insert(guestUser);

        // 2. 生成Token
        String token = jwtUtils.generateToken(guestUser.getId(), guestUser.getEmail(), guestUser.getRole());

        // 3. 返回响应
        return LoginResponse.builder()
                .token(token)
                .user(convertToUserResponse(guestUser))
                .build();
    }

    @Override
    public void logout(Long userId) {
        // JWT无状态，退出登录由前端处理Token删除
        // 这里可以添加Token黑名单机制（如果需要）
    }

    /**
     * 转换为用户响应DTO
     */
    private UserResponse convertToUserResponse(SysUser user) {
        return UserResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .nickname(user.getNickname())
                .avatarUrl(user.getAvatarUrl())
                .role(user.getRole())
                .build();
    }
}