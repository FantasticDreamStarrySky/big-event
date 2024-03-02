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
 * @apiNote 处理文章分类相关的操作和逻辑控制。提供文章分类管理功能，包括新增文章分类等。
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
     * @return {@link Result}<{@link String}> 统一响应结果
     * @apiNote 用于处理新增文章分类请求，新增成功返回成功信息。
     */
    @PostMapping
    public Result<String> add(@RequestBody @Validated Category category) {
        categoryService.add(category);
        return Result.success();
    }

    /**
     * 文章分类查询
     *
     * @return {@link Result}<{@link List}<{@link Category}>>
     * @apiNote 用于处理文章分类查询请求，查询成功返回文章分类列表。
     */
    @GetMapping
    public Result<List<Category>> list() {
        List<Category> categoryList = categoryService.list();
        return Result.success(categoryList);
    }
}
