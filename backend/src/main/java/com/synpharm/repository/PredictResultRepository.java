package com.synpharm.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.synpharm.model.entity.PredictResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 预测结果Mapper
 */
@Mapper
public interface PredictResultRepository extends BaseMapper<PredictResult> {

    /**
     * 根据结果编号查询
     */
    @Select("SELECT * FROM predict_result WHERE result_no = #{resultNo}")
    PredictResult findByResultNo(@Param("resultNo") String resultNo);

    /**
     * 根据任务ID查询结果
     */
    @Select("SELECT * FROM predict_result WHERE task_id = #{taskId}")
    PredictResult findByTaskId(@Param("taskId") Long taskId);

    /**
     * 根据用户ID查询结果列表
     */
    @Select("SELECT * FROM predict_result WHERE user_id = #{userId} ORDER BY created_at DESC")
    List<PredictResult> findByUserId(@Param("userId") Long userId);
}