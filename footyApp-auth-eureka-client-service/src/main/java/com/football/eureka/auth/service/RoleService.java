package com.football.eureka.auth.service;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.JpaRepository;

import com.football.eureka.auth.entity.RoleEntity;
import java.lang.String;
import java.util.List;

@Resource
public interface RoleService extends JpaRepository<RoleEntity, Integer> {

	 List<RoleEntity> findByRoleName(String rolename);
}

