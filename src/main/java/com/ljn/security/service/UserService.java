package com.ljn.security.service;

import com.ljn.security.common.R;
import com.ljn.security.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author ljn
 * @since 2022-05-05
 */
public interface UserService extends IService<User> {

    R login(User user);

    R logout();
}
