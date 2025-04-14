import java.util.ArrayList;
import java.util.List;

public class User {
    private final int userId;
    private final String name;
    private String email;
    private int reputation;
    private final List<Question> questionList;
    private final List<Answer> answerList;
    private final List<Comment> commentList;

    private static final int QUESTION_REPUTATION = 5;
    private static final int ANSWER_REPUTATION = 10;
    private static final int COMMENT_REPUTATION = 2;

    public User(int id, String name, String email) {
        this.userId = id;
        this.name = name;
        this.email = email;
        this.reputation = 0;
        this.questionList = new ArrayList<>();
        this.answerList = new ArrayList<>();
        this.commentList = new ArrayList<>();
    }

    public synchronized void updateReputation(int rep) {
        this.reputation += rep;
        if(this.reputation < 0) this.reputation = 0;
    }

    public Question askQuestion(String title, String content, List<String> tags) {
        Question question = new Question(this, title,content, tags);
        questionList.add(question);
        // Gain 5 reputation points for asking a question
        updateReputation(QUESTION_REPUTATION);
        return question;
    }

    public Answer answerQuestion(Question question, String content) {
        Answer answer = new Answer(this, question, content);
        answerList.add(answer);
        question.addAnswer(answer);
        updateReputation(ANSWER_REPUTATION); // Gain 10 reputation for answering
        return answer;
    }

    public Comment addComment(Commentable commentable, String content) {
        Comment comment = new Comment(this, content);
        commentList.add(comment);
        commentable.addComment(comment);
        updateReputation(COMMENT_REPUTATION); // Gain 2 reputation for commenting
        return comment;
    }

    // Getters
    public int getId() { return userId; }
    public String getUsername() { return name; }
    public int getReputation() { return reputation; }
    public List<Question> getQuestions() { return new ArrayList<>(questionList); }
    public List<Answer> getAnswers() { return new ArrayList<>(answerList); }
    public List<Comment> getComments() { return new ArrayList<>(commentList); }
}
