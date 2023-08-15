package greg.wms.wms.model;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
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

    @Column(name = "typ_dokumentu", length = 32, nullable = false)
    private String typ_dokumentu;

    @Column(name = "data_przyjecia")
    private LocalDate data_przyjecia;

    @Column(name = "statusd", length = 20, nullable = false)
    private String statusd;

    @ManyToOne
    @JoinColumn(name = "id_uzyt", updatable = false, insertable = false)
    private Uzytkownicy uzytkownik;

    @ManyToOne
    @JoinColumn(name = "id_kon", updatable = false, insertable = false)
    private Kontrahenci kontrahent;

}
