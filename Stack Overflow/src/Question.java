import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Question implements Votable, Commentable {
    private final int questionId;
    private final String content;
    private String title;
    private final User author;
    private final Date creationDate;
    private final List<Answer> answerList;
    private final List<Comment> commentList;
    private final List<Vote> voteList;
    private List<Tag> tagList;

    public Question(User author, String title, String content, List<String> tagNames) {
        this.questionId = generateId();
        this.author = author;
        this.title = title;
        this.content = content;
        this.creationDate = new Date();
        this.answerList = new ArrayList<>();
        this.commentList = new ArrayList<>();
        this.voteList = new ArrayList<>();
        this.tagList = new ArrayList<>();
        for (String tagName : tagNames) {
            this.tagList.add(new Tag(tagName));
        }
    }


    private int generateId() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    public void addAnswer(Answer answer) {
        if (!answerList.contains(answer)) {
            answerList.add(answer);
        }
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
        author.updateReputation(value * 5);  // +5 for upvote, -5 for downvote
    }

    @Override
    public int getVoteCount() {
        return voteList.stream().mapToInt(Vote::getValue).sum();
    }

    // Getters
    public int getId() { return questionId; }
    public User getAuthor() { return author; }
    public String getTitle() { return title; }
    public String getContent() { return content; }
    public Date getCreationDate() { return creationDate; }
    public List<Answer> getAnswers() { return new ArrayList<>(answerList); }
    public List<Tag> getTags() { return new ArrayList<>(tagList); }
}
