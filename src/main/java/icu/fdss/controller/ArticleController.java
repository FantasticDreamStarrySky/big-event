package icu.fdss.controller;

import icu.fdss.entity.Article;
import icu.fdss.entity.PageBean;
import icu.fdss.entity.Result;
import icu.fdss.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 文章
 *
 * @author 🌃梦幻◎星空🌃
 * @apiNote 处理文章相关的操作和逻辑控制。提供文章管理功能，包括文章列表查询，文章详情查询，新增文章，更新文章，删除文章。
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * 新增文章
     *
     * @param article 文章
     * @return {@link Result}<{@link String}> 响应成功信息
     * @apiNote 用于处理新增文章请求，新增成功返回成功信息。
     */
    @PostMapping
    public Result<String> add(@RequestBody @Validated(Article.Add.class) Article article) {
        articleService.add(article);
        return Result.success();
    }

    /**
     * 文章列表分页查询
     *
     * @param pageNum    页码
     * @param pageSize   每页条数
     * @param categoryId 分类id
     * @param state      状态
     * @return {@link Result}<{@link PageBean}<{@link Article}>> 文章分页列表
     * @apiNote 用于处理文章列表分页查询请求，返回文章分页列表。
     */
    @GetMapping
    public Result<PageBean<Article>> list(
            Integer pageNum,
            Integer pageSize,
            @RequestParam(required = false) Integer categoryId,
            @RequestParam(required = false) String state
    ) {
        PageBean<Article> articlePageBean = articleService.list(pageNum, pageSize, categoryId, state);
        return Result.success(articlePageBean);
    }

    /**
     * 文章详情查询
     *
     * @param id 文章id
     * @return {@link Result}<{@link Article}> 文章详情
     * @apiNote 用于处理文章详情查询请求，返回文章详情。
     */
    @GetMapping("/detail")
    public Result<Article> detail(Integer id) {
        Article article = articleService.detail(id);
        return Result.success(article);
    }

    /**
     * 更新文章
     *
     * @param article 文章
     * @return {@link Result}<{@link String}> 响应成功信息
     * @apiNote 用于处理更新文章请求，更新成功返回成功信息。
     */
    @PutMapping
    public Result<String> update(@RequestBody @Validated(Article.Update.class) Article article) {
        articleService.update(article);
        return Result.success();
    }

}
