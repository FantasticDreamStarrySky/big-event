package icu.fdss.controller;

import icu.fdss.entity.Result;
import icu.fdss.entity.User;
import icu.fdss.service.UserService;
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
}
