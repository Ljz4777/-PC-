package com.synpharm.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * 登录请求DTO
 * 
 * <p>用于接收用户登录请求的参数。
 * 
 * @author SynPharm Team
 * @version 1.0.0
 */
@Data
public class LoginRequest {

    /** 用户邮箱 */
    @NotBlank(message = "邮箱不能为空")
    private String email;

    /** 用户密码 */
    @NotBlank(message = "密码不能为空")
    private String password;
}