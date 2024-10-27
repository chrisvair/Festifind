package edu.depinfo.apiweb.webproject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class FestivalControllerTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private FestivalController festivalController;

    @Mock
    private Model model; // Modèle simulé

    @Captor
    private ArgumentCaptor<Festivals> festivalsCaptor;

    @BeforeEach
    void setup() {
        festivalController = new FestivalController();
    }

    @Test
    void getFestival() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(festivalController).build();

        mockMvc.perform(get("/festival")
                        .param("search", "Les Nuits (Re)Belles")
                        .param("value", "Festival"))
                .andExpect(status().isOk()) // Vérifie que le statut de la réponse est OK (200)
                .andExpect(view().name("festivals")); // Vérifie que le nom de la vue retournée est "festivals"
    }

    @Test
    void getFestivalCoords() {
        festivalController.getFestival("Paris", "Location", model);

        verify(model).addAttribute(eq("festivals"), festivalsCaptor.capture());
        Festivals festivals = festivalsCaptor.getValue();
        assertEquals(20, festivals.getResults().length);
    }

    @Test
    void calculateDistance() {
        double distance = FestivalController.calculateDistance(48.8566, 2.3522, 48.8566, 2.3522);
        Assertions.assertEquals(0, distance, 0.1);
    }

    @Test
    void getCoordFromName() {
        Coord coord = festivalController.getCoordFromName("Paris");

        Assertions.assertEquals(48.8566, coord.getLon(), 0.1);
        Assertions.assertEquals(2.3522, coord.getLat(), 0.1);
    }
}