package greg.wms.wms.controlers;

import greg.wms.wms.model.Dokumenty;
import greg.wms.wms.services.DokumentyService;
import lombok.RequiredArgsConstructor;
import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/dokumenty")
public class DokumentyController {
    @Autowired
    private DokumentyService dokumentyService;

    @PostMapping
    public ResponseEntity<String> createDokument(@RequestBody Dokumenty dok) {
        try {
            Dokumenty createdDokument = dokumentyService.createDokument(dok);
            return new ResponseEntity<>("Dokument utworzony", HttpStatus.CREATED);
        } catch (DataAccessException ex) {
            String errorMessage = "Wystąpił błąd podczas próby utworzenia dokumentu: " + ex.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception ex) {
            String errorMessage = "Wystąpił nieoczekiwany błąd: " + ex.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/allDok")
    public ResponseEntity<List<Dokumenty>> getAllDokumenty(@RequestParam(required = false) Integer page){
        Integer pageNumber = (page != null && page >= 0) ? page : 0;
        try{
            List<Dokumenty> dokList= dokumentyService.AllDokumenty(pageNumber);
            return new ResponseEntity<List<Dokumenty>>(dokList, HttpStatus.OK);
        }catch (DataAccessException ex){
            String ErMsg = "Wystąpił błąd podczas dostępu do bazy" + ex.getMessage();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ErMsg);
        }catch (DataException ex){
            String ErMsg = "Wystąpił błąd podczas wykonaywania zapytania" + ex.getMessage();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErMsg);
        }

    }
//
//    private List<DokumentyDto> mapToDokumentyDtos(List<Dokumenty> listDok) {
//        return listDok.stream()
//                .map(dokument -> mapToDokumentyDto(dokument))
//                .collect(Collectors.toList());
//    }
//
//    private DokumentyDto mapToDokumentyDto(Dokumenty dokumenty) {
//        return DokumentyDto.builder()
//                .id_dokumentu(dokumenty.getId_dokumentu())
//                .numer_dok(dokumenty.getNumer_dok())
//                .data_wystawienia(dokumenty.getData_wystawienia())
//                .typ_dokumentu(dokumenty.getTyp_dokumentu())
//                .data_przyjecia(dokumenty.getData_przyjecia())
//                .statusd(dokumenty.getStatusd())
//                .build();
//    }


    @GetMapping("/dok/{id_dokumentu}")
    public ResponseEntity<Optional<Dokumenty>> getSingleDok(@PathVariable long id_dokumentu){
        return new ResponseEntity<Optional<Dokumenty>>(dokumentyService.singleDok(id_dokumentu), HttpStatus.OK);
    }

    @GetMapping("/dokf{filter}")
    public ResponseEntity<Optional<Dokumenty>> getSingleDokFiltered(@PathVariable long id_dokumentu){
        throw new IllegalArgumentException("Not implemented");
    }
}
