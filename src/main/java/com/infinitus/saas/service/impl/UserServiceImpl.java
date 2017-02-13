package com.infinitus.saas.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.infinitus.saas.entity.User;
import com.infinitus.saas.mapper.UserMapper;
import com.infinitus.saas.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * <dl>
 * <dd>Description: </dd>
 * <dd>Company: 大城若谷信息技术有限公司</dd>
 * <dd>@date：2016/12/13 上午11:48</dd>
 * <dd>@author：aaron</dd>
 * </dl>
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 插入用户
     *
     * @param user 用户
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int insert(User user) {
        return this.userMapper.insert(user);
    }

    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return
     */
    @Override
    public User getByUsername(String username) {
        if (StringUtils.isEmpty(username))
            return null;
        return this.userMapper.getByUsername(username);
    }

    /**
     * 查询用户信息
     *
     * @param params 查询参数
     * @param offset 起始记录
     * @param limit  页大小
     * @return
     */
    @Override
    public Page<User> select(Map<String, Object> params, int offset, int limit) {
        PageHelper.offsetPage(offset, limit);
        List<User> users = this.userMapper.select(params);
        return (Page<User>) (users);
    }

    @Override
    public int update(User user) {
        return this.userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public User getById(Integer id) {
        if (id != null)
            return this.userMapper.selectByPrimaryKey(id);
        return null;
    }

    @Override
    public List<User> getList() {
        return this.userMapper.getAll();
    }
}
