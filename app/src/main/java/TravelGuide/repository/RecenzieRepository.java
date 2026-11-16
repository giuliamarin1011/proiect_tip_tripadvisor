
package TravelGuide.repository;

import TravelGuide.entity.Recenzie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecenzieRepository extends JpaRepository<Recenzie, Integer> {

    List<Recenzie> findByAtractie_IdAtractie(Integer idAtractie);

    List<Recenzie> findByUtilizator_IdUtilizator(Integer idUtilizator);
}
