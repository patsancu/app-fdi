package es.ucm.fdi.users.business.control;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import es.ucm.fdi.users.business.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	public User findByUsername(String username);
	
	public User findByEmail(String email);

}
