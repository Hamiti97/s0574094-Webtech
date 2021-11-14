package htw.berlin.webtech.filmfinder.api;

public class FilmCreateRequest {
    private String titel;
    private String genre;
    private long erscheinungsjahr;

    public FilmCreateRequest(String titel, String genre, long erscheinungsjahr) {
        this.titel = titel;
        this.genre = genre;
        this.erscheinungsjahr = erscheinungsjahr;
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

    public void setErscheinungsjahr(long erscheinungsjahr) {
        this.erscheinungsjahr = erscheinungsjahr;
    }
}
