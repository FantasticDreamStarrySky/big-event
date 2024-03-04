package icu.fdss.mapper;

import icu.fdss.entity.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 文章数据访问接口
 *
 * @author 🌃梦幻◎星空🌃
 */
@Mapper
public interface ArticleMapper {
    /**
     * 新增文章
     *
     * @param article 文章
     */
    @Insert("insert into article(title,content,cover_img,state,create_user,create_time,update_time) values(#{title},#{content},#{coverImg},#{state},#{createUser},#{createTime},#{updateTime})")
    void add(Article article);

    /**
     * 文章列表查询
     *
     * @param userId     用户id
     * @param categoryId 分类id
     * @param state      状态
     * @return {@link List}<{@link Article}> 文章列表
     */
    List<Article> list(@Param("userId") Integer userId, @Param("categoryId") Integer categoryId, @Param("state") String state);

    /**
     * 文章详情查询
     *
     * @param id 文章ID
     * @return {@link Article} 文章详情
     */
    @Select("select * from article where id = #{id}")
    Article findById(Integer id);
}
