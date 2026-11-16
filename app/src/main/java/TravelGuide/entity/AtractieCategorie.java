
package TravelGuide.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "atractie_categorie")
@IdClass(AtractieCategorie.AtractieCategorieId.class)
public class AtractieCategorie {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_atractie")
    private Atractie atractie;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categorie")
    private Categorie categorie;

    public AtractieCategorie() {
    }

    public Atractie getAtractie() {
        return atractie;
    }

    public void setAtractie(Atractie atractie) {
        this.atractie = atractie;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public static class AtractieCategorieId implements Serializable {

        private Integer atractie;
        private Integer categorie;

        public AtractieCategorieId() {
        }

        public AtractieCategorieId(Integer atractie, Integer categorie) {
            this.atractie = atractie;
            this.categorie = categorie;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof AtractieCategorieId)) return false;

            AtractieCategorieId that = (AtractieCategorieId) obj;

            return Objects.equals(atractie, that.atractie)
                    && Objects.equals(categorie, that.categorie);
        }

        @Override
        public int hashCode() {
            return Objects.hash(atractie, categorie);
        }
    }
}
