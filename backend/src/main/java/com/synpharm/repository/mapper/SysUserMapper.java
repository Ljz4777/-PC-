package com.synpharm.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.synpharm.model.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统用户数据访问接口
 * 
 * <p>继承MyBatisPlus的BaseMapper，提供用户数据的CRUD操作。
 * 
 * @author SynPharm Team
 * @version 1.0.0
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
    
    /**
     * 根据邮箱查询用户
     * 
     * @param email 用户邮箱
     * @return 用户实体
     */
    SysUser selectByEmail(String email);
}