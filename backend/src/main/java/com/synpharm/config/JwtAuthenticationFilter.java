package com.synpharm.config;

import com.synpharm.utils.JwtUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

/**
 * JWT认证过滤器
 * 
 * <p>拦截所有HTTP请求，验证JWT令牌并将用户信息存入SecurityContext。
 * 继承OncePerRequestFilter确保每个请求只过滤一次。
 * 
 * @author SynPharm Team
 * @version 1.0.0
 */
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    /** JWT工具类，用于解析和验证Token */
    private final JwtUtils jwtUtils;

    /**
     * 执行认证过滤
     * 
     * <p>从请求头中提取Authorization头，解析JWT令牌，
     * 验证Token有效性后将用户信息存入SecurityContext。
     * 
     * @param request HTTP请求对象
     * @param response HTTP响应对象
     * @param filterChain 过滤器链
     * @throws ServletException Servlet异常
     * @throws IOException IO异常
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, 
                                    FilterChain filterChain) throws ServletException, IOException {
        // 从请求头获取Authorization
        String token = request.getHeader("Authorization");
        
        // 检查Token是否存在且格式正确（Bearer前缀）
        if (token != null && token.startsWith("Bearer ")) {
            // 移除Bearer前缀
            token = token.replace("Bearer ", "");
            
            // 验证Token有效性
            if (jwtUtils.validateToken(token)) {
                // 从Token中提取用户信息
                Long userId = jwtUtils.getUserIdFromToken(token);
                String role = jwtUtils.getRoleFromToken(token);
                
                // 创建认证对象
                UsernamePasswordAuthenticationToken authToken = 
                    new UsernamePasswordAuthenticationToken(
                        userId,  // 用户名/用户ID
                        null,    // 凭证（密码），JWT不需要
                        Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + role))  // 用户角色
                    );
                
                // 设置认证详情
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                
                // 将认证信息存入SecurityContext
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        
        // 继续过滤器链
        filterChain.doFilter(request, response);
    }
}