package com.sibu.xinweishang.api.model;

import org.hibernate.validator.constraints.NotEmpty;

public class User {
	private int id;
	private int state;
	private String nickname;
	private String user_id;
	
	private Long organizationId; //�?属公�?
    public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Boolean getLocked() {
		return locked;
	}

	public void setLocked(Boolean locked) {
		this.locked = locked;
	}

	private String username; //用户�?
    private String password; //密码
    private String salt; //加密密码的盐
    private Boolean locked = Boolean.FALSE;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
	@NotEmpty(message="用户昵称不能为空")
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", state=" + state + ", nickname=" + nickname
				+ "]";
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	

    public String getCredentialsSalt() {
        return username + salt;
    }

}
