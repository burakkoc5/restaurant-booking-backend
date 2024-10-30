package com.burakkoc.restaurantbooking.business.abstracts;

import com.burakkoc.restaurantbooking.business.requests.AuthenticationRequest;
import com.burakkoc.restaurantbooking.business.requests.RegisterRequest;
import com.burakkoc.restaurantbooking.business.responses.AuthenticationResponse;
import com.burakkoc.restaurantbooking.utils.results.DataResult;

public interface AuthenticationService {

	DataResult<AuthenticationResponse> register(RegisterRequest request);

	DataResult<AuthenticationResponse> authenticate(AuthenticationRequest request);
    
}
