package com.poly.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.RoleDAO;
import com.poly.dao.UserDAO;
import com.poly.entity.Role;
import com.poly.entity.User;
import com.poly.exception.RoleAlreadyExistException;
import com.poly.exception.UserAlreadyExistException;
import com.poly.exception.UserNotFoundException;
import com.poly.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleDAO roleDAO;
	
	@Autowired
	UserDAO userDAO;

	@Override
	public List<Role> getAllRoles() {

		return roleDAO.findAll();
	}

	@Override
	public Role createRole(Role role) {
		Optional<Role> checkRole = roleDAO.findByName(role.getName());

		if (checkRole.isPresent()) {
			throw new RoleAlreadyExistException(checkRole.get().getName() + "role already exist");
		}

		return roleDAO.save(role);
	}

	@Override
	public void deleteRole(Integer roleId) {
		this.removeAllUserFromRole(roleId);
		roleDAO.deleteById(roleId);
	}

	@Override
	public Role findRoleByName(String name) {

		return roleDAO.findByName(name).get();
	}

	@Override
	public Role findRoleById(Integer roleId) {

		return roleDAO.findById(roleId).get();
	}

	@Override
	public User removeUserFromRole(Long userId, Integer roleId) {
		Optional<User> user = userDAO.findById(userId);
		Optional<Role> role = roleDAO.findById(roleId);
		
		if (role.isPresent() && role.get().getUsers().contains(user.get())) {
			role.get().removeUserFromRole(user.get());
			roleDAO.save(role.get());
			return user.get();
		}
		
		throw new UserNotFoundException("User not found");
	}

	@Override
	public User assignUserToRole(Long userId, Integer roleId) {
		Optional<User> user = userDAO.findById(userId);
		Optional<Role> role = roleDAO.findById(roleId);
		
		if (user.isPresent() && user.get().getRoles().contains(role.get())) {
			throw new UserAlreadyExistException(user.get().getName() + "is already assigned to the" + role.get().getName());
		}
		
		role.ifPresent(theRole -> theRole.assignUserToRole(user.get()));
		roleDAO.save(role.get());
		
		return user.get();
	}

	@Override
	public Role removeAllUserFromRole(Integer roleId) {
		Optional<Role> role = roleDAO.findById(roleId);
		role.ifPresent(Role::removeAllUsersFromRole);
		return roleDAO.save(role.get());
	}

}
