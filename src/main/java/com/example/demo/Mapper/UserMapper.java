package com.example.demo.Mapper;

import com.example.demo.Dao.User;
import org.apache.ibatis.annotations.*;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user")
    public List<User> findAll() ;

    /*
    @Insert(" insert into message values (#{messageid,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, #{idcode,jdbcType=CHAR}, #{sex,jdbcType=VARCHAR}, #{birthday,jdbcType=DATE}, #{emptype,jdbcType=VARCHAR},#{isdispose,jdbcType=VARCHAR})")
    public int insertIntoByAnnotation(Message message) throws SQLException;

    @Select("select * from message where messageid = #{messageId}")
    public Message getMessageById(@Param("messageId")String messageId)throws SQLException;

    @Update("update message set name=#{name} where messageid=#{messageid}")
    public int updateMessageById(Message message)throws SQLException;

    @Select("select * from message where messageid = #{messageId}")
    public Map getMessageMapById(@Param("messageId")String messageId)throws SQLException;

    @Delete("delete from message where messageid = #{messageId}")
    public int deleteByMessageId(@Param("messageId")String messageid)throws SQLException;
     */
    @Insert("insert into user (username,password) values (#{username},#{password})")
    public  void insertIntoUser(User user) ;
    @Update("update user set password = #{password} where username = #{username}")
    public void updateUser(User user);
    @Delete("delete from user where username = #{username}")
    public void deleteUser(@Param("username")String username);
    @Select("select * from user where id = #{id}")
    User findById(@Param("id") int id);
}
