
package TravelGuide.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "utilizator")
public class Utilizator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_utilizator")
    private Integer idUtilizator;

    @Column(name = "nume")
    private String nume;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "parola_hash")
    private String parolaHash;

    @Column(name = "data_inregistrarii",
            insertable = false,
            updatable = false)
    private LocalDateTime dataInregistrarii;

    @Column(name = "rol", nullable = false, length = 20)
    private String rol = "USER";

    public Utilizator() {
    }

    public Integer getIdUtilizator() {
        return idUtilizator;
    }

    public void setIdUtilizator(Integer idUtilizator) {
        this.idUtilizator = idUtilizator;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getParolaHash() {
        return parolaHash;
    }

    public void setParolaHash(String parolaHash) {
        this.parolaHash = parolaHash;
    }

    public LocalDateTime getDataInregistrarii() {
        return dataInregistrarii;
    }

    public void setDataInregistrarii(LocalDateTime dataInregistrarii) {
        this.dataInregistrarii = dataInregistrarii;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
