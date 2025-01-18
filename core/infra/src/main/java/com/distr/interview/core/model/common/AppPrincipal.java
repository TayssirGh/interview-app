package com.distr.interview.core.model.common;


import com.distr.interview.core.model.entity.AppUser;

public interface AppPrincipal {
    AppUser getUser();
    
    Long getId();

    String getEmail();

    String getPassword();

    String getUsername();
}
