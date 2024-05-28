package com.poly.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.poly.utils._enum.RoleUserEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	@JsonIgnore
	@ManyToMany(mappedBy = "roles")
	private Collection<User> users = new HashSet<User>();

	public Role(RoleUserEnum role) {
		this.id = role.getValue();
		this.name = role.name();
	}

	public Role(String name) {
		this.name = name;
	}

	public void removeAllUsersFromRole() {
		if (this.getUsers() != null) {
			List<User> usersInRole = this.getUsers().stream().toList();
			usersInRole.forEach(this::removeUserFromRole);
		}
	}

	public void removeUserFromRole(User user) {
		user.getRoles().remove(this);
		this.getUsers().remove(user);
	}

	public void assignUserToRole(User user) {
		user.getRoles().add(this);
		this.getUsers().add(user);
	}

}
