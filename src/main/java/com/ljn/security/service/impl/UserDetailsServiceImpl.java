package com.ljn.security.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ljn.security.entity.User;
import com.ljn.security.mapper.MenuMapper;
import com.ljn.security.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", username);
        User user = userMapper.selectOne(queryWrapper);
        if (Objects.isNull(user)) {
            throw new RuntimeException("用户名不存在");
        }
//        List<String> authorities = new ArrayList<>(Arrays.asList("test", "admin"));
        List<String> authorities = menuMapper.getPermissionsByUserId(user.getId());
        UserDetailsImpl userDetails = new UserDetailsImpl(user, authorities);
        return userDetails;
    }
}
