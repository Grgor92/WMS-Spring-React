package greg.wms.wms.services;

import greg.wms.wms.model.Dokumenty;
import greg.wms.wms.repo.DokumentyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DokumentyService {

    @Autowired
    private DokumentyRepo dokumnetyRepository;
    public Dokumenty createDokument(Dokumenty dok){
        return dokumnetyRepository.save(dok);
    }
//    public List<Dokumenty> AllDokumenty(){
//        return dokumnetyRepository.findAll();
//    }
    public List<Dokumenty> AllDokumenty(int page){
        return dokumnetyRepository.findAllDok(PageRequest.of(page, 5));
    }
    public Optional<Dokumenty> singleDok(Long id_dokumentu){
        return dokumnetyRepository.findById(id_dokumentu);
    }
}
