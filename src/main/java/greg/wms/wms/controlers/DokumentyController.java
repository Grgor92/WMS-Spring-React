package greg.wms.wms.controlers;

import greg.wms.wms.model.Dokumenty;
import greg.wms.wms.repo.UzytkownicyRepo;
import greg.wms.wms.repo.KontrahenciRepo;
import greg.wms.wms.services.DokumentyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/dokumenty")
public class DokumentyController {
    public KontrahenciRepo kontrahenciRepository;
    public UzytkownicyRepo uzytkownicyRepository;
    @Autowired
    private DokumentyService dokumentyService;
    @Autowired
    public DokumentyController(DokumentyService dokumentyService) {
        this.dokumentyService = dokumentyService;
    }

    @PostMapping
    public ResponseEntity<String> createDokument(@RequestBody Dokumenty dok) {
//        if (dok.getUzytkownik() != null && dok.getUzytkownik().getId_uzyt() != null) {
//            // Sprawdzenie, czy użytkownik istnieje w bazie danych
//            Optional<Uzytkownicy> uzytkownik = uzytkownicyRepository.findById(dok.getUzytkownik().getId_uzyt());
//            if (uzytkownik.isEmpty()) {
//                return new ResponseEntity<>("Nieprawidłowy użytkownik", HttpStatus.BAD_REQUEST);
//            }
//        }

//        if (dok.getKontrahent() != null && dok.getKontrahent().getId_kon() != null) {
//            // Sprawdzenie, czy kontrahent istnieje w bazie danych
//            Optional<Kontrahenci> kontrahent = kontrahenciRepository.findById(dok.getKontrahent().getId_kon());
//            if (kontrahent.isEmpty()) {
//                return new ResponseEntity<>("Nieprawidłowy kontrahent", HttpStatus.BAD_REQUEST);
//            }
//        }
        try {
            Dokumenty createdDokument = dokumentyService.createDokument(dok);
            return new ResponseEntity<>("Dokument utworzony", HttpStatus.CREATED);
        } catch (DataAccessException ex) {
            String errorMessage = "Wystąpił błąd podczas próby utworzenia dokumentu: " + ex.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception ex) {
            String errorMessage = "Wystąpił nieoczekiwany błąd: " + ex.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/allDok")
    public ResponseEntity<List<Dokumenty>> getAllDokumenty(){
        return new ResponseEntity<List<Dokumenty>>(dokumentyService.AllDokumenty(), HttpStatus.OK);
    }
    @GetMapping("/dok{id_dokumentu}")
    public ResponseEntity<Optional<Dokumenty>> getSingleDok(@PathVariable long id_dokumentu){
        return new ResponseEntity<Optional<Dokumenty>>(dokumentyService.singleDok(id_dokumentu), HttpStatus.OK);
    }
}
