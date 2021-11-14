package htw.berlin.webtech.filmfinder;

import htw.berlin.webtech.filmfinder.api.Film;
import htw.berlin.webtech.filmfinder.api.FilmCreateRequest;
import htw.berlin.webtech.filmfinder.service.FilmService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class FilmRestController {

    private final FilmService filmService;

    public FilmRestController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping(path = "/api/v1/filme")
    public ResponseEntity<List<Film>> fetchFilme() {return ResponseEntity.ok(filmService.findAll());}

    @PostMapping(path = "/api/v1/filme")
    public ResponseEntity<Void> createFilm(@RequestBody FilmCreateRequest request) throws URISyntaxException {
        var film = filmService.create(request);
        URI uri = new URI("/api/v1/filme/" + film.getId());
        return ResponseEntity.created(uri).build();

    }



}
