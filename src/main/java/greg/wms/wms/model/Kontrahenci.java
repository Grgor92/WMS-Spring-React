package greg.wms.wms.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Data
@Entity
@Table(name = "kontrahenci")
public class Kontrahenci {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_kon")
    private Long id_kon;
    @Column(name = "NIP", length = 20)
    private String NIP;
    @Column(name = "nazwa_firmy", nullable = false, length = 50)
    private String nazwa_firmy;
    @Column(name = "miasto", nullable = false, length = 50)
    private String miasto;
    @Column(name = "ulica", nullable = false, length = 50)
    private String ulica;
    @Column(name = "numer", nullable = false, length = 10)
    private String numer;
    @Column(name = "kod_pocztowy", length = 10)
    private String kodPocztowy;
    @Column(name = "kraj", length = 50)
    private String kraj;
    @Column(name = "email", length = 100)
    private String email;
    @Column(name = "telefon", nullable = false, length = 20)
    private String telefon;
    @Column(name = "status", nullable = false, length = 32)
    private String status;
    @Column(name = "data_rejestracji")
    @Temporal(TemporalType.DATE)
    private Date dataRejestracji;
    @Column(name = "data_modyfikacji")
    @Temporal(TemporalType.DATE)
    private Date dataModyfikacji;
    @Column(name = "stan", nullable = false, length = 32)
    private String stan;




}

