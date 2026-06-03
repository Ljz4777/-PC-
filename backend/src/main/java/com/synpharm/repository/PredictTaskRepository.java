package com.synpharm.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.synpharm.model.entity.PredictTask;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 预测任务Mapper
 */
@Mapper
public interface PredictTaskRepository extends BaseMapper<PredictTask> {

    /**
     * 根据任务编号查询
     */
    @Select("SELECT * FROM predict_task WHERE task_no = #{taskNo}")
    PredictTask findByTaskNo(@Param("taskNo") String taskNo);

    /**
     * 根据用户ID查询任务列表
     */
    @Select("SELECT * FROM predict_task WHERE user_id = #{userId} ORDER BY created_at DESC")
    List<PredictTask> findByUserId(@Param("userId") Long userId);

    /**
     * 根据用户ID和状态查询任务列表
     */
    @Select("SELECT * FROM predict_task WHERE user_id = #{userId} AND status = #{status} ORDER BY created_at DESC")
    List<PredictTask> findByUserIdAndStatus(@Param("userId") Long userId, @Param("status") String status);
}