package htw.berlin.webtech.filmfinder.service;

import htw.berlin.webtech.filmfinder.web.api.Film;
import htw.berlin.webtech.filmfinder.web.api.FilmCreateOrUpdateRequest;
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
    public Film findById(Long id) {
        var filmEntity = filmRepository.findById(id);
        return filmEntity.map(this::transformEntity).orElse(null);
    }

    public Film create(FilmCreateOrUpdateRequest request) {
        var filmEntity = new FilmEntity(request.getTitel(), request.getGenre(), request.getErscheinungsjahr(), request.getImageUrl());
        filmEntity = filmRepository.save(filmEntity);
        return transformEntity(filmEntity);
    }

    public Film update(Long id, FilmCreateOrUpdateRequest request) {
        var filmEntityOptional = filmRepository.findById(id);
        if (filmEntityOptional.isEmpty()) {
            return null;
        }
        var filmEntity = filmEntityOptional.get();
        filmEntity.setTitel(request.getTitel());
        filmEntity.setGenre(request.getGenre());
        filmEntity.setErscheinungsjahr(request.getErscheinungsjahr());
        filmEntity.setImageUrl(request.getImageUrl());
        filmEntity = filmRepository.save(filmEntity);

        return transformEntity(filmEntity);
    }

    public boolean deleteById(Long id) {
        if (!filmRepository.existsById(id)) {
            return false;
        }
        filmRepository.deleteById(id);
        return true;
    }

    private Film transformEntity(FilmEntity filmEntity) {
        return new Film(
                filmEntity.getId(),
                filmEntity.getGenre(),
                filmEntity.getTitel(),
                filmEntity.getErscheinungsjahr(),
                filmEntity.getImageUrl()
        );
    }
}
