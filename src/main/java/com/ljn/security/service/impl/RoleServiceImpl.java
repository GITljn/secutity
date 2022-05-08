package com.ljn.security.service.impl;

import com.ljn.security.entity.Role;
import com.ljn.security.mapper.RoleMapper;
import com.ljn.security.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author ljn
 * @since 2022-05-07
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
