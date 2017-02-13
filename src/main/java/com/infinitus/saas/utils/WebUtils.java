package com.infinitus.saas.utils;

import com.infinitus.saas.entity.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhangmin
 */
public class WebUtils {

	public static final String ENCODING_UTF8 = "utf-8";
	public static final String ENCODING_GBK = "GBK";

	public static final String USER_SESSION_ATTR = "user_session_attr";

	private WebUtils() {
	}

	/**
	 * 返回站点访问Base路径
	 * 
	 * @return http://localhost:8080/ctxPath
	 */
	public static String getBaseSiteUrl(HttpServletRequest request) {
		final StringBuilder basePath = new StringBuilder();
		basePath.append(request.getScheme()).append("://").append(request.getServerName());
		if (request.getServerPort() != 80) {
			basePath.append(":").append(request.getServerPort());
		}
		basePath.append(request.getContextPath());
		return basePath.toString();
	}

	public static boolean isAjaxRequest(HttpServletRequest req) {
		String constant = "x-requested-with";
		String xRequestedWith = req.getHeader(constant);
		return StringUtils.isNotBlank(xRequestedWith) && StringUtils.equalsIgnoreCase(xRequestedWith, "XMLHttpRequest");
	}

	/**
	 * 发生业务错误，或请求参数不符合条件，响应400状态码.
	 * 
	 * @param message 错误信息, 直接作为HTTP body输出
	 */
	@SuppressWarnings("unchecked")
	public static ResponseEntity response400(String message) {
		return new ResponseEntity(message, null, HttpStatus.BAD_REQUEST);
	}

	/**
	 * 发生服务器内部错误，响应500状态码.
	 * 
	 * @param message 错误信息, 直接作为HTTP body输出
	 */
	@SuppressWarnings("unchecked")
	public static ResponseEntity response500(String message) {
		return new ResponseEntity(message, null, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public static ResponseEntity RESPONSE_200 = new ResponseEntity(HttpStatus.OK);

	/**
	 * 手机号验证
	 * 
	 * @param str
	 * @return 验证通过返回true
	 */
	public static boolean isMobile(String str) {
		Pattern p = null;
		Matcher m = null;
		boolean b = false;
		p = Pattern.compile("^[1][0-9]{10}$"); // 验证手机号
		m = p.matcher(str);
		b = m.matches();
		return b;
	}

	/**
	 * 电话号码验证
	 * 
	 * @param str
	 * @return 验证通过返回true
	 */
	public static boolean isPhone(String str) {
		Pattern p1 = null, p2 = null;
		Matcher m = null;
		boolean b = false;
		p1 = Pattern.compile("^[0][1-9]{2,3}-[0-9]{5,10}$"); // 验证带区号的
		p2 = Pattern.compile("^[1-9]{1}[0-9]{5,8}$"); // 验证没有区号的
		if (str.length() > 9) {
			m = p1.matcher(str);
			b = m.matches();
		} else {
			m = p2.matcher(str);
			b = m.matches();
		}
		return b;
	}

	/**
	 * 获取当前登录用户
	 * 
	 * @param request request
	 * @return
	 */
	public static User getLoggedUser(HttpServletRequest request) {
		if (request != null) {
			Object o = request.getSession().getAttribute(USER_SESSION_ATTR);
			if (o != null)
				return (User) o;
		}
		return null;
	}

	/**
	 * 获取当前登录用户的id
	 * 
	 * @param request request
	 * @return
	 */
	public static Integer getLoggedUserId(HttpServletRequest request) {
		User user = getLoggedUser(request);
		if (user != null)
			return user.getId();
		return null;
	}

	/**
	 * 判断用户是否登录
	 * 
	 * @param req request
	 * @return
	 */
	public static boolean isLogin(HttpServletRequest req) {
		if (getLoggedUser(req) != null)
			return true;
		return false;
	}
}