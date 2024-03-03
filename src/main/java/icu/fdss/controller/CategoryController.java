package icu.fdss.controller;

import icu.fdss.entity.Category;
import icu.fdss.entity.Result;
import icu.fdss.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 文章分类
 *
 * @author 🌃梦幻◎星空🌃
 * @apiNote 处理文章分类相关的操作和逻辑控制。提供文章分类管理功能，包括新增文章分类，文章分类列表查询，文章分类详情查询。
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 新增文章分类
     *
     * @param category 文章分类
     * @return {@link Result}<{@link String}> 响应成功信息
     * @apiNote 用于处理新增文章分类请求，新增成功返回成功信息。
     */
    @PostMapping
    public Result<String> add(@RequestBody @Validated(Category.Add.class) Category category) {
        categoryService.add(category);
        return Result.success();
    }

    /**
     * 文章分类列表查询
     *
     * @return {@link Result}<{@link List}<{@link Category}>> 文章分类列表
     * @apiNote 用于处理文章分类查询请求，查询成功返回文章分类列表。
     */
    @GetMapping
    public Result<List<Category>> list() {
        List<Category> categoryList = categoryService.list();
        return Result.success(categoryList);
    }

    /**
     * 文章分类详情查询
     *
     * @param id 文章分类ID
     * @return {@link Result}<{@link Category}> 文章分类详情
     * @apiNote 用于处理文章分类详情查询请求，查询成功返回文章分类详情。
     */
    @GetMapping("/detail")
    public Result<Category> detail(Integer id) {
        Category category = categoryService.findById(id);
        return Result.success(category);
    }

    /**
     * 更新文章分类
     *
     * @param category 文章分类
     * @return {@link Result}<{@link String}> 响应成功信息
     * @apiNote 用于处理更新文章分类请求，更新成功返回成功信息。
     */
    @PutMapping
    public Result<String> update(@RequestBody @Validated(Category.Update.class) Category category) {
        categoryService.update(category);
        return Result.success();
    }
}
