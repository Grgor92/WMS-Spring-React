package greg.wms.wms.controlers;

import greg.wms.wms.model.Uzytkownicy;
import greg.wms.wms.services.UzytkownicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Users")
public class UzytkownicyController {
    @Autowired
    private UzytkownicyService userService;

    @GetMapping("/all")
    public ResponseEntity<List<Uzytkownicy>> getAllUsers() {
      return new ResponseEntity<List<Uzytkownicy>>(userService.allUsers(), HttpStatus.OK);
    };
}
