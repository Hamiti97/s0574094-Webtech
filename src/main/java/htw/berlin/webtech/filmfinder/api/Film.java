package htw.berlin.webtech.filmfinder.api;

public class Film {
    private String titel;
    private String genre;
    private long erscheinungsjahr;

    public Film(String titel, String genre, long erscheinungsjahr) {
        this.titel = titel;
        this.genre = genre;
        this.erscheinungsjahr = erscheinungsjahr;
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
