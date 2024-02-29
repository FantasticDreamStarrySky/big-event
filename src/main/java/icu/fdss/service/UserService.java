package icu.fdss.service;

import icu.fdss.entity.User;

/**
 * 用户服务
 *
 * @author 🌃梦幻◎星空🌃
 */
public interface UserService {
    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return {@link User 用户实体类}
     */
    User findByUserName(String username);

    /**
     * 注册
     *
     * @param username 用户名
     * @param password 密码
     */
    void register(String username, String password);

    /**
     * 更新用户
     *
     * @param user 用户
     * @apiNote 更新用户信息
     */
    void update(User user);
}
