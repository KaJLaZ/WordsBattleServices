package mvc.services;

import mvc.core.WordsHolder;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class WordVerificationService {
    WordsHolder wordsHolder;

    public boolean isCorrect(String word){
        return wordsHolder.hasWord(word);
    }
}
