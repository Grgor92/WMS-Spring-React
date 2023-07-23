package greg.wms.wms.model;
import greg.wms.wms.model.Uzytkownicy;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Dokumenty")
public class Dokumenty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dokumentu")
    private Long id_dokumentu;

    @Column(name = "numer_dok", length = 20, nullable = false, unique = true)
    private String numer_dok;

    @Column(name = "data_wystawienia", nullable = false)
    private LocalDate data_wystawienia;

    @ManyToOne
    @JoinColumn(name = "id_uzyt")
    private Uzytkownicy uzytkownik;

    @ManyToOne
    @JoinColumn(name = "id_kon")
    private Kontrahenci kontrahent;

    @Column(name = "typ_dokumentu", length = 32, nullable = false)
    private String typ_dokumentu;

    @Column(name = "data_przyjecia")
    private LocalDate data_przyjecia;

    @Column(name = "statusd", length = 20, nullable = false)
    private String statusd;

    // Dodaj gettery, settery oraz ewentualnie konstruktory
    // ...

//    public Dokumenty(Integer id_dokumentu, Integer numer_dok) {
//        this.numer_dok = numer_dok;
//        this.id_dokumentu = id_dokumentu;
//    }
}
