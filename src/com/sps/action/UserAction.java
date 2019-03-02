package com.sps.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sps.entity.PageBean;
import com.sps.entity.User;
import com.sps.service.UserService;

/**
 * 用户Action
 * 
 */
@SuppressWarnings("serial")
public class UserAction extends ActionSupport implements ModelDriven<User> {
	private User user = new User();
	private List<User.Role> roleList;

	@Override
	public User getModel() {
		return user;
	}

	private Integer currPage = 1;

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	// 注入业务层的类
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	// 接收验证码
	private String checkcode;

	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}

	private String path;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	HttpSession session = null;

	/**
	 * 用户登录
	 */
	public String login() {
		// 判断验证码程序
		// 从Session中获得验证码的随机值
		String checkcode1 = (String) ServletActionContext.getRequest()
				.getSession().getAttribute("checkcode");
		// 调用业务层
		User existUser = userService.UserLogin(user);
		if (existUser == null || !checkcode.equalsIgnoreCase(checkcode1)) {
			this.addActionError("用户名或密码错误");
			return INPUT;
		} else {
			HttpServletRequest request = ServletActionContext.getRequest();
			session = request.getSession(false);
			session.setAttribute("userName", user.getName());
			ActionContext.getContext().getSession().put("existUser", existUser);
			if (existUser.getStatus() == 0) {
				path = "/manager/main.jsp";
			} else if (existUser.getStatus() == 1) {
				path = "/nurse/main.jsp";
			} else if (existUser.getStatus() == 2) {
				path = "/work/main.jsp";
			} else if (existUser.getStatus() == 3) {
				path = "/send/main.jsp";
			} else {
				path = "/doctor/main.jsp";
			}
			return SUCCESS;
		}
	}

	// 查找全部用户
	public String findAll() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		PageBean<User> pageBean = userService.findByPage(currPage, id);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}

	// 查找全部问题反馈
	public String findwtAll() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		PageBean<User> pageBean = userService.findwtByPage(currPage, id);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findwtAll";
	}

	// 跳转问题处理页面的动作
	public String wtclUI() {
		// 根据用户Id查询用户
		user = userService.findById(user.getId());
		this.roleList = User.Role.allRoles();
		List<User> list = userService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);// 集合用SET，对象用PUSh
		return "wtclUI_ok";
	}

	// 问题处理的动作
	public String wtcl() {
		userService.update(user);
		return "wtcl_ok";
	}

	// 跳转到添加用户的动作
	public String saveUI() {
		this.roleList = User.Role.allRoles();
		List<User> list = userService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);// 集合用SET，对象用PUSh
		return "saveUI_ok";
	}

	// 添加用户的动作
	public String add() {
		userService.save(user);
		return "add_ok";
	}

	// 跳转到修改用户页面的动作
	public String editUI() {
		user = userService.findById(user.getId());
		this.roleList = User.Role.allRoles();
		return "editUI_ok";
	}

	// 修改用户的动作
	public String edit() {
		userService.update(user);
		return "edit_ok";
	}

	// 跳转问题反馈页面的动作
	public String wtfkUI() {
		user = userService.findById(user.getId());
		this.roleList = User.Role.allRoles();
		return "wtfkUI_ok";
	}

	// 问题反馈提交的动作
	public String wtfk() {
		userService.update(user);
		return "wtfk_ok";
	}

	// 跳转修改密码页面的动作
	public String updateUI() {
		// 根据标本Id查询用户
		user = userService.findById(user.getId());
		List<User> list = userService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);// 集合用SET，对象用PUSh
		return "updateUI_ok";
	}

	// 修改密码动作
	public String update() {
		user = userService.findById(user.getId());
		String opwd = $rq("opassword");
		String pwd = $rq("npassword");
		String confirmPwd = $rq("confirmPwd");
		if (compare(pwd, confirmPwd) && compare(opwd, user.getPassword())) {
			HttpServletRequest request = ServletActionContext.getRequest();
			session = request.getSession(false);
			user.setPassword(pwd);
			userService.update(user);
			return "update_ok";
		} else {
			return "updateUI_ok";
		}

	}

	// 删除用户的动作
	public String delete() {
		user = userService.findById(user.getId());
		userService.delete(user);
		return "user_delete_ok";
	}

	// 用户退出的动作
	public String exist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().removeAttribute("user");
		return "user_exist_ok";
	}

	public List<User.Role> getRoleList() {
		return roleList;
	}

	public <T> T $rq(String key) {
		@SuppressWarnings("unchecked")
		T obj = (T) ServletActionContext.getRequest().getParameter(key);
		return obj;
	}

	public static boolean compare(String a, String b) {
		if (a == b) {
			return true;
		}
		if (a == null) {
			return false;
		}

		return a.equals(b);
	}
}
