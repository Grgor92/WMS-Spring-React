package greg.wms.wms.controlers;
import greg.wms.wms.services.KlienciService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import greg.wms.wms.model.Klienci;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/klienci")
public class KlienciController {
    @Autowired
    private KlienciService KlienciService;
    @GetMapping("/all")
    public ResponseEntity<List<Klienci>> getAllPersons(){
        return new ResponseEntity<List<Klienci>>(KlienciService.AllPersons(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Klienci>> getSinglePerson(@PathVariable long id){
        return new ResponseEntity<Optional<Klienci>>(KlienciService.singlePerson(id), HttpStatus.OK);
    }
}
