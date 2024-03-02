package icu.fdss.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 文章分类实体类
 *
 * @author 🌃梦幻◎星空🌃
 */
@Data
public class Category {
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 分类名称
     */
    @NotEmpty(message = "分类名称不能为空")
    private String categoryName;
    /**
     * 分类别名
     */
    @NotEmpty(message = "分类别名不能为空")
    private String categoryAlias;
    /**
     * 创建人ID
     */
    private Integer createUser;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
}
