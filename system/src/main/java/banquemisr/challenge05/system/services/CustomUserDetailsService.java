package banquemisr.challenge05.system.services;

import banquemisr.challenge05.system.entities.Role;
import banquemisr.challenge05.system.entities.User;
import banquemisr.challenge05.system.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findUserByUserEmail(email);
        if(user == null){
            throw new UsernameNotFoundException("User Not Found");
        }
        List<String> roles = user.getRoles().stream().map(Role::getRoleName).collect(Collectors.toList());
        UserDetails userDetails =
                org.springframework.security.core.userdetails.User.builder()
                        .username(user.getUserEmail())
                        .password(user.getPassword())
                        .roles(roles.toArray(new String[0]))
                        .build();
        return userDetails;
    }
}
