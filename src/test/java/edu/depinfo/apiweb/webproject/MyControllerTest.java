package edu.depinfo.apiweb.webproject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MyControllerTest {

    @InjectMocks
    private MyController myController;

    @Mock
    private Model model;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testHome() {
        String viewName = myController.home();
        assertEquals("index", viewName);
    }

    @Test
    public void testIndex() {
        String viewName = myController.index(model);
        assertEquals("index", viewName);
    }

    @Test
    public void testMap() {
        String viewName = myController.map();
        assertEquals("map", viewName);
    }

    @Test
    public void testMapSearch() {
        String viewName = myController.mapsearch();
        assertEquals("mapsearch", viewName);
    }
}
