package com.example.touristguide.controller;

import com.example.touristguide.model.AttractionTags;
import com.example.touristguide.model.DanishCity;
import com.example.touristguide.model.TouristAttraction;
import com.example.touristguide.service.TouristService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TouristController.class)
class TouristControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private TouristService touristService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void shouldGetAttractions() throws Exception {
        List<TouristAttraction> attractions = List.of(
                new TouristAttraction(),
                new TouristAttraction()
        );
        when(touristService.getAttractions()).thenReturn(attractions);

        mockMvc.perform(get("/attractions"))
                .andExpect(status().isOk())
                .andExpect(view().name("attractionList"))
                .andExpect(model().attributeExists("attractions"));

        verify(touristService).getAttractionsInCurrency("DKK");
    }

    @Test
    void getAttractionsByName() {
    }

    @Test
    void shouldGetAttractionTags() throws Exception {
        String pathVariable = "GOKART";

        TouristAttraction attraction = new TouristAttraction(pathVariable, null, null, null);

        when(touristService.findAttractionByName(pathVariable)).thenReturn(attraction);

        mockMvc.perform(get("/attractions/GOKART/tags"))
                .andExpect(status().isOk())
                .andExpect(view().name("tags"))
                .andExpect(model().attributeExists("attraction"));

        verify(touristService).findAttractionByName(pathVariable);
    }

    @Test
    void showAttractionRegistrationForm() {
    }

    @Test
    void shouldRegisterAttraction() throws Exception {
        mockMvc.perform(post("/attractions/save")
                        .param("name", "Storkespringvandet")
                        .param("description", "Springvand i København")
                        .param("city", "ODENSE")
                        .param("tags", "SJAELLAND")
                        .param("tags", "LUKSUS"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/attractions"));

        verify(touristService).addAttraction(
                new TouristAttraction(
                        "Storkespringvandet",
                        "Springvand i København",
                        DanishCity.ODENSE,
                        List.of(AttractionTags.SJAELLAND, AttractionTags.LUKSUS)
                )
        );
    }

    @Test
    void editAttraction() {
    }

    @Test
    void updateAttraction() {
    }

    @Test
    void deleteAttraction() {
    }
}