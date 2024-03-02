package icu.fdss.mapper;

import icu.fdss.entity.Category;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 文章分类数据访问接口
 *
 * @author 🌃梦幻◎星空🌃
 */
@Mapper
public interface CategoryMapper {

    /**
     * 新增文章分类
     *
     * @param category 文章分类
     */
    @Insert("insert into category(category_name, category_alias, create_user, create_time, update_time) " +
            "values(#{categoryName},#{categoryAlias},#{createUser},#{updateTime},#{updateTime})")
    void add(Category category);

    /**
     * 查询文章分类列表
     *
     * @param userId 用户ID
     * @return {@link List}<{@link Category}> 文章分类列表
     */
    @Select("select * from category where create_user=#{userId}")
    List<Category> list(Integer userId);
}
