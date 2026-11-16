
package TravelGuide.repository;

import TravelGuide.entity.Oras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrasRepository extends JpaRepository<Oras, Integer> {
}
