package TravelGuide.service;

import TravelGuide.entity.Utilizator;
import TravelGuide.repository.UtilizatorRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilizatorService {

    private final UtilizatorRepository utilizatorRepository;
    private final PasswordEncoder passwordEncoder;

    public UtilizatorService(
            UtilizatorRepository utilizatorRepository,
            PasswordEncoder passwordEncoder) {
        this.utilizatorRepository = utilizatorRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<Utilizator> getAllUtilizatori() {
        return utilizatorRepository.findAll();
    }

    public Optional<Utilizator> getUtilizatorById(Integer id) {
        return utilizatorRepository.findById(id);
    }

    public Optional<Utilizator> getUtilizatorByEmail(String email) {
        return utilizatorRepository.findByEmail(email);
    }

    public boolean existsByEmail(String email) {
        return utilizatorRepository.existsByEmail(email);
    }

    public Utilizator saveUtilizator(Utilizator utilizator, String parola) {
        if (parola != null && !parola.isBlank()) {
            String parolaHash = passwordEncoder.encode(parola);
            utilizator.setParolaHash(parolaHash);
        }

        return utilizatorRepository.save(utilizator);
    }

    public boolean verificaParola(String parola, String parolaHash) {
        return passwordEncoder.matches(parola, parolaHash);
    }

    public void deleteUtilizator(Integer id) {
        utilizatorRepository.deleteById(id);
    }
}