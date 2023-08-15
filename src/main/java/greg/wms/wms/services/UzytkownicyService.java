package greg.wms.wms.services;
import greg.wms.wms.repo.UzytkownicyRepo;
import greg.wms.wms.model.Uzytkownicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UzytkownicyService {

    @Autowired
    private UzytkownicyRepo uzytkownicyRepo;
    public List<Uzytkownicy> allUsers() { return uzytkownicyRepo.findAll(); };
    public Optional<Uzytkownicy> userById(long id) { return uzytkownicyRepo.findById(id);};
    public List<Uzytkownicy> userByImie(String imie) { return uzytkownicyRepo.findByImie(imie);};



}
