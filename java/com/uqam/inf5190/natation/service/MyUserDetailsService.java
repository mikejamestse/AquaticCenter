package com.uqam.inf5190.natation.service;

import com.uqam.inf5190.natation.dao.UserRepository;
import com.uqam.inf5190.natation.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);

        // verifier que le user existe
        if(user == null){
            throw new UsernameNotFoundException("Utilisateur inexistant");
        }
        return new UserPrincipal(user);
    }

    public void save(User user){
        userRepository.save(user);
    }

}
