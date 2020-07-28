package com.kingland.demo.mapper;

import com.kingland.demo.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * UserMapper
 *
 * @author Rooney
 * @version 1.0
 * @date 2020/7/23 11:02 PM
 * @description
 */
@Mapper
@Repository
public interface UserMapper {
    /**
     * select user info by user name
     *
     * @param username user name
     * @return user object
     */
    @Select("select * from user_info where username = #{username}")
    User queryUserByName(String username);

    /**
     * add user
     *
     * @param user user
     * @return number of affected rows
     */
    @Insert("insert into user_info(username,password,role,describe) values(#{username},#{password},#{role},#{describe})")
    int addUser(User user);
}
