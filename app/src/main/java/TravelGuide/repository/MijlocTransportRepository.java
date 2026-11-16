
package TravelGuide.repository;

import TravelGuide.entity.MijlocTransport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MijlocTransportRepository
        extends JpaRepository<MijlocTransport, Integer> {
}
