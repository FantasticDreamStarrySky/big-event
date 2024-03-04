package icu.fdss.controller;

import icu.fdss.entity.Article;
import icu.fdss.entity.Result;
import icu.fdss.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Result<String> add(@RequestBody Article article) {
        articleService.add(article);
        return Result.success();
    }

}
