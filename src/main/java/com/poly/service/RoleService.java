package com.poly.service;

import java.util.List;

import com.poly.entity.Role;
import com.poly.entity.User;

/**
 * Giao diện RoleService định nghĩa các phương thức để quản lý vai trò (Role)
 * trong hệ thống.
 */
public interface RoleService {

	/**
	 * Phương thức lấy danh sách tất cả các vai trò trong hệ thống.
	 * 
	 * @return danh sách các vai trò
	 */
	List<Role> getAllRoles();

	/**
	 * Phương thức tạo mới một vai trò trong hệ thống.
	 * 
	 * @param role vai trò cần tạo
	 * @return vai trò đã được tạo
	 */
	Role createRole(Role role);

	/**
	 * Phương thức xóa một vai trò khỏi hệ thống dựa trên ID của vai trò.
	 * 
	 * @param roleId ID của vai trò cần xóa
	 */
	void deleteRole(Integer roleId);

	/**
	 * Phương thức tìm kiếm vai trò dựa trên tên của vai trò.
	 * 
	 * @param name tên của vai trò cần tìm kiếm
	 * @return vai trò tìm được (nếu có)
	 */
	Role findRoleByName(String name);

	/**
	 * Phương thức tìm kiếm vai trò dựa trên ID của vai trò.
	 * 
	 * @param roleId ID của vai trò cần tìm kiếm
	 * @return vai trò tìm được (nếu có)
	 */
	Role findRoleById(Integer roleId);

	/**
	 * Phương thức gỡ bỏ người dùng khỏi vai trò dựa trên ID của người dùng và ID
	 * của vai trò.
	 * 
	 * @param userId ID của người dùng
	 * @param roleId ID của vai trò
	 * @return người dùng đã được gỡ bỏ khỏi vai trò
	 */
	User removeUserFromRole(Long userId, Integer roleId);

	/**
	 * Phương thức gán người dùng vào vai trò dựa trên ID của người dùng và ID của
	 * vai trò.
	 * 
	 * @param userId ID của người dùng
	 * @param roleId ID của vai trò
	 * @return người dùng đã được gán vào vai trò
	 */
	User assignUserToRole(Long userId, Integer roleId);

	/**
	 * Phương thức gỡ bỏ tất cả người dùng khỏi vai trò dựa trên ID của vai trò.
	 * 
	 * @param roleId ID của vai trò
	 * @return vai trò đã được gỡ bỏ tất cả người dùng
	 */
	Role removeAllUserFromRole(Integer roleId);
}
