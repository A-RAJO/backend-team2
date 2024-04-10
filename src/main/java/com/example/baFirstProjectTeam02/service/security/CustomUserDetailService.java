package com.example.baFirstProjectTeam02.service.security;

import com.example.baFirstProjectTeam02.repository.roles.Roles;
import com.example.baFirstProjectTeam02.repository.userDetails.CustomUserDetails;
import com.example.baFirstProjectTeam02.repository.userPrincipal.UserPrincipal;
import com.example.baFirstProjectTeam02.repository.userPrincipal.UserPrincipalRepository;
import com.example.baFirstProjectTeam02.repository.userPrincipal.UserPrincipalRoles;
import com.example.baFirstProjectTeam02.service.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Primary
@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {

    private final UserPrincipalRepository userPrincipalRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserPrincipal userPrincipal = userPrincipalRepository.findByEmailFetchJoin(email)
                .orElseThrow(() -> new NotFoundException("email 에 해당하는 UserPrincipal가 없습니다"));

        CustomUserDetails customUserDetails = CustomUserDetails.builder()
                .userId(userPrincipal.getUser()
                        .getUserId())
                .email(userPrincipal.getEmail())
                .password(userPrincipal.getPassword())
                .authorities(userPrincipal.getUserPrincipalRoles()
                        .stream()
                        .map(UserPrincipalRoles::getRoles)
                        .map(Roles::getName)
                        .collect(Collectors.toList()))
                .build();
        return customUserDetails;
    }
}
