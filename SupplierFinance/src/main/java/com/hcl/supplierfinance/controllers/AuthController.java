package com.hcl.supplierfinance.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.supplierfinance.models.Account;
import com.hcl.supplierfinance.models.Client;
import com.hcl.supplierfinance.models.ERole;
import com.hcl.supplierfinance.models.Role;
import com.hcl.supplierfinance.models.Supplier;
import com.hcl.supplierfinance.models.User;
import com.hcl.supplierfinance.payload.request.ClientSignupRequest;
import com.hcl.supplierfinance.payload.request.LoginRequest;
import com.hcl.supplierfinance.payload.request.SupplierSignupRequest;
import com.hcl.supplierfinance.payload.response.JwtResponse;
import com.hcl.supplierfinance.payload.response.MessageResponse;
import com.hcl.supplierfinance.repository.RoleRepository;
import com.hcl.supplierfinance.repository.SupplierRepository;
import com.hcl.supplierfinance.repository.UserRepository;
import com.hcl.supplierfinance.repository.AccoutRepository;
import com.hcl.supplierfinance.repository.ClientRepository;
import com.hcl.supplierfinance.security.jwt.JwtUtils;
import com.hcl.supplierfinance.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	SupplierRepository supplierRepository;
	
	@Autowired
	AccoutRepository accountRepository;
	
	@Autowired
	ClientRepository clientRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;
	
	
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(
				new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles));
	}
	
	
	//For Supplier Sign Up
	@PostMapping("/supplierSignup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SupplierSignupRequest suppSignupRequest) {
		if (userRepository.existsByUsername(suppSignupRequest.getUsername())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(suppSignupRequest.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new Supplier user's account
		User user = new User(suppSignupRequest.getUsername(), suppSignupRequest.getEmail(),
				encoder.encode(suppSignupRequest.getPassword()));

		Set<String> strRoles = suppSignupRequest.getRole();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_BUYER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "ROLE_SELLER":
					Role sellerRole = roleRepository.findByName(ERole.ROLE_SELLER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(sellerRole);

					break;
				case "ROLE_BUYER":
					Role buyerRole = roleRepository.findByName(ERole.ROLE_BUYER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(buyerRole);

					break;

				case "ROLE_BANKER":
					Role bankerRole = roleRepository.findByName(ERole.ROLE_BANKER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(bankerRole);

					break;
				case "ROLE_WEB_MASTER":
					Role webMasterRole = roleRepository.findByName(ERole.ROLE_WEB_MASTER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(webMasterRole);
				}
			});
		}
		
		user.setRoles(roles);
		userRepository.save(user);
		Account account = suppSignupRequest.getAccount();
		accountRepository.save(account);
		Supplier sup = new Supplier(suppSignupRequest.getFullName(),suppSignupRequest.getCity(),
				suppSignupRequest.getState(),suppSignupRequest.getCounty(),
				suppSignupRequest.getPhoneNumber(), suppSignupRequest.getSupplierLimit(), user, account);
		supplierRepository.save(sup);
		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
	
	//For Client Sign up
	@PostMapping("/clientSignup")
	public ResponseEntity<?> registerClient(@Valid @RequestBody ClientSignupRequest clientSignupRequest) {
		if (userRepository.existsByUsername(clientSignupRequest.getUsername())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(clientSignupRequest.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new Client's account
		User user = new User(clientSignupRequest.getUsername(), clientSignupRequest.getEmail(),
				encoder.encode(clientSignupRequest.getPassword()));

		Set<String> strRoles = clientSignupRequest.getRole();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_BUYER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "ROLE_SELLER":
					Role sellerRole = roleRepository.findByName(ERole.ROLE_SELLER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(sellerRole);

					break;
				case "ROLE_BUYER":
					Role buyerRole = roleRepository.findByName(ERole.ROLE_BUYER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(buyerRole);

					break;

				case "ROLE_BANKER":
					Role bankerRole = roleRepository.findByName(ERole.ROLE_BANKER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(bankerRole);

					break;
				case "ROLE_WEB_MASTER":
					Role webMasterRole = roleRepository.findByName(ERole.ROLE_WEB_MASTER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(webMasterRole);
				}
			});
		}
		
		user.setRoles(roles);
		userRepository.save(user);
		Account account = clientSignupRequest.getAccount();
		accountRepository.save(account);
		Client client = new Client(clientSignupRequest.getFullName(),clientSignupRequest.getCity(),
				clientSignupRequest.getState(),clientSignupRequest.getCounty(),
				clientSignupRequest.getPhoneNumber(), clientSignupRequest.getCreditLimit(), user, account);
		clientRepository.save(client);
		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
}
