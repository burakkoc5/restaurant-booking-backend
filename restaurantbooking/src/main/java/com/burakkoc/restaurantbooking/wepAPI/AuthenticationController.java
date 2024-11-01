package com.burakkoc.restaurantbooking.wepAPI;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import com.burakkoc.restaurantbooking.business.abstracts.AuthenticationService;
import com.burakkoc.restaurantbooking.business.requests.AuthenticationRequest;
import com.burakkoc.restaurantbooking.business.requests.RegisterRequest;
import com.burakkoc.restaurantbooking.business.responses.AuthenticationResponse;
import com.burakkoc.restaurantbooking.utils.results.DataResult;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authService;
    
    @PostMapping("/register")
    public ResponseEntity<DataResult<AuthenticationResponse>> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
        
    }
    
    @PostMapping("/authenticate")
    public ResponseEntity<DataResult<AuthenticationResponse>> register(@RequestBody AuthenticationRequest request) {    
        return ResponseEntity.ok(authService.authenticate(request));
    }
    
    
    
}
