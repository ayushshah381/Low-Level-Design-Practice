import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Group {
    private String groupId;
    private String name;
    private List<User> members;
    private List<Expense> expenses;

    public Group(String name) {
        this.groupId = UUID.randomUUID().toString();
        this.name = name;
        this.members = new ArrayList<>();
        this.expenses = new ArrayList<>();
    }

    public String getGroupId() { return groupId; }
    public String getName() { return name; }
    public List<User> getMembers() { return members; }
    public List<Expense> getExpenses() { return expenses; }

    public void addMember(User member) {
        this.members.add(member);
    }

    public void addExpense(Expense expense) {
        this.expenses.add(expense);
    }

}
