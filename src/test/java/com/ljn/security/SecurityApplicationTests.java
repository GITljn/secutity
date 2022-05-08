package com.ljn.security;

import com.ljn.security.entity.User;
import com.ljn.security.mapper.UserMapper;
import com.ljn.security.service.MenuService;
import com.ljn.security.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootTest
class SecurityApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    void testMybatisPlus() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

    @Test
    void testPasswordEncoder() {
        String encode = passwordEncoder.encode("123");
        System.out.println(encode);
    }
    @Test
    void testJwt() {
        String jwt = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ4eHgiLCJpYXQiOjE2NTE4MjEzNTEsIm5iZiI6MTY1MTgyMTM1MSwiZXhwIjoxNjUxOTA3NzUxLCJpZCI6IjEiLCJ1c2VybmFtZSI6ImxqbiJ9.Ah6nlqS3CRRMuP4eQAfGP2VP5XBfx32Upzg6CWfR9EM";
        Claims claims = JwtUtil.parseJwt2Claims(jwt);
        System.out.println("userId: " + claims.get("id", String.class));
        System.out.println("username: " + claims.get("username", String.class));
    }

    @Autowired
    private MenuService menuService;

    @Test
    void testGetPermissions() {
        List<String> permissions = menuService.getPermissionsByUserId(2L);;
        System.out.println(permissions);
    }

}
