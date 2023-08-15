package greg.wms.wms.controlers;
import greg.wms.wms.model.Uzytkownicy;
import greg.wms.wms.services.UzytkownicyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor // dzięki temu cała część zakomentowa niżej nie jest potrzebna
@RequestMapping("/api/v1/Users")
public class UzytkownicyController {

    private final UzytkownicyService userService;
////    @Autowired
////    public void setUserService(UzytkownicyService userService) {
////        this.userService = userService;
////    }
//    public UzytkownicyController(UzytkownicyService userService) {
//        this.userService = userService;
//    }

    @GetMapping("/all")
    public ResponseEntity<List<Uzytkownicy>> getAllUsers() {
      return new ResponseEntity<List<Uzytkownicy>>(userService.allUsers(), HttpStatus.OK);
    };
    @GetMapping("/all/name{imie}")
    public ResponseEntity<List<Uzytkownicy>> getByImie(@PathVariable String imie) {
        return new ResponseEntity<List<Uzytkownicy>>(userService.userByImie(imie), HttpStatus.OK);
    };



}
