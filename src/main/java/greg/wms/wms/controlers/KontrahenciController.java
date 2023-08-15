package greg.wms.wms.controlers;

import greg.wms.wms.model.Kontrahenci;
import greg.wms.wms.services.KontrahenciService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Kon")
public class KontrahenciController {
    @Autowired
    private KontrahenciService kontrahenciService;

//    public void setKontrahenciService(KontrahenciService kontrahenciService) {
//        this.kontrahenciService = kontrahenciService;
//    }

    @GetMapping("/all")
    public ResponseEntity<List<Kontrahenci>> getAllKon() {
        return new ResponseEntity<List<Kontrahenci>>(kontrahenciService.allKon(), HttpStatus.OK);
    };
}
