package com.kingland.dhrm2193.service;

import com.kingland.dhrm2193.bean.User;
import com.kingland.dhrm2193.mapper.UserMapper;
import com.kingland.dhrm2193.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * UserService
 *
 * @author Rooney
 * @version 1.0
 * @date 2020/7/24 7:51 AM
 * @description
 */
@Service
@Slf4j
public class UserService implements UserDetailsService {

    /**
     * string constant，space
     */
    public static final String SPACE = " ";

    /**
     * user Mapper
     */
    final UserMapper userMapper;

    /**
     * injection by construction method
     *
     * @param userMapper user Mapper
     */
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * override loadUserByUsername method
     *
     * @param username user name
     * @return user info
     * @throws UsernameNotFoundException user name not found exception
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // log
        log.info("****** service, username : " + username);
        // if username is null, throw usernameNotFoundException
        Utils.isNull(username, "Please input username！");
        // list is used to save permissions
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        // query user info by username
        User user = userMapper.queryUserByName(username);
        // if user is null, throw usernameNotFoundException
        Utils.isNull(user, "username does not exist!");
        // Traverse add permission
        for (String s : user.getRole().split(SPACE)) {
            // add permission to list
            list.add(new SimpleGrantedAuthority("ROLE_" + s));
        }
        // log
        log.info("****** service, role : " + list);
        // Return the user object with permission information
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), list);
    }

    /**
     * user register
     *
     * @param user user
     * @throws UsernameNotFoundException username not found exception
     */
    public void register(User user) throws UsernameNotFoundException {
        // if username is null, throw UsernameNotFoundException
        Utils.isNull(user.getUsername(), "Please input username！");
        // if password is null, throw UsernameNotFoundException
        Utils.isNull(user.getPassword(), "Please input password！");
        // Query whether there is a user with the same name in the database
        User temp = userMapper.queryUserByName(user.getUsername());
        // If the user name is already occupied
        if (null != temp) {
            throw new UsernameNotFoundException("username already exists!");
        }
        // use BCrypt to strengthen password
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        // set the basic field for user register
        Utils.setUser(user);
        // log
        log.info("****** service, user regist : " + user);
        // If the insertion of the database fails, throw exception
        if (userMapper.addUser(user) != 1) {
            throw new UsernameNotFoundException("Failed to insert user！");
        }
    }
}