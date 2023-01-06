// © 2022 Rakuten Symphony. All rights reserved.
package com.socket.example;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;


@RestController
public class LoadingController {

	private final LoadingService loadingService;
	private final AuthenticationService authenticationService;

	public LoadingController(LoadingService loadingService, AuthenticationService authenticationService) {
		this.loadingService = loadingService;
		this.authenticationService = authenticationService;
	}

	@PostMapping(value = "load")
	@Secured("ROLE_SUPER_USER")
	public ResponseEntity<?> compareById() {

		String user = authenticationService.getAuthentication().getName();

		CompletableFuture<String> future = loadingService.compareById(user);

		return new ResponseEntity<>(future, HttpStatus.CREATED);
	}

}