
package TravelGuide.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "traseu")
public class Traseu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_traseu")
    private Integer idTraseu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_atractie")
    private Atractie atractie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_transport")
    private MijlocTransport mijlocTransport;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_oras_plecare")
    private Oras orasPlecare;

    @Column(name = "descriere")
    private String descriere;

    @Column(name = "durata_minute")
    private Integer durataMinute;

    @Column(name = "distanta_km")
    private BigDecimal distantaKm;

    @Column(name = "cost_estimativ")
    private BigDecimal costEstimativ;

    public Traseu() {
    }

    public Integer getIdTraseu() {
        return idTraseu;
    }

    public void setIdTraseu(Integer idTraseu) {
        this.idTraseu = idTraseu;
    }

    public Atractie getAtractie() {
        return atractie;
    }

    public void setAtractie(Atractie atractie) {
        this.atractie = atractie;
    }

    public MijlocTransport getMijlocTransport() {
        return mijlocTransport;
    }

    public void setMijlocTransport(MijlocTransport mijlocTransport) {
        this.mijlocTransport = mijlocTransport;
    }

    public Oras getOrasPlecare() {
        return orasPlecare;
    }

    public void setOrasPlecare(Oras orasPlecare) {
        this.orasPlecare = orasPlecare;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public Integer getDurataMinute() {
        return durataMinute;
    }

    public void setDurataMinute(Integer durataMinute) {
        this.durataMinute = durataMinute;
    }

    public BigDecimal getDistantaKm() {
        return distantaKm;
    }

    public void setDistantaKm(BigDecimal distantaKm) {
        this.distantaKm = distantaKm;
    }

    public BigDecimal getCostEstimativ() {
        return costEstimativ;
    }

    public void setCostEstimativ(BigDecimal costEstimativ) {
        this.costEstimativ = costEstimativ;
    }
}
