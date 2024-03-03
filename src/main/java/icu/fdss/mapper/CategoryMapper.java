package icu.fdss.mapper;

import icu.fdss.entity.Category;
import org.apache.ibatis.annotations.*;

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

    /**
     * 根据ID查询文章分类详情
     *
     * @param id 文章分类ID
     * @return {@link Category} 文章分类详情
     */
    @Select("select * from category where id=#{id}")
    Category findById(Integer id);

    /**
     * 更新文章分类
     *
     * @param category 文章分类
     */
    @Update("update category set category_name=#{categoryName}, category_alias=#{categoryAlias}, update_time=#{updateTime} where id=#{id}")
    void update(Category category);

    /**
     * 根据ID删除文章分类
     *
     * @param id 文章分类ID
     */
    @Delete("delete from category where id=#{id}")
    void deleteById(Integer id);
}
