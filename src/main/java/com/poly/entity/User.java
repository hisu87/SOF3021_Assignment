package com.poly.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.poly.utils._enum.AuthTypeEnum;
import com.poly.utils._enum.RoleUserEnum;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("serial")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "users")
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String password;

	@Column(name = "name", columnDefinition = "nvarchar(255)")
	private String name;

	@Column(name = "phone_number", columnDefinition = "varchar(13)")
	private String phoneNumber;

	@Column(columnDefinition = "varchar(150)")
	private String email;

	@Builder.Default
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = {
			@JoinColumn(name = "user_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "role_id", referencedColumnName = "id") })
	private Set<Role> roles = Set.of(new Role(RoleUserEnum.USER));

	@Builder.Default
	@Enumerated(EnumType.ORDINAL)
	private AuthTypeEnum authType = AuthTypeEnum.LOCAL;

	@Builder.Default
	@NotNull(message = "{NotNull.user.active}")
	private Boolean active = true;

	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private List<UserAddress> userAddresses;

	@JsonIgnore
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Order> orders;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private ShoppingCart cart;
	
	public boolean isAdmin() {
		
		boolean isAdmin = false;
		
		for (Role role : this.getRoles()) {
			if (role.getId() == 1) {
				isAdmin = true;
				break;
			}
		}
		
		return isAdmin;
	}
	
	public String getRoleString() {
		return this.roles.stream().map(r -> r.getName()).collect(Collectors.joining(", "));
	}

}
