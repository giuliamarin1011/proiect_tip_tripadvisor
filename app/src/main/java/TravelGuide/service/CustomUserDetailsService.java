package TravelGuide.service;

import TravelGuide.entity.Utilizator;
import TravelGuide.repository.UtilizatorRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UtilizatorRepository utilizatorRepository;

    public CustomUserDetailsService(UtilizatorRepository utilizatorRepository) {
        this.utilizatorRepository = utilizatorRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        Utilizator utilizator = utilizatorRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(
                        "Utilizatorul nu a fost găsit: " + email
                ));

        return User.builder()
                .username(utilizator.getEmail())
                .password(utilizator.getParolaHash())
                .roles(utilizator.getRol())
                .build();
    }
}