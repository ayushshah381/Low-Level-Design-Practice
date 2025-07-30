import java.util.Map;

/**
 * A mock representation of the request sent by the Alexa platform to our backend.
 */
public class SkillRequest {
    private Session session;
    private String intentName;
    private Map<String, String> slots;

    public SkillRequest(String intentName, Map<String, String> slots, Session session) {
        this.intentName = intentName;
        this.slots = slots;
        this.session = session;
    }

    public String getIntentName() { return intentName; }
    public String getSlot(String name) { return slots.get(name); }
    public Session getSession() { return session; }
}
