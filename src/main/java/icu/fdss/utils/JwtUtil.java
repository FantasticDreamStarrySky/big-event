package icu.fdss.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;
import java.util.Map;

/**
 * @author 🌃梦幻◎星空🌃
 */
public class JwtUtil {

    private static final String KEY = "itheima";
    public static final Integer EXPIRE_TIME = 12 * 60 * 60 * 1000;
	
	/**
     * 接收业务数据,生成token并返回
     */
    public static String genToken(Map<String, Object> claims) {
        return JWT.create()
                .withClaim("claims", claims)
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRE_TIME))
                .sign(Algorithm.HMAC256(KEY));
    }

	/**
     * 接收token,验证token,并返回业务数据
     */
    public static Map<String, Object> parseToken(String token) {
        return JWT.require(Algorithm.HMAC256(KEY))
                .build()
                .verify(token)
                .getClaim("claims")
                .asMap();
    }

}
