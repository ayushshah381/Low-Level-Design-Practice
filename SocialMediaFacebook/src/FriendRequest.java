public class FriendRequest {
    private User from;
    private User to;
    private FriendRequestStatus friendRequestStatus = FriendRequestStatus.PENDING;

    public FriendRequest(User from, User to) {
        this.from = from;
        this.to = to;
    }

    public void accept() {
        this.friendRequestStatus = FriendRequestStatus.ACCEPTED;
    }

    public void reject() {
        this.friendRequestStatus = FriendRequestStatus.REJECTED;
    }

    public User getFrom() {
        return from;
    }

    public User getTo() {
        return to;
    }

    public FriendRequestStatus getFriendRequestStatus() {
        return friendRequestStatus;
    }
}
