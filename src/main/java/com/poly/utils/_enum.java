package com.poly.utils;

import lombok.Data;

/**
 * Lớp _enum định nghĩa các enum liên quan đến vai trò người dùng và loại xác
 * thực.
 */
@Data
public class _enum {
	/**
	 * Enum RoleUserEnum định nghĩa các vai trò người dùng.
	 */
	public enum RoleUserEnum {
		ADMIN(1), USER(2);

		private final int value;

		/**
		 * Khởi tạo enum RoleUserEnum với giá trị.
		 * 
		 * @param value giá trị của enum
		 */
		RoleUserEnum(int value) {
			this.value = value;
		}

		/**
		 * Trả về giá trị của enum.
		 * 
		 * @return giá trị của enum
		 */
		public int getValue() {
			return this.value;
		}
	}

	/**
	 * Enum AuthTypeEnum định nghĩa các loại xác thực.
	 */
	public enum AuthTypeEnum {
		LOCAL, GOOGLE, FACEBOOK
	}
}