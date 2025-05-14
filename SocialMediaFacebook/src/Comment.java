import java.sql.Timestamp;
import java.util.UUID;

public class Comment {
    private String id;
    private User user;
    private String text;
    private Timestamp timestamp;

    public Comment(User user, String text) {
        this.id = UUID.randomUUID().toString();
        this.user = user;
        this.text = text;
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }

    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getText() {
        return text;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }
}
