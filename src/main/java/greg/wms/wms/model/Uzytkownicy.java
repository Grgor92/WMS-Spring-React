package greg.wms.wms.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Entity
@Table(name = "Uzytkownicy")
@Getter
@Setter
public class Uzytkownicy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_uzyt")
    private Long id_uzyt;
    @Column(name = "imie", length = 20, nullable = false)
    private String imie;
    @Column(name = "login", length = 50, nullable = false, unique = true)
    private String login;
    @Column(name = "email", length = 50, nullable = false, unique = true)
    private String email;
    @Column(name = "haslo", length = 100, nullable = false)
    private String haslo;
    public enum TypUzytkownika {
        Pracownik,
        Administrator,
        Kierownik,
        Biura
    }
//    public String getHaslo() {
//        return "Tajne haslo";
//    };

    @Column(name = "typ", nullable = false)
    @Enumerated(EnumType.STRING)
    private TypUzytkownika typ;
    @Column(name = "stan", length = 30, nullable = false)
    private String stan;
}
