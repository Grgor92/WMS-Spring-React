package greg.wms.wms.repo;

import greg.wms.wms.model.Kontrahenci;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface KontrahenciRepo extends JpaRepository<Kontrahenci, Long> {
}
