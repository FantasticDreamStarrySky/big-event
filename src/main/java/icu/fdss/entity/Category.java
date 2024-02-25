package icu.fdss.entity;

import java.time.LocalDateTime;

/**
 * @author 🌃梦幻◎星空🌃
 */
public class Category {
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 分类名称
     */
    private String categoryName;
    /**
     * 分类别名
     */
    private String categoryAlias;
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
}
