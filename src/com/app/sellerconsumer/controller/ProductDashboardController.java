package com.app.sellerconsumer.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonGenerator;
import com.google.api.client.json.JsonParser;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.app.sellerconsumer.DTO.UserDTO;
import com.app.sellerconsumer.model.User;
import com.app.sellerconsumer.service.UserServiceImpl;

@Controller
@RequestMapping(value = "/")
public class ProductDashboardController {

	@Autowired
	UserServiceImpl userService;

	@RequestMapping(value = "changeRole", method = RequestMethod.POST)
	@ResponseBody
	public UserDTO updateRole(@RequestBody Map<String, Object> data) throws GeneralSecurityException, IOException {
		UserDTO userdto = new UserDTO();
		userdto.setRole(data.get("role").toString());
		userdto.setUsername(data.get("username").toString());
		userService.updateUserRole(userdto);
		return userdto;
	}
	
}
