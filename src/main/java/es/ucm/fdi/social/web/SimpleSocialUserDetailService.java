package es.ucm.fdi.social.web;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;

import es.ucm.fdi.users.business.boundary.UsersManager;

public class SimpleSocialUserDetailService implements SocialUserDetailsService {
	 
    private UsersManager usersManager;
 
    public SimpleSocialUserDetailService(UsersManager usersManager) {
        this.usersManager = usersManager;
    }
 
    @Override
    public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException, DataAccessException {
        UserDetails userDetails = usersManager.loadUserByUsername(userId);
        return (SocialUserDetails) userDetails;
    }
}