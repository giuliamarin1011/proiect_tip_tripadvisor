
package TravelGuide.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "recenzie")
public class Recenzie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recenzie")
    private Integer idRecenzie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_utilizator")
    private Utilizator utilizator;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_atractie")
    private Atractie atractie;

    @Column(name = "nota")
    private Integer nota;

    @Column(name = "comentariu")
    private String comentariu;

    @Column(name = "data_recenziei",
            insertable = false,
            updatable = false)
    private LocalDateTime dataRecenziei;

    public Recenzie() {
    }

    public Integer getIdRecenzie() {
        return idRecenzie;
    }

    public void setIdRecenzie(Integer idRecenzie) {
        this.idRecenzie = idRecenzie;
    }

    public Utilizator getUtilizator() {
        return utilizator;
    }

    public void setUtilizator(Utilizator utilizator) {
        this.utilizator = utilizator;
    }

    public Atractie getAtractie() {
        return atractie;
    }

    public void setAtractie(Atractie atractie) {
        this.atractie = atractie;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public String getComentariu() {
        return comentariu;
    }

    public void setComentariu(String comentariu) {
        this.comentariu = comentariu;
    }

    public LocalDateTime getDataRecenziei() {
        return dataRecenziei;
    }

    public void setDataRecenziei(LocalDateTime dataRecenziei) {
        this.dataRecenziei = dataRecenziei;
    }
}
