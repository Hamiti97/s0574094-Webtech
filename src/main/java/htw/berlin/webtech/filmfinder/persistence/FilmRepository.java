package htw.berlin.webtech.filmfinder.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<FilmEntity, Long> {
    List<FilmEntity> findAllByErscheinungsjahr(long erscheinungsjahr);
}
