package com.synpharm.api;

import com.synpharm.dto.request.LoginRequest;
import com.synpharm.dto.request.RegisterRequest;
import com.synpharm.dto.response.LoginResponse;
import com.synpharm.service.UserService;
import com.synpharm.utils.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 认证控制器
 * 
 * <p>处理用户认证相关的HTTP请求，包括登录、注册、登出等功能。
 * 使用JWT令牌进行身份验证，配合Spring Security实现安全控制。
 * 
 * @author SynPharm Team
 * @version 1.0.0
 */
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Tag(name = "认证管理", description = "用户登录、注册、登出接口")
public class AuthController {

    /** 用户服务，处理用户相关业务逻辑 */
    private final UserService userService;

    /**
     * 用户登录接口
     * 
     * <p>接收用户邮箱和密码，验证成功后返回JWT令牌和用户信息。
     * 
     * @param request 登录请求对象，包含email和password字段
     * @return 登录成功返回包含token和用户信息的响应
     * @throws com.synpharm.exception.BusinessException 用户不存在或密码错误时抛出
     */
    @PostMapping("/login")
    @Operation(summary = "用户登录", description = "通过邮箱和密码进行登录，成功返回JWT令牌")
    public Result<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
        return Result.success(userService.login(request));
    }

    /**
     * 用户注册接口
     * 
     * <p>接收用户注册信息，创建新用户账户。
     * 注册成功后自动登录，返回JWT令牌。
     * 
     * @param request 注册请求对象，包含email、password、nickname字段
     * @return 注册成功返回成功响应
     * @throws com.synpharm.exception.BusinessException 用户已存在时抛出
     */
    @PostMapping("/register")
    @Operation(summary = "用户注册", description = "创建新用户账户，支持邮箱、密码、昵称")
    public Result<Void> register(@Valid @RequestBody RegisterRequest request) {
        userService.register(request);
        return Result.success();
    }

    /**
     * 用户登出接口
     * 
     * <p>处理用户登出请求。由于采用JWT无状态认证，
     * 服务端无需特殊处理，主要由前端清除Token实现。
     * 
     * @param token 请求头中的JWT令牌（Bearer格式）
     * @return 登出成功返回成功响应
     */
    @PostMapping("/logout")
    @Operation(summary = "用户登出", description = "用户登出，清除客户端Token")
    public Result<Void> logout(@RequestHeader("Authorization") String token) {
        userService.logout(token);
        return Result.success();
    }
}