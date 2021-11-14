package htw.berlin.webtech.filmfinder;

import htw.berlin.webtech.filmfinder.api.Film;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FilmRestController {

    private List<Film> filme;

    public FilmRestController() {
        filme = new ArrayList<>();
        filme.add(new Film("Godzilla", "Monster", 1999));
        filme.add(new Film("King Kong", "Monster", 2004));

    }

    @GetMapping(path = "/api/v1/filme")
    public ResponseEntity<List<Film>> fetchFilme() {
        return ResponseEntity.ok(filme);

    }


}
