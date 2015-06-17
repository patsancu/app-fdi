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
package es.ucm.fdi.users.business.boundary;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.ucm.fdi.users.business.control.UserRepository;
import es.ucm.fdi.users.business.entity.User;
import es.ucm.fdi.users.business.entity.UserBuilder;
import es.ucm.fdi.users.business.entity.UserRole;
import es.ucm.fdi.users.util.PasswordHash;

@Service(value="usersManager")
@Transactional("rootTransactionManager")
public class UsersManager implements UserDetailsService {

	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		UserDetails user = repository.findByEmail(username);
		if (user == null)  {
			user = repository.findByUsername(username);
		}
		
		if (user == null) {
			throw new UsernameNotFoundException(String.format("User %s not found", username));
		}
		
		return user;
	}
	
	public User saveUser(UserBuilder builder){
		User user = builder.build();
		try {
			user.setPassword(PasswordHash.createHash(user.getPassword()));
		} catch (NoSuchAlgorithmException e) {			
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
		
		Collection<UserRole> roles = new ArrayList<UserRole>();
		roles.add(new UserRole("ROLE_USER"));
		
		user.setRoles(roles);
		
		user = repository.save(user);
		return user;
	}

	public Iterable<User> listUsers() {
		return repository.findAll();
	}
	
	public User getUser(Long id){
		return repository.findOne(id);
	}
	
	public User updateUser(UserBuilder builder){
		User newUser = builder.build();		
		User currentUser = repository.findOne(builder.getId());
		String currentPassword = currentUser.getPassword();
		
		BeanUtils.copyProperties(newUser, currentUser);
		
		if (newUser.getPassword() == null || "".equals(newUser.getPassword()) ){
			newUser.setPassword(currentPassword);
		}
		else{
			try {
				newUser.setPassword(PasswordHash.createHash(builder.getPassword()));
			} catch (NoSuchAlgorithmException e) {			
				e.printStackTrace();
			} catch (InvalidKeySpecException e) {
				e.printStackTrace();
			}
		}		
		return repository.save(newUser);
	}

	
}
