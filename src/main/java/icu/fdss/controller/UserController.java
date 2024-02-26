package icu.fdss.controller;

import icu.fdss.entity.Result;
import icu.fdss.entity.User;
import icu.fdss.service.UserService;
import icu.fdss.utils.Md5Util;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 🌃梦幻◎星空🌃
 */
@RestController
@RequestMapping("/user")
@Validated
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
            return Result.error("用户名错误");
        } else {
            // 密码是否正确
            if (Md5Util.checkPassword(password, loginUser.getPassword())) {
                return Result.success("JWT令牌");
            } else {
                return Result.error("密码错误");
            }
        }
    }
}
