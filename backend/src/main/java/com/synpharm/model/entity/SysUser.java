package com.synpharm.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 系统用户实体
 * 
 * <p>映射数据库表 sys_user，存储系统用户信息。
 * 
 * @author SynPharm Team
 * @version 1.0.0
 */
@Data
@TableName("sys_user")
public class SysUser {

    /** 用户ID（主键） */
    @TableId(type = IdType.AUTO)
    private Long id;

    /** 用户邮箱（唯一） */
    private String email;
    
    /** 用户密码（加密存储） */
    private String password;
    
    /** 用户昵称 */
    private String nickname;
    
    /** 用户头像URL */
    private String avatarUrl;
    
    /** 用户角色（user/admin/guest） */
    private String role;
    
    /** 用户状态（0禁用，1启用） */
    private Integer status;
    
    /** 邮箱验证状态（0未验证，1已验证） */
    private Integer emailVerified;
    
    /** 最后登录时间 */
    private LocalDateTime lastLoginAt;

    /** 创建时间（自动填充） */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdAt;

    /** 更新时间（自动填充） */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedAt;

    /** 删除标记（0未删除，1已删除） */
    @TableLogic
    private Integer deleted;
}