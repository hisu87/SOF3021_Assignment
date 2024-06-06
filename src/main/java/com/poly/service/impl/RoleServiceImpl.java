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

/**
 * Lớp RoleServiceImpl triển khai giao diện RoleService và cung cấp các phương
 * thức để quản lý vai trò trong hệ thống.
 */
@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleDAO roleDAO;

	@Autowired
	UserDAO userDAO;

	/**
	 * Phương thức lấy danh sách tất cả các vai trò trong hệ thống.
	 *
	 * @return Danh sách các vai trò.
	 */
	@Override
	public List<Role> getAllRoles() {
		return roleDAO.findAll();
	}

	/**
	 * Phương thức tạo mới một vai trò.
	 *
	 * @param role Vai trò cần tạo.
	 * @return Vai trò đã được tạo.
	 * @throws RoleAlreadyExistException Nếu vai trò đã tồn tại trong hệ thống.
	 */
	@Override
	public Role createRole(Role role) throws RoleAlreadyExistException {
		Optional<Role> checkRole = roleDAO.findByName(role.getName());

		if (checkRole.isPresent()) {
			throw new RoleAlreadyExistException(checkRole.get().getName() + "role already exist");
		}

		return roleDAO.save(role);
	}

	/**
	 * Phương thức xóa một vai trò.
	 *
	 * @param roleId ID của vai trò cần xóa.
	 */
	@Override
	public void deleteRole(Integer roleId) {
		this.removeAllUserFromRole(roleId);
		roleDAO.deleteById(roleId);
	}

	/**
	 * Phương thức tìm kiếm vai trò theo tên.
	 *
	 * @param name Tên của vai trò cần tìm.
	 * @return Vai trò tìm được.
	 */
	@Override
	public Role findRoleByName(String name) {
		return roleDAO.findByName(name).get();
	}

	/**
	 * Phương thức tìm kiếm vai trò theo ID.
	 *
	 * @param roleId ID của vai trò cần tìm.
	 * @return Vai trò tìm được.
	 */
	@Override
	public Role findRoleById(Integer roleId) {
		return roleDAO.findById(roleId).get();
	}

	/**
	 * Phương thức gỡ bỏ người dùng khỏi vai trò.
	 *
	 * @param userId ID của người dùng cần gỡ bỏ.
	 * @param roleId ID của vai trò.
	 * @return Người dùng đã được gỡ bỏ khỏi vai trò.
	 * @throws UserNotFoundException Nếu người dùng không tồn tại.
	 */
	@Override
	public User removeUserFromRole(Long userId, Integer roleId) throws UserNotFoundException {
		Optional<User> user = userDAO.findById(userId);
		Optional<Role> role = roleDAO.findById(roleId);

		if (role.isPresent() && role.get().getUsers().contains(user.get())) {
			role.get().removeUserFromRole(user.get());
			roleDAO.save(role.get());
			return user.get();
		}

		throw new UserNotFoundException("User not found");
	}

	/**
	 * Phương thức gán người dùng vào vai trò.
	 *
	 * @param userId ID của người dùng cần gán.
	 * @param roleId ID của vai trò.
	 * @return Người dùng đã được gán vào vai trò.
	 * @throws UserAlreadyExistException Nếu người dùng đã được gán vào vai trò
	 *                                   trước đó.
	 */
	@Override
	public User assignUserToRole(Long userId, Integer roleId) throws UserAlreadyExistException {
		Optional<User> user = userDAO.findById(userId);
		Optional<Role> role = roleDAO.findById(roleId);

		if (user.isPresent() && user.get().getRoles().contains(role.get())) {
			throw new UserAlreadyExistException(
					user.get().getName() + "is already assigned to the" + role.get().getName());
		}

		role.ifPresent(theRole -> theRole.assignUserToRole(user.get()));
		roleDAO.save(role.get());

		return user.get();
	}

	/**
	 * Phương thức gỡ bỏ tất cả người dùng khỏi vai trò.
	 *
	 * @param roleId ID của vai trò.
	 * @return Vai trò đã được gỡ bỏ tất cả người dùng.
	 */
	@Override
	public Role removeAllUserFromRole(Integer roleId) {
		Optional<Role> role = roleDAO.findById(roleId);
		role.ifPresent(Role::removeAllUsersFromRole);
		return roleDAO.save(role.get());
	}
}
