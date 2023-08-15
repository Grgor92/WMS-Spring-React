package greg.wms.wms.controlers;

import com.fasterxml.jackson.databind.ObjectMapper;
import greg.wms.wms.WmsApplication;
import greg.wms.wms.model.Dokumenty;
import greg.wms.wms.model.Kontrahenci;
import greg.wms.wms.model.Uzytkownicy;
import greg.wms.wms.services.DokumentyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {WmsApplication.class})
@WebMvcTest(DokumentyController.class)
class DokumentyControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DokumentyService dokumentyService;
    @Test
    void getAllDokumenty() throws Exception {
        Dokumenty document1 = new Dokumenty();
        document1.setId_dokumentu(1L);
        document1.setNumer_dok("ABC123");
        document1.setData_wystawienia(LocalDate.of(2023, 8, 15));
        document1.setTyp_dokumentu("Faktura");
        document1.setData_przyjecia(LocalDate.of(2023, 8, 15));
        document1.setStatusd("Nowy");
        Uzytkownicy uzytkownik = new Uzytkownicy();
        uzytkownik.setId_uzyt(1L);
        Kontrahenci kontrahent = new Kontrahenci();
        kontrahent.setId_kon(1L);
        document1.setUzytkownik(uzytkownik);
        document1.setKontrahent(kontrahent);

        List<Dokumenty> documentList = new ArrayList<>();
        documentList.add(document1);
        when(dokumentyService.AllDokumenty(0)).thenReturn(documentList);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/dokumenty/allDok")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn();
        int status = result.getResponse().getStatus();
        String body = result.getResponse().getContentAsString();
        Assertions.assertEquals(200, status);
//        Assertions.assertEquals("[{\"id_dokumentu\":1,\"numer_dok\":\"ABC123\",\"data_wystawienia\":\"2023-08-15\",\"typ_dokumentu\":\"Faktura\",\"data_przyjecia\":\"2023-08-15\",\"statusd\":\"Nowy\",\"uzytkownik\":{\"id_uzyt\":1,\"imie\":null,\"login\":null,\"email\":null,\"haslo\":null,\"typ\":null,\"stan\":null},\"kontrahent\":{\"id_kon\":1,\"nazwa_firmy\":null,\"miasto\":null,\"ulica\":null,\"numer\":null,\"kodPocztowy\":null,\"kraj\":null,\"email\":null,\"telefon\":null,\"status\":null,\"dataRejestracji\":null,\"dataModyfikacji\":null,\"stan\":null,\"nip\":null}}]", body);
        Assertions.assertTrue(body.contains("ABC123"));
    }
    @Test
    void createDokument() throws Exception {
        Dokumenty dokument = new Dokumenty();
        ObjectMapper objectMapper = new ObjectMapper();
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/dokumenty")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dokument)))
                .andExpect(MockMvcResultMatchers.status().isCreated());
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/dokumenty")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/dokumenty")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("Niepoprawne ciało żądania"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    void getSingleDok() {

    }

    @Test
    void getSingleDokFiltered() {
    }
}