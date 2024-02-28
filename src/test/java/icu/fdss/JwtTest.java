package icu.fdss;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {

    /**
     * 测试生成JWT
     */
    @Test
    public void testGenerateToken() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("username", "张三");
        String token = JWT.create()
                .withClaim("user", claims)    // 添加载荷
                .withExpiresAt(new Date(System.currentTimeMillis() + 3600000))    // 设置过期时间
                .sign(Algorithm.HMAC256("FantasticDreamStarrySky"));// 签名
        System.out.println(token);
    }

    /**
     * 测试解析JWT
     */
    @Test
    public void testParseToken() {
        // 定义字符串，模拟用户传递过来的token
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7ImlkIjoxLCJ1c2VybmFtZSI6IuW8oOS4iSJ9LCJleHAiOjE3MDg5MjMyNjB9.4Y9H6VBKJcUA5P6Xr4D1VePUgoDMwPYr8Ziu_dsZHk4";

        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("FantasticDreamStarrySky")).build();

        DecodedJWT decodedJWT = jwtVerifier.verify(token); // 解析token
        Map<String, Claim> claims = decodedJWT.getClaims();
        System.out.println(claims.get("user"));
    }
}
