package es.ucm.fdi.users.business.boundary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.ucm.fdi.users.business.control.UserRepository;
import es.ucm.fdi.users.business.entity.User;
import es.ucm.fdi.users.business.entity.UserBuilder;

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
		user = repository.save(user);
		return user;
	}

	public Iterable<User> listUsers() {
		return repository.findAll();
	}

	
}
