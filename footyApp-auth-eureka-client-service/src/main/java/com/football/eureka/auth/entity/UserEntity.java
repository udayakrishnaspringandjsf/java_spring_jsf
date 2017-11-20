package com.football.eureka.auth.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class UserEntity {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	@Column(name = "user_id")
	private int id;
	
	@Column(name="userName")
	private String userName;
	
	
	@Column(name="password")
	private String password;

	@Column(name="email")
	private String email;
	
	@ManyToOne
    @JoinColumn(name="user_role_id", nullable=false)
    private RoleEntity userRoleId;

	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}





	public RoleEntity getUserRoleId() {
		return userRoleId;
	}


	public void setUserRoleId(RoleEntity userRoleId) {
		this.userRoleId = userRoleId;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
