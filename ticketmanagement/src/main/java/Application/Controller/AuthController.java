package Application.Controller;

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

import Application.Authority.AccountDetail;
import Application.Authority.JwtTokenProvider;
import Application.Models.Account;
import Application.Payload.Request.LoginRequest;
import Application.Payload.Request.SignupRequest;
import Application.Payload.Respone.JwtResponse;
import Application.Payload.Respone.MessageResponse;
import Application.Repositories.AccountRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private JwtTokenProvider tokenProvider;
	
	@Autowired
	private AccountRepository accountRepo;
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = tokenProvider.generateToken(authentication);
		
		AccountDetail principal = (AccountDetail) authentication.getPrincipal();		

		return ResponseEntity.ok(new JwtResponse(jwt, 
												principal.getId(), 
												principal.getUsername(), 
												principal.getEmail(), 
												principal.getRole()));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (accountRepo.existsByAccountUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (accountRepo.existsByAccountEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}

		Account account = new Account(signUpRequest.getUsername(), 
							 signUpRequest.getEmail(),
							 encoder.encode(signUpRequest.getPassword()));

		String strRoles = signUpRequest.getRole();
		String roles = "ROLE_ADMIN";

		if (strRoles != null) {
			roles = strRoles;
		} 
		
		account.setAccountRole(roles);
		accountRepo.save(account);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
}
