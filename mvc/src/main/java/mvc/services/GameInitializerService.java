package mvc.services;

import mvc.core.Game;
import mvc.core.WordsField;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class GameInitializerService {
    WordsField wordsField;
    int wordsAmount;
    int matchedWordsAmount;

    public Game initialize(){
        return new Game(wordsAmount, matchedWordsAmount, wordsField);
    }
}
