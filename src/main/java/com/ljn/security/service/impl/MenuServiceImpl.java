package com.ljn.security.service.impl;

import com.ljn.security.entity.Menu;
import com.ljn.security.mapper.MenuMapper;
import com.ljn.security.service.MenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author ljn
 * @since 2022-05-07
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<String> getPermissionsByUserId(Long userId) {
        return menuMapper.getPermissionsByUserId(userId);
    }
}
