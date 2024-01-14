package de.htwberlin.webtech.Fitnessplan.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.htwberlin.webtech.Fitnessplan.Service.TraindayService;
import de.htwberlin.webtech.Fitnessplan.web.api.Trainday;
import de.htwberlin.webtech.Fitnessplan.web.api.TraindayManipulationRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@ExtendWith(MockitoExtension.class)
public class TraindayRestControllerTest {

    private MockMvc mockMvc;

    @Mock
    private TraindayService traindayService;

    @InjectMocks
    private TraindayRestController traindayRestController;

    ObjectMapper objectMapper = new ObjectMapper();


    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(traindayRestController).build();
    }

    @Test
    @DisplayName("überprüft ob eine liste zurückgegeben wird")
    void fetchTraindayShouldReturnList() throws Exception {
        when(traindayService.findAll()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/api/v1/trainday"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        verify(traindayService, times(1)).findAll();
    }

    @Test
    @DisplayName("überprüft ob ein einzelner trainday zurückgegeben wird")
    void fetchTraindayByIdShouldReturnTrainday() throws Exception {
        Long id = 1L;
        Trainday trainday = new Trainday(id, "Test", LocalDate.now());
        when(traindayService.findById(id)).thenReturn(trainday);

        mockMvc.perform(get("/api/v1/trainday/{id}", id))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.name").value("Test"));

        verify(traindayService, times(1)).findById(id);
    }
    @Test
    @DisplayName("überprüft ob eine createt status meldung zurückgegebn wird")
    void createTraindayShouldCreateTrainday() throws Exception {
        String jsonContent = "{\"name\":\"Legday2\",\"date\":[2024,1,18]}";
        Trainday trainday = new Trainday(1L,"Legday2",LocalDate.of(2024,1,18));
        when(traindayService.create(any())).thenReturn(trainday);

        mockMvc.perform(post("/api/v1/trainday")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonContent))
                .andExpect(status().isCreated());

        verify(traindayService, times(1)).create(any());
    }

    @Test
    void updateTraindayShouldUpdateTrainday() throws Exception {
        Long id = 1L;
        String jsonContent = "{\"name\":\"Updated\",\"date\":[2024,1,18]}";
        Trainday updatedTrainday = new Trainday(id, "Updated", LocalDate.of(2024,1,18));
        when(traindayService.update(eq(id), any())).thenReturn(updatedTrainday);


        mockMvc.perform(put("/api/v1/trainday/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonContent))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Updated"));

        verify(traindayService, times(1)).update(eq(id), any());
    }

    @Test
    void deleteTraindayShouldDeleteTrainday() throws Exception {
        Long id = 1L;
        when(traindayService.deleteById(id)).thenReturn(true);

        mockMvc.perform(delete("/api/v1/trainday/{id}", id))
                .andExpect(status().isOk());

        verify(traindayService, times(1)).deleteById(id);
    }
}
