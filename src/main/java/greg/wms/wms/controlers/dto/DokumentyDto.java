package greg.wms.wms.controlers.dto;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
@Getter
@Builder
public class DokumentyDto {
    private Long id_dokumentu;
    private String numer_dok;
    private LocalDate data_wystawienia;
    private String typ_dokumentu;
    private LocalDate data_przyjecia;
    private String statusd;
}
