package greg.wms.wms.repo;

import greg.wms.wms.model.Dokumenty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import org.springframework.data.domain.Pageable;
import java.util.List;

@RepositoryRestResource
public interface DokumentyRepo extends JpaRepository<Dokumenty, Long> {
    @Query("SELECT d FROM Dokumenty d JOIN FETCH d.uzytkownik JOIN FETCH d.kontrahent")
    List<Dokumenty> findAllDok(Pageable page);
}
