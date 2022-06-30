package com.universitycourseapp.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.universitycourseapp.entities.Role;
import com.universitycourseapp.entities.User;
import com.universitycourseapp.exception.LoginFailedException;
import com.universitycourseapp.repository.UserLoginRepository;


@Service("ILoginService")
public class ILoginServiceIml implements ILoginService,UserDetailsService {
	@Autowired
	private UserLoginRepository userDao;
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	
	/**
	 * Method :      loadUserByUsername 
	 * @param        username
	 * @return       UserDetails
	 * @throws       UsernameNotFoundException 
	 * Description : This method is taking username from table 
	 */
	
	
			
		@Override
		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			User user = userDao.findByUsername(username);
			
			if (user != null) {
				return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
						new ArrayList<>());
			}
			throw new UsernameNotFoundException("Username not found");
		}
		 public Role findRole(String username) {
			 User user = userDao.findByUsername(username);
			 return user.getRole();
		 }
		
		
		/**
		 * Method :      loadUserByUsername 
		 * @param        username and password
		 * @return       void
		 * @throws       LoginFailedException
		 * Description : This use Authenticate the username and password
		 */
		
		
		
		public void authenticate(String username, String password) throws LoginFailedException {
			try {
				authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			} catch (DisabledException e) {
				throw new LoginFailedException("Please Enter Valid Username and Password");
			} catch (BadCredentialsException e) {
				throw new LoginFailedException("Please Enter Valid Username and Password");
			}

		}



		

	}


