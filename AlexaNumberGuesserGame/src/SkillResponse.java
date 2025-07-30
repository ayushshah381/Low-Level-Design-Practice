/**
 * A mock representation of the response our backend sends back to Alexa.
 */
public class SkillResponse {
    private final String speech;
    private final boolean shouldEndSession;

    public SkillResponse(String speech, boolean shouldEndSession) {
        this.speech = speech;
        this.shouldEndSession = shouldEndSession;
    }
    public String getSpeech() { return speech; }
    public boolean shouldEndSession() { return shouldEndSession; }
}
