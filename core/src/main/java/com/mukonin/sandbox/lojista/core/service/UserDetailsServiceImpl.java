package com.mukonin.sandbox.lojista.core.service;

import com.mukonin.sandbox.lojista.core.entity.User;
import com.mukonin.sandbox.lojista.core.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Implementation of UserDetailsService
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private static final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByName(username);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            return new org.springframework.security.core.userdetails.User(
                    user.getUsername(), user.getPassword(), user.isEnabled(), true, true,
                    true, getAuthoritiesByUser(user));
        } else {
            log.debug("User with username {} not found", username);
            throw new UsernameNotFoundException("User with username \"" + username + "\" not found");
        }
    }

    private Set<GrantedAuthority> getAuthoritiesByUser(User user) {
        Set<GrantedAuthority> authorities = new HashSet<>(
                Collections.singleton(new SimpleGrantedAuthority(user.getRole().toString()))
        );
        log.debug("{} authorities: {}", user.getUsername(), authorities);
        return authorities;
    }

}
