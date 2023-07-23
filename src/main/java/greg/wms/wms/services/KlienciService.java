package greg.wms.wms.services;
import greg.wms.wms.model.Klienci;
import greg.wms.wms.repo.KlienciRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class KlienciService {
    @Autowired
    private KlienciRepo personRepository;
    public List<Klienci> AllPersons(){
        return personRepository.findAll();
    }
    public Optional<Klienci> singlePerson(Long id){
        return personRepository.findById(id);
    }
}
