package icu.fdss.controller;

import icu.fdss.entity.Result;
import icu.fdss.entity.User;
import icu.fdss.service.UserService;
import icu.fdss.utils.JwtUtil;
import icu.fdss.utils.Md5Util;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户控制器
 *
 * @author 🌃梦幻◎星空🌃
 */
@Validated
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 注册
     *
     * @param username 用户名
     * @param password 密码
     * @return 注册结果
     */
    @PostMapping("/register")
    public Result<String> register(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$") String password) {
        // 查询用户是否存在
        User user = userService.findByUserName(username);
        if (user == null) {
            // 注册用户
            userService.register(username, password);
            return Result.success();
        } else {
            // 用户已存在
            return Result.error("用户已存在");
        }
    }

    /**
     * 登录
     *
     * @param username 用户名
     * @param password 密码
     * @return 登录结果
     */
    @PostMapping("/login")
    public Result<String> login(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$") String password) {
        // 根据用户名查询用户
        User loginUser = userService.findByUserName(username);
        // 查询用户是否存在
        if (loginUser == null) {
            // 用户不存在
            return Result.error("用户名错误");
        } else {
            // 密码是否正确
            if (Md5Util.checkPassword(password, loginUser.getPassword())) {
                // 登录成功，返回JWT令牌
                Map<String, Object> claims = new HashMap<>(2);
                claims.put("id", loginUser.getId());
                claims.put("username", loginUser.getUsername());
                String token = JwtUtil.genToken(claims);
                return Result.success(token);
            } else {
                // 密码错误
                return Result.error("密码错误");
            }
        }
    }

    @GetMapping("/userInfo")
    public Result<User> userInfo(@RequestHeader(name = "Authorization") String token) {
        // 根据用户名查询用户
        Map<String, Object> map = JwtUtil.parseToken(token);
        String username = (String) map.get("username");

        User user = userService.findByUserName(username);
        return Result.success(user);
    }
}
