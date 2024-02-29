package icu.fdss.controller;

import icu.fdss.entity.Result;
import icu.fdss.entity.User;
import icu.fdss.service.UserService;
import icu.fdss.utils.JwtUtil;
import icu.fdss.utils.Md5Util;
import icu.fdss.utils.ThreadLocalUtil;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户控制类
 *
 * @author 🌃梦幻◎星空🌃
 * @apiNote 处理用户相关的操作和逻辑控制。提供用户管理功能，包括用户注册、登录、获取用户信息、更新用户信息等。
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
     * @return {@link Result}<{@link String}>
     * @apiNote 用于处理用户注册请求，注册成功返回成功信息。
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
     * @return {@link Result}<{@link String}>
     * @apiNote 处理用户登录请求，登录成功返回JWT令牌。
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

    /**
     * 获取用户信息
     *
     * @return {@link Result}<{@link User}>
     * @apiNote 处理获取当前用户信息请求，返回当前用户信息。
     */
    @GetMapping("/userInfo")
    public Result<User> userInfo() {
        // 获取当前用户信息
        Map<String, Object> claims = ThreadLocalUtil.get();
        String username = (String) claims.get("username");
        // 根据用户名查询用户
        User user = userService.findByUserName(username);
        return Result.success(user);
    }

    /**
     * 更新用户信息
     *
     * @param user 用户
     * @return {@link Result}<{@link String}>
     * @apiNote 处理更新用户信息请求，更新成功返回成功信息。
     */
    @PutMapping("/update")
    public Result<String> update(@RequestBody @Validated User user) {
        userService.update(user);
        return Result.success();
    }
}
