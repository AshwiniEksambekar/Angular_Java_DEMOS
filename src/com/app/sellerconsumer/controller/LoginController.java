package com.app.sellerconsumer.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.app.sellerconsumer.DTO.UserDTO;
import com.app.sellerconsumer.service.UserServiceImpl;

@Controller
@RequestMapping(value = "/")
public class LoginController {

	private static final String CLIENT_ID = "793050458250-qgigieiamh5u4agsfahinmtt2n6a86g1.apps.googleusercontent.com";
	@Autowired
	UserServiceImpl userService;

	@RequestMapping(value = "tokensignin", method = RequestMethod.POST)
	@ResponseBody
	public UserDTO showLogin(@RequestBody Map<String, Object> data) throws GeneralSecurityException, IOException {

		HttpTransport transport = GoogleNetHttpTransport.newTrustedTransport();
		UserDTO userdto = null;
		JacksonFactory jsonFactory = JacksonFactory.getDefaultInstance();
		GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
				// Specify the CLIENT_ID of the app that accesses the backend:
				.setAudience(Collections.singletonList(CLIENT_ID))
				// Or, if multiple clients access the backend:
				// .setAudience(Arrays.asList(CLIENT_ID_1, CLIENT_ID_2, CLIENT_ID_3))
				.build();

		// (Receive idTokenString by HTTPS POST)

		GoogleIdToken idToken = null;
		try {
			idToken = verifier.verify(data.get("authToken").toString());

			if (idToken != null) {
				Payload payload = idToken.getPayload();

				// Print user identifier
				String userId = payload.getSubject();
				System.out.println("User ID: " + userId);

				userdto = new UserDTO();
				userdto.setUsername(payload.get("name").toString());

			} else {
				System.out.println("Invalid ID token.");
			}
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getStackTrace());
		}
		return userdto;
	}

	
}
