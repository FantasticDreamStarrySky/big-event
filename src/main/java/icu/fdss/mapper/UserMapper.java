package icu.fdss.mapper;

import icu.fdss.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author 🌃梦幻◎星空🌃
 */
@Mapper
public interface UserMapper {
    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return {@link User 用户实体类}
     */
    @Select("select * from user where username=#{username} ")
    User findByUserName(String username);

    /**
     * 新增用户
     *
     * @param username    用户名
     * @param md5Password 密码
     */
    @Insert("insert into user(username, password, create_time, update_time) values(#{username},#{md5Password},now(),now())")
    void add(@Param("username") String username, @Param("md5Password") String md5Password);
}
