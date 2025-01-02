package com.dist.interview.core.service.api;

import com.dist.interview.core.model.payload.AppPrincipalResponse;
import com.dist.interview.core.model.payload.LoginRequest;
import com.dist.interview.core.model.payload.SignupRequest;
import com.dist.interview.core.model.payload.VersionResponse;

public interface CoreModule {
    AppPrincipalResponse login(LoginRequest request);


    VersionResponse version();

    void signup(SignupRequest signUpRequest);
}
