public class GuessIntentHandler implements IIntentHandler{
    private String generateHint(int guess, int secretNumber) {
        int diff = Math.abs(secretNumber - guess);
        String direction = guess < secretNumber ? "low" : "high";

        if (diff <= 5) {
            return "You're very close! But your guess is a bit too " + direction + ".";
        } else if (diff <= 15) {
            return "Your guess is too " + direction + ", but you're getting warmer.";
        } else {
            return "Your guess is way too " + direction + ".";
        }
    }

    @Override
    public SkillResponse handle(SkillRequest request) {
        Session session = request.getSession();
        GameState gameState = session.getAttribute("GAME_STATE");

        // Check if a game is in progress
        if(gameState == null) {
            return new SkillResponse("You need to start a game first. Say 'Start Game' to begin.", false);
        }

        int guess;
        try {
            guess = Integer.parseInt(request.getSlot("Number"));
        } catch (NumberFormatException e) {
            return new SkillResponse("Sorry, I didn't understand that. Please say a number between 1 and 100.", false);
        }

        if (gameState.hasGuessedBefore(guess)) {
            return new SkillResponse("You've already guessed " + guess + ". Try a different number.", false);
        }

        gameState.recordGuess(guess);
        int secretNumber = gameState.getSecretNumber();

        // 1. Win Condition
        if (guess == secretNumber) {
            session.setAttribute("GAME_STATE", null); // Clear the game state
            return new SkillResponse("Wow, you got it! The number was " + secretNumber + ". Congratulations! Would you like to play again?", false);
        }

        // 2. Loss Condition
        if (gameState.getGuessesLeft() == 0) {
            session.setAttribute("GAME_STATE", null); // Clear the game state
            return new SkillResponse("Sorry, you're out of guesses. The number I was thinking of was " + secretNumber + ". Would you like to play again?", false);
        }

        // 3. Hint Generation
        String hint = generateHint(guess, secretNumber);
        String speechText = hint + " You have " + gameState.getGuessesLeft() + " guesses left.";

        // Save the updated state back to the session
        session.setAttribute("GAME_STATE", gameState);

        return new SkillResponse(speechText, false);
    }
}
