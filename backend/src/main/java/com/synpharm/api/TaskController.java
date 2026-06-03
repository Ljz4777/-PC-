package com.synpharm.api;

import com.synpharm.service.TaskService;
import com.synpharm.utils.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 任务控制器
 * 
 * <p>处理预测任务相关的HTTP请求，包括查询任务列表、获取任务详情、取消任务等功能。
 * 
 * @author SynPharm Team
 * @version 1.0.0
 */
@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
@Tag(name = "任务管理", description = "任务状态查询与管理接口")
public class TaskController {

    /** 任务服务，处理任务相关业务逻辑 */
    private final TaskService taskService;

    /**
     * 获取任务列表接口
     * 
     * <p>分页查询当前用户的任务列表，支持按状态筛选。
     * 
     * @param token 请求头中的JWT令牌（Bearer格式）
     * @param status 任务状态筛选（可选）
     * @param page 页码，默认值为1
     * @param pageSize 每页大小，默认值为10
     * @return 分页任务列表
     */
    @GetMapping
    @Operation(summary = "获取任务列表", description = "分页查询当前用户的任务列表，支持状态筛选")
    public Result<?> listTasks(
            @RequestHeader("Authorization") String token,
            @RequestParam(required = false) String status,
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        return Result.success(taskService.listTasks(token, status, page, pageSize));
    }

    /**
     * 获取任务详情接口
     * 
     * <p>根据任务ID查询任务的详细信息，包括状态、进度等。
     * 
     * @param token 请求头中的JWT令牌（Bearer格式）
     * @param id 任务ID
     * @return 任务详情
     */
    @GetMapping("/{id}")
    @Operation(summary = "获取任务详情", description = "根据ID查询任务详细信息")
    public Result<?> getTask(
            @RequestHeader("Authorization") String token,
            @PathVariable Long id) {
        return Result.success(taskService.getTask(token, id));
    }

    /**
     * 取消任务接口
     * 
     * <p>取消指定的预测任务，仅对未完成的任务有效。
     * 
     * @param token 请求头中的JWT令牌（Bearer格式）
     * @param id 任务ID
     * @return 取消成功返回成功响应
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "取消任务", description = "取消指定的预测任务")
    public Result<Void> cancelTask(
            @RequestHeader("Authorization") String token,
            @PathVariable Long id) {
        taskService.cancelTask(token, id);
        return Result.success();
    }
}