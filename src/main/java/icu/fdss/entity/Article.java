package icu.fdss.entity;


import java.time.LocalDateTime;

/**
 * @author 🌃梦幻◎星空🌃
 */
public class Article {
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 文章标题
     */
    private String title;
    /**
     * 文章内容
     */
    private String content;
    /**
     * 封面图像
     */
    private String coverImg;
    /**
     * 发布状态 已发布|草稿
     */
    private String state;
    /**
     * 文章分类id
     */
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
}
