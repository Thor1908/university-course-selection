package com.universitycourseapp.controller;

import java.util.HashMap; 
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.universitycourseapp.entities.User;
import com.universitycourseapp.exception.LoginFailedException;
import com.universitycourseapp.jwt.JwtTokenUtil;
import com.universitycourseapp.service.ILoginService;
import com.universitycourseapp.service.ILoginServiceIml;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins="http://localhost:4200/")
public class LogInController {
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	ILoginService loginService;
	@Autowired
	ILoginServiceIml iloginseviceiml;
	/**
	 * Method :      addmissioncommittemember 
	 * @param        user
	 * @return       ResponseEntity<Object>
	 * @throws       LoginFailedException 
	 * Description : This method used to generate token 
	 * 
	 */

	// http://localhost:8590/login/user
	@PostMapping("/user")
	public ResponseEntity<Object> addmissioncommittemember(@RequestBody User user) throws LoginFailedException {
		Map<String, String> body = new HashMap<String, String>();
		 
		loginService.authenticate(user.getUsername(), user.getPassword());
		final UserDetails userDetails = loginService.loadUserByUsername(user.getUsername());
		final String token = jwtTokenUtil.generateToken(userDetails);
		body.put("username", user.getUsername());
		body.put("token", token);
		body.put("role", iloginseviceiml.findRole(user.getUsername()).toString());
		System.out.println(token);
		return new ResponseEntity<Object>(body, new HttpHeaders(), HttpStatus.OK);
	}

}
