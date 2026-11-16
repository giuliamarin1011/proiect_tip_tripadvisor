
package TravelGuide.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "mijloc_transport")
public class MijlocTransport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transport")
    private Integer idTransport;

    @Column(name = "denumire", unique = true)
    private String denumire;

    public MijlocTransport() {
    }

    public Integer getIdTransport() {
        return idTransport;
    }

    public void setIdTransport(Integer idTransport) {
        this.idTransport = idTransport;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }
}
