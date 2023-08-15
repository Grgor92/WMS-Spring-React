package greg.wms.wms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Klienci")
public class Klienci {
    @Id
    private long id;
    private String imie;
}
