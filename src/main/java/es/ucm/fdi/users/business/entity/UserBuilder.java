/**
 * This file is part of Portal Web de la FDI.
 *
 * Portal Web de la FDI is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Portal Web de la FDI is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with Portal Web de la FDI.  If not, see <http://www.gnu.org/licenses/>.
 */
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
	
	private String userGivenName;
	
	private String userSurname;
	
	private List<Integer> role_ids;

	public User build() {
		User result = new User(this.id);
			
		BeanUtils.copyProperties(this, result);
	
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

	public String getUserGivenName() {
		return userGivenName;
	}

	public void setUserGivenName(String userGivenName) {
		this.userGivenName = userGivenName;
	}

	public String getUserSurname() {
		return userSurname;
	}

	public void setUserSurname(String userSurname) {
		this.userSurname = userSurname;
	}
	
	
	
	
}
