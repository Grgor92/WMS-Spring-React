package greg.wms.wms.services;

import greg.wms.wms.model.Kontrahenci;
import greg.wms.wms.model.Uzytkownicy;
import greg.wms.wms.repo.KontrahenciRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class KontrahenciService {
    @Autowired
    private KontrahenciRepo kontrahenciRepo;

    public List<Kontrahenci> allKon() { return kontrahenciRepo.findAll(); };
}
