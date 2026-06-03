package com.synpharm.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.synpharm.model.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户Mapper
 */
@Mapper
public interface SysUserRepository extends BaseMapper<SysUser> {

    /**
     * 根据邮箱查询用户
     */
    SysUser findByEmail(String email);

    /**
     * 根据ID查询用户
     */
    SysUser findById(Long id);
}