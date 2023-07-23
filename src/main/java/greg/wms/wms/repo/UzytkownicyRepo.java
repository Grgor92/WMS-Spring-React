package greg.wms.wms.repo;

import greg.wms.wms.model.Uzytkownicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UzytkownicyRepo extends JpaRepository<Uzytkownicy, Long> {

}
