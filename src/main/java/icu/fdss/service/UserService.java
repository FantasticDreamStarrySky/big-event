package icu.fdss.service;

import icu.fdss.entity.User;

/**
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
}