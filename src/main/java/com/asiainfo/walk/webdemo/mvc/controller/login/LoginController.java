package com.asiainfo.walk.webdemo.mvc.controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.walkframework.base.tools.spring.SpringContextHolder;
import org.walkframework.shiro.util.AuthErrorUtil;

import com.asiainfo.walk.webdemo.mvc.controller.app.AppController;

/**
 * 	退出请求
 *
 */
@RestController
public class LoginController extends AppController {
	
	/**
	 * 	登录
	 * 
	 * @return
	 */
	@RequestMapping(value = "login")
	public ModelAndView login(Model model) {
		String failureKeyAttribute = SpringContextHolder.getBean(FormAuthenticationFilter.class).getFailureKeyAttribute();
        model.addAttribute("error", AuthErrorUtil.getErrorInfo((AuthenticationException)subject.getSession().getAttribute(failureKeyAttribute)));
        subject.getSession().removeAttribute(failureKeyAttribute);
        if (subject.isAuthenticated()) {
        	subject.logout();
        }
		return new ModelAndView("login/Login");
	}
	
	/**
	 * 	登录判断
	 * 
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/login/formlogin")
	public void formlogin(HttpServletRequest request, HttpServletResponse response) throws Exception{
		if (subject.isAuthenticated()) {
			WebUtils.issueRedirect(request, response, "/main");
		}
	}
	
	/**
	 * 	退出请求
	 * 
	 * @return
	 */
	@RequestMapping(value = "logoutProxy")
	public Object logoutProxy() {
		ModelAndView mv = new ModelAndView("login/LogoutProxy");
		return mv;
	}
}