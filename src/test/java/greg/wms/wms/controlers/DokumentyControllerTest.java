package greg.wms.wms.controlers;

import greg.wms.wms.WmsApplication;
import greg.wms.wms.model.Dokumenty;
import greg.wms.wms.services.DokumentyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
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

        List<Dokumenty> dokList = new ArrayList<>();

        when(dokumentyService.AllDokumenty(0)).thenReturn(dokList);

        // Wykonanie żądania GET
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/dokumenty/allDok")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn();

        // Sprawdzenie statusu i treści odpowiedzi
        int status = result.getResponse().getStatus();

        // Sprawdzenie statusu - oczekiwany jest status 200
        assertEquals(200, status);

    }
    @Test
    void createDokument() {

    }


    @Test
    void getSingleDok() {

    }

    @Test
    void getSingleDokFiltered() {
    }
}