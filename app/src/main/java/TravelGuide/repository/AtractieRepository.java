
package TravelGuide.repository;

import TravelGuide.entity.Atractie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AtractieRepository extends JpaRepository<Atractie, Integer> {

    List<Atractie> findByNumeContainingIgnoreCase(String nume);

    List<Atractie> findByOras_IdOras(Integer idOras);
}
