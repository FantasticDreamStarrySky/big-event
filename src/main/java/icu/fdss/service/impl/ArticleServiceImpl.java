package icu.fdss.service.impl;

import icu.fdss.entity.Article;
import icu.fdss.mapper.ArticleMapper;
import icu.fdss.service.ArticleService;
import icu.fdss.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * 文章服务实现
 *
 * @author 🌃梦幻◎星空🌃
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    /**
     * 新增文章
     *
     * @param article 文章
     */
    @Override
    public void add(Article article) {
        // 补充属性值
        article.setCreateTime(LocalDateTime.now());
        article.setUpdateTime(LocalDateTime.now());
        Map<String,Object> claims = ThreadLocalUtil.get();
        Integer userId = (Integer) claims.get("id");
        article.setCreateUser(userId);

        articleMapper.add(article);
    }
}
