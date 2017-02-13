package com.infinitus.saas.mapper;


import com.infinitus.saas.entity.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbggenerated Tue Dec 13 10:52:59 CST 2016
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbggenerated Tue Dec 13 10:52:59 CST 2016
     */
    int insert(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbggenerated Tue Dec 13 10:52:59 CST 2016
     */
    int insertSelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbggenerated Tue Dec 13 10:52:59 CST 2016
     */
    User selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbggenerated Tue Dec 13 10:52:59 CST 2016
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbggenerated Tue Dec 13 10:52:59 CST 2016
     */
    int updateByPrimaryKey(User record);

    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return
     */
    User getByUsername(String username);

    /**
     * 查询用户列表
     *
     * @param params 查询参数
     * @return
     */
    List<User> select(Map<String, Object> params);

    /**
     * 获取所有用户
     *
     * @return
     */
    List<User> getAll();
}