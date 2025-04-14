import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Answer implements Votable, Commentable {
    private final int answerId;
    private final String content;
    private final User author;
    private Question question;
    private boolean isAccepted;
    private final Date creationDate;
    private final List<Comment> commentList;
    private final List<Vote> voteList;

    public Answer(User author, Question question, String content) {
        this.answerId = generateId();
        this.content = content;
        this.author = author;
        this.question = question;
        this.isAccepted = false;
        this.creationDate = new Date();
        this.commentList = new ArrayList<>();
        this.voteList = new ArrayList<>();
    }

    @Override
    public void addComment(Comment comment) {
        commentList.add(comment);
    }

    @Override
    public List<Comment> getComments() {
        return new ArrayList<>(commentList);
    }

    @Override
    public void vote(User user, int value) {
        if (value != 1 && value != -1) {
            throw new IllegalArgumentException("Vote value must be either 1 or -1");
        }
        voteList.removeIf(v -> v.getUser().equals(user));
        voteList.add(new Vote(user, value));
        author.updateReputation(value * 10);  // +10 for upvote, -10 for downvote
    }

    @Override
    public int getVoteCount() {
        return voteList.stream().mapToInt(Vote::getValue).sum();
    }

    public void markAsAccepted() {
        if (isAccepted) {
            throw new IllegalStateException("This answer is already accepted");
        }
        isAccepted = true;
        author.updateReputation(15);  // +15 reputation for accepted answer
    }

    private int generateId() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    // Getters
    public int getId() { return answerId; }
    public User getAuthor() { return author; }
    public Question getQuestion() { return question; }
    public String getContent() { return content; }
    public Date getCreationDate() { return creationDate; }
    public boolean isAccepted() { return isAccepted; }
}
