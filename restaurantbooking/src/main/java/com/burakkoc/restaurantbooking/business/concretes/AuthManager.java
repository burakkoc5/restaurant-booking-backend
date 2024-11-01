package com.burakkoc.restaurantbooking.business.concretes;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.burakkoc.restaurantbooking.business.abstracts.AuthenticationService;
import com.burakkoc.restaurantbooking.business.requests.AuthenticationRequest;
import com.burakkoc.restaurantbooking.business.requests.RegisterRequest;
import com.burakkoc.restaurantbooking.business.responses.AuthenticationResponse;
import com.burakkoc.restaurantbooking.dataAccess.abstracts.UserRepository;
import com.burakkoc.restaurantbooking.entities.Role;
import com.burakkoc.restaurantbooking.entities.User;
import com.burakkoc.restaurantbooking.utils.JwtService;
import com.burakkoc.restaurantbooking.utils.results.DataResult;
import com.burakkoc.restaurantbooking.utils.results.ErrorDataResult;
import com.burakkoc.restaurantbooking.utils.results.SuccessDataResult;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthManager implements AuthenticationService {
	
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	private final AuthenticationManager authManager;

    public DataResult<AuthenticationResponse> register(RegisterRequest request) {
    	
    	if (userRepository.findByEmail(request.getEmail()).orElse(null)!=null) {
            return new ErrorDataResult<AuthenticationResponse>(null,"This email already exists"); // You can replace this with a custom exception
        }
    	
    	var user = User.builder()
    			.name(request.getName())
    			.password(passwordEncoder.encode(request.getPassword()))
    			.email(request.getEmail())
    			.role(Role.USER)
    			.build();
    	
    	userRepository.save(user);
    	var jwtToken = jwtService.generateToken(user);
    	return new SuccessDataResult<AuthenticationResponse>(AuthenticationResponse.builder().token(jwtToken).build(),"User successfully registered");
    }
    
    public DataResult<AuthenticationResponse> authenticate(AuthenticationRequest request) {
    	try {
            authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    request.getEmail(), 
                    request.getPassword()
                )
            );
        } catch (BadCredentialsException e) {
            return new ErrorDataResult<AuthenticationResponse>(null,"Invalid email or password.");
        }
    	var user = userRepository.findByEmail(request.getEmail()).orElseThrow();
    	var jwtToken = jwtService.generateToken(user);
    	
    	return new SuccessDataResult<AuthenticationResponse>(AuthenticationResponse.builder().token(jwtToken).build(),"User successfully authenticated");
    }


    }
