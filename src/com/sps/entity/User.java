package com.sps.entity;

import java.util.Arrays;
import java.util.List;

/**
 * 用户实体类
 */

@SuppressWarnings("serial")
public class User implements java.io.Serializable {

	public static class Role {

		public static int ADMIN = 0;

		public static int NURSE = 1;
		public static int WORKER = 2;

		public static int SEND = 3;
		public static int DOCTOR = 4;

		public static int CHIEF = 5;

		private String name;

		private Integer value;

		public Role() {
			super();
		}

		public Role(String name, Integer value) {
			super();
			this.name = name;
			this.value = value;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getValue() {
			return value;
		}

		public void setValue(Integer value) {
			this.value = value;
		}

		public static List<Role> allRoles() {
			return Arrays.asList(new Role("管理人员", ADMIN), new Role("手术室护士",
					NURSE), new Role("病理科工作人员", WORKER),
					new Role("送检人员", SEND), new Role("医生", DOCTOR), new Role(
							"科长", CHIEF));
		}

	}

	private String id;
	private String name;
	private String password;
	private Integer status;
	private String wtfk;

	public User() {
	}

	public User(String id, String name, String password, Integer status) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.status = status;
	}

	public User(String id, String name, String password, Integer status,
			String wtfk) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.status = status;
		this.wtfk = wtfk;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getWtfk() {
		return this.wtfk;
	}

	public void setWtfk(String wtfk) {
		this.wtfk = wtfk;
	}

}