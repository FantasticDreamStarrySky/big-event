package icu.fdss.service;

import icu.fdss.entity.Category;

import java.util.List;

/**
 * 文章分类服务接口
 *
 * @author 🌃梦幻◎星空🌃
 */
public interface CategoryService {

    /**
     * 新增文章分类
     *
     * @param category 文章分类
     */
    void add(Category category);

    /**
     * 文章列表查询
     *
     * @return {@link List}<{@link Category}>
     */
    List<Category> list();
}
