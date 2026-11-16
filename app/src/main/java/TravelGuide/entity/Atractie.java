
package TravelGuide.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "atractie")
public class Atractie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_atractie")
    private Integer idAtractie;

    @Column(name = "nume")
    private String nume;

    @Column(name = "descriere")
    private String descriere;

    @Column(name = "adresa")
    private String adresa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_oras")
    private Oras oras;

    @Column(name = "program")
    private String program;

    @Column(name = "pret_intrare")
    private BigDecimal pretIntrare;

    public Atractie() {
    }

    public Integer getIdAtractie() {
        return idAtractie;
    }

    public void setIdAtractie(Integer idAtractie) {
        this.idAtractie = idAtractie;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public Oras getOras() {
        return oras;
    }

    public void setOras(Oras oras) {
        this.oras = oras;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public BigDecimal getPretIntrare() {
        return pretIntrare;
    }

    public void setPretIntrare(BigDecimal pretIntrare) {
        this.pretIntrare = pretIntrare;
    }
}
