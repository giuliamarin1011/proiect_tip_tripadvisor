
package TravelGuide.service;

import TravelGuide.entity.MijlocTransport;
import TravelGuide.repository.MijlocTransportRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MijlocTransportService {

    private final MijlocTransportRepository mijlocTransportRepository;

    public MijlocTransportService(MijlocTransportRepository mijlocTransportRepository) {
        this.mijlocTransportRepository = mijlocTransportRepository;
    }

    public List<MijlocTransport> getAllMijloaceTransport() {
        return mijlocTransportRepository.findAll();
    }

    public Optional<MijlocTransport> getMijlocTransportById(Integer id) {
        return mijlocTransportRepository.findById(id);
    }

    public MijlocTransport saveMijlocTransport(MijlocTransport mijlocTransport) {
        return mijlocTransportRepository.save(mijlocTransport);
    }

    public void deleteMijlocTransport(Integer id) {
        mijlocTransportRepository.deleteById(id);
    }
}
