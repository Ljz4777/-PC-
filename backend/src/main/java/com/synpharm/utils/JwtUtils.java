package com.synpharm.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * JWT工具类
 * 
 * <p>提供JWT令牌的生成、解析和验证功能。
 * 
 * @author SynPharm Team
 * @version 1.0.0
 */
@Slf4j
@Component
public class JwtUtils {

    /** JWT签名密钥 */
    @Value("${jwt.secret}")
    private String secret;

    /** JWT过期时间（分钟） */
    @Value("${jwt.expire-minutes}")
    private int expireMinutes;

    /**
     * 生成JWT令牌
     * 
     * @param userId 用户ID
     * @param email 用户邮箱
     * @return JWT令牌
     */
    public String generateToken(Long userId, String email) {
        Date now = new Date();
        Date expireDate = new Date(now.getTime() + expireMinutes * 60 * 1000L);
        
        return JWT.create()
                .withSubject(String.valueOf(userId))
                .withClaim("email", email)
                .withIssuedAt(now)
                .withExpiresAt(expireDate)
                .sign(Algorithm.HMAC256(secret));
    }

    /**
     * 验证并解析JWT令牌
     * 
     * @param token JWT令牌
     * @return 解码后的JWT对象
     */
    public DecodedJWT verifyToken(String token) {
        try {
            return JWT.require(Algorithm.HMAC256(secret))
                    .build()
                    .verify(token);
        } catch (Exception e) {
            log.error("JWT验证失败: {}", e.getMessage());
            return null;
        }
    }

    /**
     * 从令牌中获取用户ID
     * 
     * @param token JWT令牌
     * @return 用户ID
     */
    public Long getUserIdFromToken(String token) {
        DecodedJWT jwt = verifyToken(token);
        if (jwt == null) {
            return null;
        }
        return Long.parseLong(jwt.getSubject());
    }

    /**
     * 从令牌中获取用户邮箱
     * 
     * @param token JWT令牌
     * @return 用户邮箱
     */
    public String getEmailFromToken(String token) {
        DecodedJWT jwt = verifyToken(token);
        if (jwt == null) {
            return null;
        }
        return jwt.getClaim("email").asString();
    }
}