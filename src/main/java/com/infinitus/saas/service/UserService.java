package com.infinitus.saas.service;

import com.github.pagehelper.Page;
import com.infinitus.saas.entity.User;

import java.util.List;
import java.util.Map;

/**
 * <dl>
 * <dd>Description: User Service Interface</dd>
 * <dd>Company: 大城若谷信息技术有限公司</dd>
 * <dd>@date：2016/12/13 上午11:47</dd>
 * <dd>@author：aaron</dd>
 * </dl>
 */
public interface UserService {

    /**
     * 插入用户
     *
     * @param user 用户
     */
    int insert(User user);

    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return
     */
    User getByUsername(String username);

    /**
     * 查询用户信息
     *
     * @param params 查询参数
     * @param offset 起始页
     * @param limit  页大小
     * @return
     */
    Page<User> select(Map<String, Object> params, int offset, int limit);

    /**
     * 更新用户信息
     *
     * @param user 用户信息
     */
    int update(User user);

    /**
     * 根据id查询用户信息
     *
     * @param id 用户id
     * @return
     */
    User getById(Integer id);


    /**
     *
     *
     * @return list
     */
    List<User> getList();
}
