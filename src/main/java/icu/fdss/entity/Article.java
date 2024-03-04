package icu.fdss.entity;


import icu.fdss.annotation.State;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.groups.Default;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDateTime;

/**
 * 文章实体类
 *
 * @author 🌃梦幻◎星空🌃
 */
@Data
public class Article {
    /**
     * 主键ID
     */
    @NotNull(message = "文章ID不能为空", groups = Update.class)
    private Integer id;
    /**
     * 文章标题
     */
    @NotEmpty(message = "文章标题不能为空")
    @Pattern(regexp = "^\\S{1,10}$", message = "文章标题长度在1-10之间")
    private String title;
    /**
     * 文章内容
     */
    @NotEmpty(message = "文章内容不能为空")
    private String content;
    /**
     * 封面图像
     */
    @NotEmpty(message = "封面图像URL地址不能为空")
    @URL(message = "封面图像URL地址格式不正确")
    private String coverImg;
    /**
     * 发布状态 已发布|草稿
     */
    @State
    private String state;
    /**
     * 文章分类id
     */
    @NotNull(message = "文章分类ID不能为空")
    private Integer categoryId;
    /**
     * 创建人ID
     */
    private Integer createUser;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    public interface Add extends Default {

    }

    public interface Update extends Default {

    }
}
