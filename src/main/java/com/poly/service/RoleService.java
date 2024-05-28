package com.poly.service;

import java.util.List;

import com.poly.entity.Role;
import com.poly.entity.User;

public interface RoleService {

	List<Role> getAllRoles();
	
	Role createRole(Role role);
	
	void deleteRole(Integer roleId);
	
	Role findRoleByName(String name);
	
	Role findRoleById(Integer roleId);
	
	User removeUserFromRole(Long userId, Integer roleId);
	
	User assignUserToRole(Long userId, Integer roleId);
	
	Role removeAllUserFromRole(Integer roleId);
}
