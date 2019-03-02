package com.sps.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
/**
 * 
 * 自定义拦截器
 *
 */
@SuppressWarnings("serial")
public class AuthInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		ActionContext ac=ActionContext.getContext();
		if(ac.getSession().get("existUser")!=null){
			String result=invocation.invoke();//invocation.invoke()返回的值是方法名，如login,saveUI,findAll
			return result;
		}else{
			return "login";
		}
	}
	 
		
}
