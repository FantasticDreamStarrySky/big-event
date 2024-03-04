package icu.fdss.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import icu.fdss.entity.Article;
import icu.fdss.entity.PageBean;
import icu.fdss.mapper.ArticleMapper;
import icu.fdss.service.ArticleService;
import icu.fdss.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
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
        Map<String, Object> claims = ThreadLocalUtil.get();
        Integer userId = (Integer) claims.get("id");
        article.setCreateUser(userId);

        articleMapper.add(article);
    }

    /**
     * 文章列表分页查询
     *
     * @param pageNum    页码
     * @param pageSize   每页条数
     * @param categoryId 分类id
     * @param state      状态
     * @return {@link PageBean}<{@link Article}> 文章分页列表
     */
    @Override
    public PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state) {
        // 1. 创建PageBean对象
        PageBean<Article> pageBean = new PageBean<>();

        // 2. 开启分页查询 - PageHelper
        PageHelper.startPage(pageNum, pageSize);

        // 3. 调用Mapper层查询数据
        Map<String, Object> claims = ThreadLocalUtil.get();
        Integer userId = (Integer) claims.get("id");
        List<Article> articleList = articleMapper.list(userId, categoryId, state);

        // 4. 封装分页数据
        Page<Article> page = (Page<Article>) articleList;
        pageBean.setTotal(page.getTotal());
        pageBean.setItems(articleList);

        // 5. 返回分页数据
        return pageBean;
    }

    /**
     * 文章详情查询
     *
     * @param id 文章ID
     * @return {@link Article} 文章详情
     */
    @Override
    public Article detail(Integer id) {
        return articleMapper.findById(id);
    }

    /**
     * 更新文章
     *
     * @param article 文章
     */
    @Override
    public void update(Article article) {
        article.setUpdateTime(LocalDateTime.now());
        articleMapper.update(article);
    }

    /**
     * 删除文章
     *
     * @param id 文章ID
     */
    @Override
    public void delete(Integer id) {
        articleMapper.deleteById(id);
    }
}
