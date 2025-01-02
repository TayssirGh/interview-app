package com.dist.interview.core.model.common;


import com.dist.interview.core.model.entity.AppUser;

public interface AppPrincipal {
    AppUser getUser();
    
    Long getId();

    String getEmail();

    String getPassword();

    String getUsername();
}
