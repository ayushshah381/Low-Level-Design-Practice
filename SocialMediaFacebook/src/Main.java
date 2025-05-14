import java.util.List;

public class Main {
    public static void main(String[] args) {
        SocialNetworkingService service = SocialNetworkingService.getInstance();

        // Register new users
        User user1 = service.registerUser("John Doe", "john@example.com", "password", "I love coding!");
        User user2 = service.registerUser("Jane Smith", "jane@example.com", "password", "Exploring the world!");

        // User login
        User loggedInUser = service.loginUser("john@example.com", "password");
        if (loggedInUser != null) {
            System.out.println("User logged in: " + loggedInUser.getName());
        } else {
            System.out.println("Invalid email or password.");
        }

        // Send friend request
        service.sendFriendRequest(user1.getId(), user2.getId());

        // Accept friend request
        service.acceptFriendRequest(user2.getId(), user1.getId());

        // Create posts
        Post post1 = service.createPost(user1.getId(), "My first post!");
        Post post2 = service.createPost(user2.getId(), "Having a great day!");

        // Like a post
        service.likePost(user2.getId(), post1.getId());

        // Comment on a post
        service.commentOnPost(user2.getId(), post1.getId(), "Great post!");

        // Get newsfeed
        List<Post> newsfeed = service.getUserFeed(user2.getId());
        System.out.println("Newsfeed:");
        for (Post post : newsfeed) {
            System.out.println("Post: " + post.getContent());
            System.out.println("Likes: " + post.getLikeCount());
            System.out.println("Comments: " + post.getComments().size());
            System.out.println();
        }

        // Get notifications
        List<Notification> notifications = service.getNotifications(user1.getId());
        System.out.println("Notifications:");
        for (Notification notification : notifications) {
            System.out.println("Type: " + notification.getType());
            System.out.println("Content: " + notification.getContent());
        }
    }
}