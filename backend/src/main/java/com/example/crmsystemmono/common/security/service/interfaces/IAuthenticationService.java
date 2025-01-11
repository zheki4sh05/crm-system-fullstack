package com.example.crmsystemmono.common.security.service.interfaces;

import com.example.crmsystemmono.common.security.dto.*;

public interface IAuthenticationService {

    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);
}
