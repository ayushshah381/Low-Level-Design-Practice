import java.util.Map;

public class Main {
    public static void main(String[] args) {
        IntentDispatcher dispatcher = new IntentDispatcher();
        Session session = new Session(); // A single session for the entire interaction.

        System.out.println("--- Simulating 'Guess the Number' Game ---");

        // --- Turn 1: User launches the skill ---
        System.out.println("\nUser says: 'Alexa, open Number Guesser'");
        SkillRequest launchReq = new SkillRequest("LaunchRequest", Map.of(), session);
        SkillResponse launchRes = dispatcher.dispatch(launchReq);
        System.out.println("Alexa responds: " + launchRes.getSpeech());

        // --- Turn 2: User makes a guess ---
        System.out.println("\nUser says: 'my guess is 50'");
        SkillRequest guessReq1 = new SkillRequest("GuessIntent", Map.of("Number", "50"), session);
        SkillResponse guessRes1 = dispatcher.dispatch(guessReq1);
        System.out.println("Alexa responds: " + guessRes1.getSpeech());

        // --- Turn 3: User makes another guess ---
        System.out.println("\nUser says: 'my guess is 25'");
        SkillRequest guessReq2 = new SkillRequest("GuessIntent", Map.of("Number", "25"), session);
        SkillResponse guessRes2 = dispatcher.dispatch(guessReq2);
        System.out.println("Alexa responds: " + guessRes2.getSpeech());

        // --- Turn 4: User makes a winning guess (we'll cheat and find the number) ---
        GameState finalState = session.getAttribute("GAME_STATE");
        if (finalState != null) {
            int secretNumber = finalState.getSecretNumber();
            System.out.println("\nUser says: 'is it " + secretNumber + "?'");
            SkillRequest winReq = new SkillRequest("GuessIntent", Map.of("Number", String.valueOf(secretNumber)), session);
            SkillResponse winRes = dispatcher.dispatch(winReq);
            System.out.println("Alexa responds: " + winRes.getSpeech());
        }

        // --- Turn 5: User wants to play again ---
        System.out.println("\nUser says: 'yes'");
        SkillRequest yesReq = new SkillRequest("AMAZON.YesIntent", Map.of(), session);
        SkillResponse yesRes = dispatcher.dispatch(yesReq);
        System.out.println("Alexa responds: " + yesRes.getSpeech());
    }
}