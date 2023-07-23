package greg.wms.wms.repo;

import greg.wms.wms.model.Klienci;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface KlienciRepo extends JpaRepository<Klienci, Long> {
}
