
package TravelGuide.service;

import TravelGuide.entity.Recenzie;
import TravelGuide.repository.RecenzieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecenzieService {

    private final RecenzieRepository recenzieRepository;

    public RecenzieService(RecenzieRepository recenzieRepository) {
        this.recenzieRepository = recenzieRepository;
    }

    public List<Recenzie> getAllRecenzii() {
        return recenzieRepository.findAll();
    }

    public Optional<Recenzie> getRecenzieById(Integer id) {
        return recenzieRepository.findById(id);
    }

    public List<Recenzie> getRecenziiByAtractie(Integer idAtractie) {
        return recenzieRepository.findByAtractie_IdAtractie(idAtractie);
    }

    public List<Recenzie> getRecenziiByUtilizator(Integer idUtilizator) {
        return recenzieRepository.findByUtilizator_IdUtilizator(idUtilizator);
    }

    public Recenzie saveRecenzie(Recenzie recenzie) {
        return recenzieRepository.save(recenzie);
    }

    public void deleteRecenzie(Integer id) {
        recenzieRepository.deleteById(id);
    }
}
