package htw.berlin.webtech.filmfinder.service;

import htw.berlin.webtech.filmfinder.api.Film;
import htw.berlin.webtech.filmfinder.api.FilmCreateRequest;
import htw.berlin.webtech.filmfinder.persistence.FilmEntity;
import htw.berlin.webtech.filmfinder.persistence.FilmRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmService {

    private final FilmRepository filmRepository;

    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public List<Film> findAll() {
        List<FilmEntity> filme = filmRepository.findAll();
        return filme.stream()
                .map(this::transformEntity).collect(Collectors.toList());
    }

    public Film create(FilmCreateRequest request) {
        var filmEntity = new FilmEntity(request.getTitel(), request.getGenre(), request.getErscheinungsjahr());
        filmEntity = filmRepository.save(filmEntity);
        return transformEntity(filmEntity);
    }

    private Film transformEntity(FilmEntity filmEntity) {
        return new Film(
                filmEntity.getId(),
                filmEntity.getGenre(),
                filmEntity.getTitel(),
                filmEntity.getErscheinungsjahr()
        );
    }
}
