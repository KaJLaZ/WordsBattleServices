package mvc.core;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Game {
    private final int wordsAmount;
    private int matchedWordsAmount;
    private WordsField wordsField;

    public void matchWord(){
        matchedWordsAmount++;
    }
}
