package com.football.eureka.auth.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name="Role")
@Entity
public class RoleEntity {

	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	@Column(name="role_id")
	private int id;
	
	@Column(name="Role_name")
	private String roleName;
	

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userRoleId")
	Set<UserEntity> userSet;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Set<UserEntity> getUserSet() {
		return userSet;
	}

	public void setUserSet(Set<UserEntity> userSet) {
		this.userSet = userSet;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	
	
}
