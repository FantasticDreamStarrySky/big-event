package icu.fdss.service;

import icu.fdss.entity.User;

/**
 * 用户服务
 *
 * @author 🌃梦幻◎星空🌃
 * @apiNote 用户服务接口
 */
public interface UserService {
    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return {@link User}
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

    /**
     * 更新用户头像
     *
     * @param avatarUrl 头像地址
     */
    void updateAvatar(String avatarUrl);

    /**
     * 更新用户密码
     *
     * @param newPwd 新密码
     */
    void updatePwd(String newPwd);
}
