package htw.berlin.webtech.filmfinder.web.api;

public class Film {
    private long id;
    private String titel;
    private String genre;
    private long erscheinungsjahr;

    public Film(long id, String titel, String genre, long erscheinungsjahr) {
        this.id = id;
        this.titel = titel;
        this.genre = genre;
        this.erscheinungsjahr = erscheinungsjahr;
    }

    public long getId() {
        return id;
    }

    public String getTitel() {
        return titel;
    }

    public String getGenre() {
        return genre;
    }

    public long getErscheinungsjahr() {
        return erscheinungsjahr;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setErscheinungsjahr(long erscheinungsjahr) {
        this.erscheinungsjahr = erscheinungsjahr;
    }
}
