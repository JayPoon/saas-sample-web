package com.infinitus.saas.rest;

import com.infinitus.saas.entity.User;
import com.infinitus.saas.service.UserService;
import com.infinitus.saas.utils.PasswordUtils;
import com.infinitus.saas.vo.StatusDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <dl>
 * <dd>Description: 用户管理模块</dd>
 * <dd>Company: 大城若谷信息技术有限公司</dd>
 * <dd>@date：2016/12/13 上午11:51</dd>
 * <dd>@author：aaron</dd>
 * </dl>
 */
@RestController
@RequestMapping(value = "/api/users")
public class UserRestController {

    @Autowired
    private UserService userService;


    /**
     * 用户注册
     *
     * @param username        用户名
     * @param password        密码
     * @param confirmPassword 确认密码
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Object register(@RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String email,
                           @RequestParam String confirmPassword) {
        if (StringUtils.isAnyBlank(username, password, email, confirmPassword)) {
            return StatusDto.buildFailureStatus("参数不完整！");
        }
        if (!password.equals(confirmPassword)) {
            return StatusDto.buildFailureStatus("密码与确认密码不相同！");
        }
        if (this.userService.getByUsername(username) != null) {
            return StatusDto.buildFailureStatus("用户名已被注册");
        }

        String salt = PasswordUtils.generateSalt();
        String encryptPwd = PasswordUtils.encrypt(password, salt);

        User user = new User(username, encryptPwd);

        int i = this.userService.insert(user);

        if (i < 1)
            return StatusDto.buildFailureStatus("注册失败！");

        return StatusDto.buildSuccessStatus("注册成功");
    }

    /**
     * 添加管理员用户 用户名和密码相同
     *
     * @param username 用户名
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object add(@RequestParam String username) {
        if (StringUtils.isBlank(username))
            return StatusDto.buildFailureStatus("用户名不能为空");

        String salt = PasswordUtils.generateSalt();
        String pwd = PasswordUtils.encrypt(username, salt);

        User u = new User(username, pwd);

        int i = this.userService.insert(u);

        if (i < 1)
            return StatusDto.buildFailureStatus("添加失败！");

        return StatusDto.buildSuccessStatus("注册成功");
    }

    /**
     * 更新用户信息
     *
     * @param user 用户信息
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Object update(User user) {
        if (user != null) {
            this.userService.update(user);
        }
        return StatusDto.buildSuccessStatus("操作成功");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Object detail(@PathVariable Integer id) {
        return StatusDto.buildSuccessStatus().append("user", userService.getById(id));
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Object list() {
        return StatusDto.buildSuccessStatus().append("users", userService.getList());
    }

}
