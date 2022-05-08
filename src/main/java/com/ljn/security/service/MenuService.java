package com.ljn.security.service;

import com.ljn.security.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author ljn
 * @since 2022-05-07
 */
public interface MenuService extends IService<Menu> {
    List<String> getPermissionsByUserId(Long userId);
}
