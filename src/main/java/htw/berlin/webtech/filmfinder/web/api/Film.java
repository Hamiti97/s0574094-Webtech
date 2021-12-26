package htw.berlin.webtech.filmfinder.web.api;

public class Film {
    private long id;
    private String titel;
    private String genre;
    private long erscheinungsjahr;
    private String imageUrl;

    public Film(long id, String titel, String genre, long erscheinungsjahr, String imageUrl) {
        this.id = id;
        this.titel = titel;
        this.genre = genre;
        this.erscheinungsjahr = erscheinungsjahr;
        this.imageUrl = imageUrl;
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

    public String getImageUrl() { return imageUrl; }

    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
}
