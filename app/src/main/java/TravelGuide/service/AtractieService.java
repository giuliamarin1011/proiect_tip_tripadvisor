
package TravelGuide.service;

import TravelGuide.entity.Atractie;
import TravelGuide.repository.AtractieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AtractieService {

    private final AtractieRepository atractieRepository;

    public AtractieService(AtractieRepository atractieRepository) {
        this.atractieRepository = atractieRepository;
    }

    public List<Atractie> getAllAtractii() {
        return atractieRepository.findAll();
    }

    public Optional<Atractie> getAtractieById(Integer id) {
        return atractieRepository.findById(id);
    }

    public List<Atractie> searchAtractiiByName(String nume) {
        return atractieRepository.findByNumeContainingIgnoreCase(nume);
    }

    public List<Atractie> getAtractiiByOras(Integer idOras) {
        return atractieRepository.findByOras_IdOras(idOras);
    }

    public Atractie saveAtractie(Atractie atractie) {
        return atractieRepository.save(atractie);
    }

    public void deleteAtractie(Integer id) {
        atractieRepository.deleteById(id);
    }
}
