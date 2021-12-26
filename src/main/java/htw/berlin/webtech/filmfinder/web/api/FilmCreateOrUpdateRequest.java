package htw.berlin.webtech.filmfinder.web.api;

public class FilmCreateOrUpdateRequest {
    private String titel;
    private String genre;
    private long erscheinungsjahr;
    private String imageUrl;

    public FilmCreateOrUpdateRequest(String titel, String genre, long erscheinungsjahr, String imageUrl) {
        this.titel = titel;
        this.genre = genre;
        this.erscheinungsjahr = erscheinungsjahr;
        this.imageUrl = imageUrl;
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

    public String getImageUrl() { return imageUrl; }

    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
}
