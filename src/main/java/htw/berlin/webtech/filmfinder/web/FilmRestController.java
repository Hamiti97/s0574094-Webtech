package htw.berlin.webtech.filmfinder.web;

import htw.berlin.webtech.filmfinder.web.api.Film;
import htw.berlin.webtech.filmfinder.web.api.FilmCreateOrUpdateRequest;
import htw.berlin.webtech.filmfinder.service.FilmService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(path = "/api/v1/filme/{id}")
    public ResponseEntity<Film> fetchFilmById(@PathVariable Long id) {
        var film = filmService.findById(id);
        return film != null? ResponseEntity.ok(film) : ResponseEntity.notFound().build();
    }
    @PostMapping(path = "/api/v1/filme")
    public ResponseEntity<Void> createFilm(@RequestBody FilmCreateOrUpdateRequest request) throws URISyntaxException {
        var film = filmService.create(request);
        URI uri = new URI("/api/v1/filme/" + film.getId());
        return ResponseEntity.created(uri).build();
    }
    @PutMapping(path = "/api/v1/filme/{id}")
    public ResponseEntity<Film> updateFilm(@PathVariable Long id, @RequestBody FilmCreateOrUpdateRequest request) {
        var film = filmService.update(id, request);
        return film != null? ResponseEntity.ok(film) : ResponseEntity.notFound().build();
    }
    @DeleteMapping(path = "/api/v1/filme/{id}")
    public ResponseEntity<Void> deleteFilm(@PathVariable Long id) {
        boolean successful = filmService.deleteById(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
