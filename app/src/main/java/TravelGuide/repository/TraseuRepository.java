
package TravelGuide.repository;

import TravelGuide.entity.Traseu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TraseuRepository extends JpaRepository<Traseu, Integer> {

    List<Traseu> findByAtractie_IdAtractie(Integer idAtractie);

    List<Traseu> findByMijlocTransport_IdTransport(Integer idTransport);

    List<Traseu> findByOrasPlecare_IdOras(Integer idOras);
}
