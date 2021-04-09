package mvc.core;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.List;

@Value
@AllArgsConstructor
public class WordsHolder {
    List<Word> words;

    public Word getWord(int key){
        return words.get(key);
    }

    public boolean hasWord(String word){
        return words.stream()
                .map(Word::getLetters)
                .anyMatch(word::equals);
    }
}
