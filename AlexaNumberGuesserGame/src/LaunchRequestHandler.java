public class LaunchRequestHandler implements IIntentHandler{

    @Override
    public SkillResponse handle(SkillRequest request) {
        // Create a new Game state
        GameState newGame = new GameState();

        // Set this newGame in the current session
        request.getSession().setAttribute("GAME_STATE", newGame);

        // Formulate the welcome message
        String welcomeText = "Welcome to Guess the Number. I have chosen a number between 1 to 100. What is your guess?";

        // Generate the Response
        return new SkillResponse(welcomeText, false);
    }
}
