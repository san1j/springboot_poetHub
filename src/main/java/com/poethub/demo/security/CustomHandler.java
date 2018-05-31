package com.poethub.demo.security;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.poethub.demo.model.UserModel;
import com.poethub.demo.service.UserService;
@Component
public class CustomHandler implements AuthenticationSuccessHandler {
//	@Autowired
//	private UserModel userModel;
//	@Autowired
//	private UserService userService;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		Map<String,String> userDetails = (Map<String,String>) authentication.getDetails();
		System.out.println(userDetails);
		response.setStatus(HttpServletResponse.SC_OK);
		response.sendRedirect("home");
	}

}
