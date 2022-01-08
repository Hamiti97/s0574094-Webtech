package htw.berlin.webtech.filmfinder.web;

import htw.berlin.webtech.filmfinder.service.FilmService;
import htw.berlin.webtech.filmfinder.web.api.Film;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FilmRestController.class)
class FilmRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FilmService filmService;

    @Test
    @DisplayName("should return found film from film service")
    void should_return_found_film_from_film_service() throws Exception {
        // given
        var filme = List.of(
                new Film(1, "John Wick", "Action", 2015, "0", "0"),
                new Film(2, "2012", "Action", 2012, "0", "0")
        );
        doReturn(filme).when(filmService).findAll();

        // when
        mockMvc.perform(get("/api/v1/filme"))
                // then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].titel").value("John Wick"))
                .andExpect(jsonPath("$[0].genre").value("Action"))
                .andExpect(jsonPath("$[0].erscheinungsjahr").value(2015))
                .andExpect(jsonPath("$[0].imageUrl").value("0"))
                .andExpect(jsonPath("$[0].ytLink").value("0"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].titel").value("2012"))
                .andExpect(jsonPath("$[1].genre").value("Action"))
                .andExpect(jsonPath("$[1].erscheinungsjahr").value(2012))
                .andExpect(jsonPath("$[1].imageUrl").value("0"))
                .andExpect(jsonPath("$[1].ytLink").value("0"));
    }

    @Test
    @DisplayName("should return 404 if person is not found")
    void should_return_404_if_person_is_not_found() throws Exception {
        // given
        doReturn(null).when(filmService).findById(anyLong());

        // when
        mockMvc.perform(get("/api/v1/persons/123"))
                // then
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("should return 201 http status and Location header when creating a person")
    void should_return_201_http_status_and_location_header_when_creating_a_person() throws Exception {
        // given
        String personToCreateAsJson = "{\"titel\": \"John Wick\", \"genre\":\"Action\", \"erscheinungsjahr\": 2015, \"imageUrl\":\"0\", \"ytLink\":\"0\" }";
        var film = new Film(123, null, null, 12345, null, null);
        doReturn(film).when(filmService).create(any());

        // when
        mockMvc.perform(
                        post("/api/v1/filme")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(personToCreateAsJson)
                )
                // then
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
                .andExpect(header().string("Location", Matchers.equalTo(("/api/v1/filme/" + film.getId()))));
//            .andExpect(header().string("Location", Matchers.containsString(Long.toString(person.getId()))));

    }

    @Test
    @DisplayName("should validate create film request")
    void should_validate_create_film_request() throws Exception {
        // given
        String filmToCreateAsJson = "{\"titel\": \"a\", \"genre\":\"\", \"erscheinungsjahr\":, \"imageUrl\":\"0\", \"ytLink\":\"0\" }";

        // when
        mockMvc.perform(
                        post("/api/v1/filme")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(filmToCreateAsJson)
                )
                // then
                .andExpect(status().isBadRequest());
    }
}
