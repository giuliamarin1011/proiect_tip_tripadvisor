
package TravelGuide.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "oras")
public class Oras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_oras")
    private Integer idOras;

    @NotBlank(message = "Numele orașului este obligatoriu.")
    @Size(max = 100, message = "Numele nu poate depăși 100 de caractere.")
    @Column(name = "nume", nullable = false)
    private String nume;

    @Size(max = 100, message = "Județul nu poate depăși 100 de caractere.")
    @Column(name = "judet")
    private String judet;

    @NotBlank(message = "Țara este obligatorie.")
    @Size(max = 100, message = "Țara nu poate depăși 100 de caractere.")
    @Column(name = "tara")
    private String tara;

    @Size(max = 1000, message = "Descrierea nu poate depăși 1000 de caractere.")
    @Column(name = "descriere")
    private String descriere;

    public Oras() {
    }

    public Integer getIdOras() {
        return idOras;
    }

    public void setIdOras(Integer idOras) {
        this.idOras = idOras;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getJudet() {
        return judet;
    }

    public void setJudet(String judet) {
        this.judet = judet;
    }

    public String getTara() {
        return tara;
    }

    public void setTara(String tara) {
        this.tara = tara;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }
}
