package icu.fdss.mapper;

import icu.fdss.entity.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

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
}
