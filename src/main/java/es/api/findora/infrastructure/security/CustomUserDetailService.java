package es.api.findora.infrastructure.security;

import es.api.findora.domain.model.User;
import es.api.findora.domain.port.out.UserRepository;
import es.api.findora.domain.validation.EmailValidator;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user;

        if(EmailValidator.isValid(username)){
            user = userRepository.findByEmail(username);
        }else{
            user = userRepository.findByUsername(username);
        }

        if(user == null){
            throw new UsernameNotFoundException("Username or email not found");
        }

        return new UserDetailAdapter(user);
    }
}
