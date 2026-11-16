
package TravelGuide.service;

import TravelGuide.entity.AtractieCategorie;
import TravelGuide.repository.AtractieCategorieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AtractieCategorieService {

    private final AtractieCategorieRepository atractieCategorieRepository;

    public AtractieCategorieService(
            AtractieCategorieRepository atractieCategorieRepository) {
        this.atractieCategorieRepository = atractieCategorieRepository;
    }

    public List<AtractieCategorie> getAllAsocieri() {
        return atractieCategorieRepository.findAll();
    }

    public Optional<AtractieCategorie> getAsociereById(
            AtractieCategorie.AtractieCategorieId id) {
        return atractieCategorieRepository.findById(id);
    }

    public AtractieCategorie saveAsociere(AtractieCategorie asociere) {
        return atractieCategorieRepository.save(asociere);
    }

    public void deleteAsociere(AtractieCategorie.AtractieCategorieId id) {
        atractieCategorieRepository.deleteById(id);
    }
}
