//package com.example.demo.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.DisabledException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.demo.jwt.JwtRequestModel;
//import com.example.demo.jwt.JwtResponseModel;
//import com.example.demo.jwt.TokenManager;
//import com.example.demo.service.users.UserDetailsImp;
//import com.example.demo.service.users.UserDetailsServiceImp;
//
//@RestController
//@CrossOrigin
//public class JwtController {
//	@Autowired
//	private UserDetailsServiceImp userDetailsServiceImp;
//	@Autowired
//	private AuthenticationManager authenticationManager;
//	@Autowired
//	private TokenManager tokenManager;
//
//	@PostMapping("/login")
//	public ResponseEntity<JwtResponseModel> createToken(@RequestBody JwtRequestModel request) throws Exception {
//		try {
//			authenticationManager.authenticate(
//					new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
//		} catch (DisabledException e) {
//			throw new Exception("USER_DISABLED", e);
//		} catch (BadCredentialsException e) {
//			throw new Exception("INVALID_CREDENTIALS", e);
//		}
//		final UserDetailsImp userDetailsImp = userDetailsServiceImp.loadUserByUsername(request.getUsername());
//		final String jwtToken = tokenManager.generateJwtToken(userDetailsImp);
//		return ResponseEntity.ok(new JwtResponseModel(jwtToken));
//	}
//}