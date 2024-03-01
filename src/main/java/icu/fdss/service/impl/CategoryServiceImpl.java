package icu.fdss.service.impl;

import icu.fdss.entity.Category;
import icu.fdss.mapper.CategoryMapper;
import icu.fdss.service.CategoryService;
import icu.fdss.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * 文章分类服务实现类
 *
 * @author 🌃梦幻◎星空🌃
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 新增文章分类
     *
     * @param category 文章分类
     */
    @Override
    public void add(Category category) {
        // 补充属性值
        category.setCreateTime(LocalDateTime.now());
        category.setUpdateTime(LocalDateTime.now());
        Map<String,Object> claims = ThreadLocalUtil.get();
        Integer userId = (Integer) claims.get("id");
        category.setCreateUser(userId);

        categoryMapper.add(category);
    }
}
