package htw.berlin.webtech.filmfinder.persistence;


import javax.persistence.*;

@Entity(name = "filme")
public class FilmEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "titel", nullable = false)
    private String titel;

    @Column(name = "genre", nullable = false)
    private String genre;

    @Column(name ="erscheinungsjahr")
    private long erscheinungsjahr;

    public FilmEntity(String titel, String genre, long erscheinungsjahr) {
        this.titel = titel;
        this.genre = genre;
        this.erscheinungsjahr = erscheinungsjahr;
    }

    protected FilmEntity() {
    }

    public Long getId() {
        return id;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public long getErscheinungsjahr() {
        return erscheinungsjahr;
    }

    public void setErscheinungsjahr(Long erscheinungsjahr) {
        this.erscheinungsjahr = erscheinungsjahr;
    }
}
