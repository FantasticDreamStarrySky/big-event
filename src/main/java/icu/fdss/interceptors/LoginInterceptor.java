package icu.fdss.interceptors;

import icu.fdss.utils.JwtUtil;
import icu.fdss.utils.ThreadLocalUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
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

    @Override
    public boolean preHandle(HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) throws Exception {
        // 令牌验证
        String token = request.getHeader("Authorization");
        // 验证令牌
        try {
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
    public void afterCompletion(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler, Exception ex) throws Exception {
        // 清除线程变量
        ThreadLocalUtil.remove();
    }
}
