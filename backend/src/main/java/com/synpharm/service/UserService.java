package com.synpharm.service;

import com.synpharm.dto.request.LoginRequest;
import com.synpharm.dto.request.RegisterRequest;
import com.synpharm.dto.response.LoginResponse;
import com.synpharm.dto.response.UserResponse;
import com.synpharm.model.entity.SysUser;

/**
 * 用户服务接口
 * 
 * <p>定义用户相关的业务操作，包括登录、注册、查询等。
 * 
 * @author SynPharm Team
 * @version 1.0.0
 */
public interface UserService {

    /**
     * 用户注册
     * 
     * @param request 注册请求
     * @return 用户响应
     */
    UserResponse register(RegisterRequest request);

    /**
     * 用户登录
     * 
     * @param request 登录请求
     * @return 登录响应（包含token和用户信息）
     */
    LoginResponse login(LoginRequest request);

    /**
     * 根据用户ID查询用户
     * 
     * @param userId 用户ID
     * @return 用户实体
     */
    SysUser getUserById(Long userId);

    /**
     * 根据邮箱查询用户
     * 
     * @param email 用户邮箱
     * @return 用户实体
     */
    SysUser getUserByEmail(String email);

    /**
     * 更新用户信息
     * 
     * @param userId 用户ID
     * @param nickname 昵称
     * @param avatarUrl 头像URL
     * @return 更新后的用户响应
     */
    UserResponse updateUser(Long userId, String nickname, String avatarUrl);

    /**
     * 删除用户
     * 
     * @param userId 用户ID
     */
    void deleteUser(Long userId);

    /**
     * 检查邮箱是否已存在
     * 
     * @param email 用户邮箱
     * @return 是否已存在
     */
    boolean existsByEmail(String email);
}