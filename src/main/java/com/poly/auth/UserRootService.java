package com.poly.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.poly.dao.UserDAO;
import com.poly.entity.User;

@Service
public class UserRootService implements UserDetailsService {

	@Autowired
	UserDAO userDAO;

	/**
	 * Tải thông tin người dùng theo tên đăng nhập.
	 *
	 * @param email Tên đăng nhập của người dùng.
	 * @return Thông tin người dùng.
	 * @throws UsernameNotFoundException Nếu không tìm thấy người dùng với tên đăng
	 *                                   nhập đã cho.
	 */
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userDAO.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("User not found with email : " + email));
		return UserRoot.create(user);
	}

}
