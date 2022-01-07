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

    @Column(name ="imageUrl")
    private String imageUrl;

    @Column(name ="ytLink")
    private String ytLink;

    public FilmEntity(String titel, String genre, long erscheinungsjahr, String imageUrl, String ytLink) {
        this.titel = titel;
        this.genre = genre;
        this.erscheinungsjahr = erscheinungsjahr;
        this.imageUrl = imageUrl;
        this.ytLink = ytLink;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getYtLink() { return ytLink; }

    public void setYtLink(String ytLink) { this.ytLink = ytLink; }
}
