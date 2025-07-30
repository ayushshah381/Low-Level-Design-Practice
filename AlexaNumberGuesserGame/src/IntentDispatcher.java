import java.util.HashMap;
import java.util.Map;

/**
 * The router that delegates requests to the correct handler.
 */
public class IntentDispatcher {
    private final Map<String, IIntentHandler> handlers;

    public IntentDispatcher() {
        this.handlers = new HashMap<>();
        handlers.put("LaunchRequest", new LaunchRequestHandler());
        handlers.put("GuessIntent", new GuessIntentHandler());
        handlers.put("AMAZON.YesIntent", new YesNoIntentHandler());
        handlers.put("AMAZON.NoIntent", new YesNoIntentHandler());
    }

    public SkillResponse dispatch(SkillRequest request) {
        IIntentHandler handler = handlers.get(request.getIntentName());
        if (handler != null) {
            return handler.handle(request);
        }
        return new SkillResponse("Sorry, I don't know how to handle that. Please try again.", false);
    }
}
