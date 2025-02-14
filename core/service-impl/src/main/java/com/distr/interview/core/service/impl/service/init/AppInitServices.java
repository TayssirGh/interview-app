package com.distr.interview.core.service.impl.service.init;

import com.distr.interview.core.service.api.AppInitService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppInitServices {
    @Autowired(required = false)
    private List<AppInitService> services;

    @PostConstruct
    public void init() {
        if (services != null) {
            for (AppInitService service : services) {
                service.initializeApp();
            }
        }
    }
}
