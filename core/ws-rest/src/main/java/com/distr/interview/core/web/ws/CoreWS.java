package com.distr.interview.core.web.ws;

import com.distr.interview.core.model.payload.*;
import com.distr.interview.core.model.payload.*;
import com.distr.interview.core.service.api.CoreModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class CoreWS {
    @Autowired
    private CoreModule module;



    @RequestMapping(value = "/version",method = {RequestMethod.GET,RequestMethod.POST})
    private VersionResponse version() {
        return new VersionResponse();
    }


    @PostMapping("/login")
    public AppPrincipalResponse authenticateUser(@RequestBody LoginRequest loginRequest) {
        return module.login(loginRequest);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest signUpRequest) {
        module.signup(signUpRequest);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}
