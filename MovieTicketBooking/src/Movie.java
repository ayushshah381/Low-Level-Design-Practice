public class Movie {
    private String id;
    private String title;
    private String description;
    private int durationInMinutes;

    public Movie(String id, String title, String description, int durationInMinutes) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.durationInMinutes = durationInMinutes;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }
}
