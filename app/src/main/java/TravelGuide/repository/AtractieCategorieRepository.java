
package TravelGuide.repository;

import TravelGuide.entity.AtractieCategorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtractieCategorieRepository
        extends JpaRepository<AtractieCategorie,
        AtractieCategorie.AtractieCategorieId> {
}
