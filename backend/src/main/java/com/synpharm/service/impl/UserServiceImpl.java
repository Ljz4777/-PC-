package com.synpharm.service.impl;

import com.synpharm.dto.request.LoginRequest;
import com.synpharm.dto.request.RegisterRequest;
import com.synpharm.dto.response.LoginResponse;
import com.synpharm.dto.response.UserResponse;
import com.synpharm.exception.BusinessException;
import com.synpharm.exception.ErrorCode;
import com.synpharm.model.entity.SysUser;
import com.synpharm.repository.mapper.SysUserMapper;
import com.synpharm.service.UserService;
import com.synpharm.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * 用户服务实现类
 * 
 * <p>实现用户相关的业务操作，包括登录、注册、查询和更新等。
 * 
 * @author SynPharm Team
 * @version 1.0.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final SysUserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;

    @Override
    @Transactional
    public UserResponse register(RegisterRequest request) {
        if (existsByEmail(request.getEmail())) {
            throw new BusinessException(ErrorCode.USER_EXISTS);
        }
        
        SysUser user = new SysUser();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setNickname(request.getNickname());
        user.setRole("user");
        user.setStatus(1);
        user.setEmailVerified(0);
        
        userMapper.insert(user);
        log.info("用户注册成功: email={}", request.getEmail());
        
        return UserResponse.fromEntity(user);
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        SysUser user = userMapper.selectByEmail(request.getEmail());
        
        if (user == null) {
            throw new BusinessException(ErrorCode.USER_NOT_FOUND);
        }
        
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new BusinessException(ErrorCode.PASSWORD_ERROR);
        }
        
        if (user.getStatus() == 0) {
            throw new BusinessException(ErrorCode.USER_DISABLED);
        }
        
        user.setLastLoginAt(LocalDateTime.now());
        userMapper.updateById(user);
        
        String token = jwtUtils.generateToken(user.getId(), user.getEmail());
        
        log.info("用户登录成功: email={}", request.getEmail());
        
        return LoginResponse.builder()
                .token(token)
                .user(UserResponse.fromEntity(user))
                .build();
    }

    @Override
    public SysUser getUserById(Long userId) {
        SysUser user = userMapper.selectById(userId);
        if (user == null) {
            throw new BusinessException(ErrorCode.USER_NOT_FOUND);
        }
        return user;
    }

    @Override
    public SysUser getUserByEmail(String email) {
        return userMapper.selectByEmail(email);
    }

    @Override
    @Transactional
    public UserResponse updateUser(Long userId, String nickname, String avatarUrl) {
        SysUser user = getUserById(userId);
        
        if (nickname != null) {
            user.setNickname(nickname);
        }
        if (avatarUrl != null) {
            user.setAvatarUrl(avatarUrl);
        }
        
        userMapper.updateById(user);
        log.info("更新用户信息: userId={}", userId);
        
        return UserResponse.fromEntity(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long userId) {
        getUserById(userId);
        userMapper.deleteById(userId);
        log.info("删除用户: userId={}", userId);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userMapper.selectByEmail(email) != null;
    }
}