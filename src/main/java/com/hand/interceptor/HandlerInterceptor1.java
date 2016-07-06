package com.hand.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class HandlerInterceptor1 implements HandlerInterceptor{

	//进入handler方法之前执行
	//用于身份认证，身份授权
	//如果认证不通过，表明没有登录，需要此方法拦截
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
	
		String url=request.getRequestURI();
		//判断公开地址，这里就是登录提交的地址
		if(url.indexOf("login.do")>=0||url.indexOf("customerListPage.do")>=0){
			return true;
		}
		//判断session
		HttpSession session=request.getSession();
		String username=(String) session.getAttribute("username");
		if(username!=null){
			//存在，通过
			return true;
		}
		
		//前面都没通过，所以需要跳转到login.jsp
		//res.getRequestDispatcher("login.jsp").forward(request, response);
		response.sendRedirect("login.jsp");
		//return false标识拦截住，不往下执行，return true就往下执行。
		return false;
	}

	//进入handler方法后，返回modelAndView之前执行
	//应用场景modelAndView出发，将公用的模型数据传到视图。
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
		
	}
	
	//应用场景：同一异常处理
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

		
	}

}
