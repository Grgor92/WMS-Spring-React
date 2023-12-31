package greg.wms.wms.repo;

import greg.wms.wms.model.Uzytkownicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface UzytkownicyRepo extends JpaRepository<Uzytkownicy, Long> {

    List<Uzytkownicy> findByImie(String imie);


}
