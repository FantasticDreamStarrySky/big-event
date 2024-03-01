package icu.fdss.mapper;

import icu.fdss.entity.User;
import org.apache.ibatis.annotations.*;

/**
 * 用户映射器
 *
 * @author 🌃梦幻◎星空🌃
 * @apiNote 用户映射器
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

    /**
     * 更新用户
     *
     * @param user 用户
     * @apiNote 更新用户信息
     */
    @Update("update user set nickname=#{nickname},email=#{email},update_time=#{updateTime} where id=#{id}")
    void update(User user);

    /**
     * 更新用户头像
     *
     * @param avatarUrl 头像地址
     * @param id        用户ID
     */
    @Update("update user set user_pic=#{avatarUrl},update_time=now() where id=#{id}")
    void updateAvatar(@Param("avatarUrl") String avatarUrl, @Param("id") Integer id);

    /**
     * 更新用户密码
     *
     * @param md5String 新密码
     * @param id        用户ID
     */
    @Update("update user set password=#{md5String},update_time=now() where id=#{id}")
    void updatePwd(@Param("md5String") String md5String, @Param("id") Integer id);
}
