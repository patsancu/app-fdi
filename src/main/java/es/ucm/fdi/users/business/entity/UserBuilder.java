package es.ucm.fdi.users.business.entity;

import java.util.List;

import javax.persistence.Column;

import org.hibernate.validator.constraints.Email;
import org.springframework.beans.BeanUtils;

public class UserBuilder {
	private Long id;

	@Column(unique=true)
	private String username;
	
	@Column(unique=true)
	@Email
	private String email;

	private String password;
	
	private List<Integer> role_ids;

	public User build() {
		User result = new User(this.id);
			
		BeanUtils.copyProperties(this, result, "accountNonExpired, enabled, credentialsNonExpired");
	
		return result;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Integer> getRole_ids() {
		return role_ids;
	}

	public void setRole_ids(List<Integer> role_ids) {
		this.role_ids = role_ids;
	}
	
	
	
	
}
