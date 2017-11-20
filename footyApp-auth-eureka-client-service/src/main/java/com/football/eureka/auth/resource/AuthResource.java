package com.football.eureka.auth.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.football.eureka.auth.entity.RoleEntity;
import com.football.eureka.auth.entity.UserEntity;
import com.football.eureka.auth.service.RoleService;
import com.football.eureka.auth.service.UserService;

@RestController
@RequestMapping("/football")
public class AuthResource {

	@Autowired
	RoleService roleService;
	@Autowired
	UserService userService;

	@PostMapping("/adduser/{username}/{roleName}/{email}")

	public String addUser(@PathVariable("username") final String userName,
			@PathVariable("roleName") final String roleName, @PathVariable("email") final String email,
			@RequestHeader HttpHeaders header) throws Exception {
		if (header.isEmpty() || null == header.get("password")) {
			throw new Exception("Invalid Headers passed");
		}
		String password = header.get("password").get(0);
		List<RoleEntity> roleIdList = getRoleByName(roleName);

		if (roleIdList.isEmpty()) {
			throw new Exception("Role name passed does not exist");
		}
		RoleEntity role = roleIdList.get(0);
		UserEntity user = getUserByEmail(email);
		if (null == user) {

			user = new UserEntity();
			user.setUserName(userName);
			user.setEmail(email);
			user.setUserRoleId(role);
			user.setPassword(password);
			userService.save(user);
		}

		return "User :" + userName + " added successfully";
	}

	@PostMapping("/addrole/{roleName}")
	public String addRole(@PathVariable("roleName") final String roleName) {
		RoleEntity role = new RoleEntity();
		role.setRoleName(roleName);
		roleService.save(role);
		return "role " + roleName + " saved";
	}

	private List<RoleEntity> getRoleByName(String roleName) throws Exception {

		return roleService.findByRoleName(roleName);
	}

	private UserEntity getUserByEmail(String email) {
		return userService.findByEmail(email);

	}
}
