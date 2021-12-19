package htw.berlin.webtech.filmfinder.web.api;

public class FilmCreateOrUpdateRequest {
    private String titel;
    private String genre;
    private long erscheinungsjahr;

    public FilmCreateOrUpdateRequest(String titel, String genre, long erscheinungsjahr) {
        this.titel = titel;
        this.genre = genre;
        this.erscheinungsjahr = erscheinungsjahr;
    }
    public FilmCreateOrUpdateRequest() {}

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

    public void setErscheinungsjahr(long erscheinungsjahr) {
        this.erscheinungsjahr = erscheinungsjahr;
    }
}
