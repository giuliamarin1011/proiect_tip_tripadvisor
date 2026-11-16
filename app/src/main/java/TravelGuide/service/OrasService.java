
package TravelGuide.service;

import TravelGuide.entity.Oras;
import TravelGuide.repository.OrasRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrasService {

    private final OrasRepository orasRepository;

    public OrasService(OrasRepository orasRepository) {
        this.orasRepository = orasRepository;
    }

    public List<Oras> getAllOrase() {
        return orasRepository.findAll();
    }

    public Optional<Oras> getOrasById(Integer id) {
        return orasRepository.findById(id);
    }

    public Oras saveOras(Oras oras) {
        return orasRepository.save(oras);
    }

    public void deleteOras(Integer id) {
        orasRepository.deleteById(id);
    }
}
