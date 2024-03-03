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
     * 文章分类列表查询
     *
     * @return {@link List}<{@link Category}> 文章分类列表
     */
    List<Category> list();

    /**
     * 根据id查询文章分类详情
     *
     * @param id 分类id
     * @return {@link Category} 文章分类详情
     */
    Category findById(Integer id);

    /**
     * 更新文章分类
     *
     * @param category 文章分类
     */
    void update(Category category);

    /**
     * 根据id删除文章分类
     *
     * @param id 分类id
     */
    void deleteById(Integer id);
}
