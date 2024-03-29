package icu.fdss.mapper;

import icu.fdss.entity.Article;
import org.apache.ibatis.annotations.*;

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

    /**
     * 更新文章
     *
     * @param article 文章
     */
    @Update("update article set title=#{title},content=#{content},cover_img=#{coverImg},state=#{state},category_id=#{categoryId},update_time=#{updateTime} where id=#{id}")
    void update(Article article);

    /**
     * 删除文章
     *
     * @param id 文章ID
     */
    @Delete("delete from article where id = #{id}")
    void deleteById(Integer id);
}
