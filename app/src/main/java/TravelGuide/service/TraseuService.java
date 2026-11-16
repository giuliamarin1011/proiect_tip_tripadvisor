
package TravelGuide.service;

import TravelGuide.entity.Traseu;
import TravelGuide.repository.TraseuRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TraseuService {

    private final TraseuRepository traseuRepository;

    public TraseuService(TraseuRepository traseuRepository) {
        this.traseuRepository = traseuRepository;
    }

    public List<Traseu> getAllTrasee() {
        return traseuRepository.findAll();
    }

    public Optional<Traseu> getTraseuById(Integer id) {
        return traseuRepository.findById(id);
    }

    public List<Traseu> getTraseeByAtractie(Integer idAtractie) {
        return traseuRepository.findByAtractie_IdAtractie(idAtractie);
    }

    public List<Traseu> getTraseeByTransport(Integer idTransport) {
        return traseuRepository.findByMijlocTransport_IdTransport(idTransport);
    }

    public List<Traseu> getTraseeByOrasPlecare(Integer idOras) {
        return traseuRepository.findByOrasPlecare_IdOras(idOras);
    }

    public Traseu saveTraseu(Traseu traseu) {
        return traseuRepository.save(traseu);
    }

    public void deleteTraseu(Integer id) {
        traseuRepository.deleteById(id);
    }
}
