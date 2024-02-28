package icu.fdss.controller;

import icu.fdss.entity.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 文章控制器
 *
 * @author 🌃梦幻◎星空🌃
 */
@RestController
@RequestMapping("/article")
public class ArticleController {
    @GetMapping("/list")
    public Result<String> list() {
        return Result.success("所有的文章数据...");
    }
}
