package icu.fdss.interceptors;

import icu.fdss.utils.JwtUtil;
import icu.fdss.utils.ThreadLocalUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

/**
 * 登录拦截器
 *
 * @author 🌃梦幻◎星空🌃
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) {
        // 令牌验证
        String token = request.getHeader("Authorization");
        // 验证令牌
        try {
            // 从Redis中获取相同的token
            String redisToken = stringRedisTemplate.opsForValue().get(token);
            if (redisToken == null) {
                throw new RuntimeException("token无效");
            }
            Map<String, Object> claims = JwtUtil.parseToken(token);
            // 将用户信息放入线程变量
            ThreadLocalUtil.set(claims);
            // 通过验证,放行
            return true;
        } catch (Exception e) {
            response.setStatus(401);
            return false;
        }
    }

    @Override
    public void afterCompletion(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler, Exception ex) {
        // 清除线程变量
        ThreadLocalUtil.remove();
    }
}
