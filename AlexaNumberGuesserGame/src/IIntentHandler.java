/**
 * The Command interface for our handlers. Each handler is responsible for one
 * specific type of request (e.g., launching the skill, handling a guess).
 */
public interface IIntentHandler {
    SkillResponse handle(SkillRequest request);
}
