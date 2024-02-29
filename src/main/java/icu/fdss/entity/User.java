package icu.fdss.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 用户实体类
 *
 * @author 🌃梦幻◎星空🌃
 */
@Data
public class User {
    /**
     * 主键ID
     */
    @NotNull
    private Integer id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    @JsonIgnore
    private String password;
    /**
     * 昵称
     */
    @NotEmpty
    @Pattern(regexp = "^\\S{1,10}$")
    private String nickname;
    /**
     * 邮箱
     */
    @NotEmpty
    @Email
    private String email;
    /**
     * 用户头像地址
     */
    private String userPic;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
