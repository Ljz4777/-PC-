package com.synpharm.dto.response;

import lombok.Builder;
import lombok.Data;

/**
 * 登录响应DTO
 * 
 * <p>用于返回登录成功后的响应数据，包含JWT令牌和用户信息。
 * 
 * @author SynPharm Team
 * @version 1.0.0
 */
@Data
@Builder
public class LoginResponse {

    /** JWT令牌 */
    private String token;
    
    /** 用户信息 */
    private UserResponse user;
}