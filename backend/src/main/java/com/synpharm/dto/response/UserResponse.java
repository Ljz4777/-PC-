package com.synpharm.dto.response;

import com.synpharm.model.entity.SysUser;
import lombok.Builder;
import lombok.Data;

/**
 * 用户响应DTO
 * 
 * <p>用于返回用户信息的响应数据。
 * 
 * @author SynPharm Team
 * @version 1.0.0
 */
@Data
@Builder
public class UserResponse {

    /** 用户ID */
    private Long id;
    
    /** 用户邮箱 */
    private String email;
    
    /** 用户昵称 */
    private String nickname;
    
    /** 用户头像URL */
    private String avatarUrl;
    
    /** 用户角色 */
    private String role;

    /**
     * 从实体对象转换为响应DTO
     * 
     * @param user 用户实体对象
     * @return 用户响应DTO
     */
    public static UserResponse fromEntity(SysUser user) {
        return UserResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .nickname(user.getNickname())
                .avatarUrl(user.getAvatarUrl())
                .role(user.getRole())
                .build();
    }
}