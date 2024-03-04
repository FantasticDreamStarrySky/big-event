package icu.fdss.service;

import icu.fdss.entity.Article;
import icu.fdss.entity.PageBean;

/**
 * 文章服务接口
 *
 * @author 🌃梦幻◎星空🌃
 */
public interface ArticleService {

    /**
     * 新增文章
     *
     * @param article 文章
     */
    void add(Article article);

    /**
     * 文章列表分页查询
     *
     * @param pageNum    页码
     * @param pageSize   每页条数
     * @param categoryId 分类id
     * @param state      状态
     * @return {@link PageBean}<{@link Article}> 文章分页列表
     */
    PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state);
}
