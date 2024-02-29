package icu.fdss.service.impl;

import icu.fdss.entity.User;
import icu.fdss.mapper.UserMapper;
import icu.fdss.service.UserService;
import icu.fdss.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * 用户服务实现类
 *
 * @author 🌃梦幻◎星空🌃
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return {@link User 用户实体类}
     */
    @Override
    public User findByUserName(String username) {
        return userMapper.findByUserName(username);
    }

    /**
     * 注册
     *
     * @param username 用户名
     * @param password 密码
     */
    @Override
    public void register(String username, String password) {
        // 密码加密
        String md5Password = Md5Util.getMD5String(password);
        // 注册
        userMapper.add(username, md5Password);
    }

    /**
     * 更新用户
     *
     * @param user 用户
     * @apiNote 更新用户信息
     */
    @Override
    public void update(User user) {
        user.setUpdateTime(LocalDateTime.now());
        userMapper.update(user);
    }
}
