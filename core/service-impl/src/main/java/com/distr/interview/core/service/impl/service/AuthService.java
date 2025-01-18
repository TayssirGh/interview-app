package com.distr.interview.core.service.impl.service;

import com.distr.interview.core.model.payload.VersionResponse;
import com.distr.interview.core.service.api.CoreModule;
import net.thevpc.nuts.util.NOptional;
import com.distr.interview.core.model.common.AppException;
import com.distr.interview.core.model.entity.AppUser;
import com.distr.interview.core.model.entity.AppUserRole;
import com.distr.interview.core.model.payload.AppPrincipalResponse;
import com.distr.interview.core.model.payload.LoginRequest;
import com.distr.interview.core.model.payload.SignupRequest;
import com.distr.interview.core.service.impl.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AuthService implements CoreModule {
    @Autowired
    @Lazy
    private AppUserService appUserService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private AppTokenGenerator appTokenGenerator;
    @Override
    public AppPrincipalResponse login(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = appTokenGenerator.createToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return new AppPrincipalResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles);
    }

    @Override

    public void signup(SignupRequest signUpRequest) {
        NOptional<AppUser> userByNameOrEmail = appUserService.findUserByNameOrEmailWithPassword(signUpRequest.getUsername(), signUpRequest.getEmail());
        if (userByNameOrEmail.isPresent()) {
            throw new AppException("A001", "Username or email already in use");
        }


        System.out.println("Creating new user with username: " + signUpRequest.getUsername());

        AppUser user = new AppUser()
                .setUsername(signUpRequest.getUsername())
                .setEmail(signUpRequest.getEmail())
                .setPassword(signUpRequest.getPassword())
                .setEnabled(true);

        Set<String> strRoles = signUpRequest.getRole();
        Set<AppUserRole> roles = new HashSet<>();

        if (strRoles != null) {
            strRoles.forEach(role -> {
                AppUserRole adminRole = appUserService.findRoleByName(role).orElse(null);
                if (adminRole != null) {
                    roles.add(adminRole);
                }
            });
        }
        user.setRoles(roles);
        appUserService.addUser(user);
    }
    @Override
    public VersionResponse version() {
        return new VersionResponse();
    }


}
