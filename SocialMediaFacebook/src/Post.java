import java.sql.Timestamp;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Post {
    private String id;
    private User author;
    private String content;
    private Timestamp timestamp;
    private Map<String, Like> userIdLikeMap;
    private List<Comment> comments;

    public Post(User author, String content) {
        this.id = UUID.randomUUID().toString();
        this.author = author;
        this.content = content;
        this.timestamp = new Timestamp(System.currentTimeMillis());
        this.userIdLikeMap = new ConcurrentHashMap<>();
        this.comments = Collections.synchronizedList(new ArrayList<>());
    }

    public synchronized void like(User user) {
        // Like if not already liked
        if(!userIdLikeMap.containsKey(user.getId())) {
            userIdLikeMap.put(user.getId(), new Like(user));
        }
        // Unlike if already liked
        else {
            userIdLikeMap.remove(user.getId());
        }
    }

    public void comment(User user, String text) {
        comments.add(new Comment(user,text));
    }

    public int getLikeCount() {
        return userIdLikeMap.size();
    }

    public int getCommentCount() {
        return comments.size();
    }

    public String getId() {
        return id;
    }

    public User getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public List<Comment> getComments() {
        return comments;
    }
}
