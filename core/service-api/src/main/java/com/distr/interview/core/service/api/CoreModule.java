package com.distr.interview.core.service.api;

import com.distr.interview.core.model.payload.AppPrincipalResponse;
import com.distr.interview.core.model.payload.LoginRequest;
import com.distr.interview.core.model.payload.SignupRequest;
import com.distr.interview.core.model.payload.VersionResponse;

public interface CoreModule {
    AppPrincipalResponse login(LoginRequest request);


    VersionResponse version();

    void signup(SignupRequest signUpRequest);
}
