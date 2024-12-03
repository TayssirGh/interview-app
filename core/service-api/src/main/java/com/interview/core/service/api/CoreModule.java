package com.interview.core.service.api;

import com.dist.interview.core.infra.model.payload.AppPrincipalResponse;
import com.dist.interview.core.infra.model.payload.LoginRequest;
import com.dist.interview.core.infra.model.payload.SignupRequest;
import com.dist.interview.core.infra.model.payload.VersionResponse;

public interface CoreModule {
    AppPrincipalResponse login(LoginRequest request);


    VersionResponse version();

    void signup(SignupRequest signUpRequest);
}
