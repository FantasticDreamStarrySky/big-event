package icu.fdss.service;

import icu.fdss.entity.Category;

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

}
