package com.dist.interview.core.service.impl;

import com.dist.interview.core.service.api.CoreModule;
import com.dist.interview.core.service.impl.service.AuthService;
import com.dist.interview.core.service.impl.service.AppUserService;
import lombok.experimental.Delegate;
import org.springframework.stereotype.Service;

//@Service
public abstract class CoreModuleImpl implements CoreModule {
    //@Delegate
    private AuthService authService;

    //@Delegate
    private AppUserService appUserService;

}
