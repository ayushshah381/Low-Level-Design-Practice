public class YesNoIntentHandler implements IIntentHandler{
    @Override
    public SkillResponse handle(SkillRequest request) {
        // This handler is only valid when a game has just ended.
        // A real skill would use more complex state management to confirm this.
        if (request.getIntentName().equals("AMAZON.YesIntent")) {
            // If yes, delegate to the LaunchRequestHandler to start a new game.
            return new LaunchRequestHandler().handle(request);
        } else {
            // If no, give a goodbye message and end the session.
            return new SkillResponse("Okay, thanks for playing!", true);
        }
    }
}
