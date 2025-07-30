import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class GameState {
    private final int secretNumber;
    private int guessesLeft;
    private final Set<Integer> previousGuesses;

    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 100;
    private final int MAX_GUESSES = 7;

    public GameState() {
        this.secretNumber = new Random().nextInt(MAX_NUMBER) + MIN_NUMBER;
        this.guessesLeft = MAX_GUESSES;
        this.previousGuesses = new HashSet<>();
        System.out.println("The Game has begun. Ssshhhhh.... The secret number is....");
    }

    public int getGuessesLeft() {
        return guessesLeft;
    }

    public int getSecretNumber() {
        return secretNumber;
    }

    public Set<Integer> getPreviousGuesses() {
        return previousGuesses;
    }

    public void recordGuess(int guess) {
        this.previousGuesses.add(guess);
        this.guessesLeft--;
    }

    public boolean hasGuessedBefore(int guess) {
        return this.previousGuesses.contains(guess);
    }
}
