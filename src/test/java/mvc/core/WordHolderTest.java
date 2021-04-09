package mvc.core;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class WordHolderTest {
    static WordsHolder wordsHolder;

    @BeforeAll
    static void initializeHolder(){
        List<Word> words = new ArrayList<>();

        words.add(new Word(1, "asd"));

        wordsHolder = new WordsHolder(words);
    }

    @Test
    public void getWord(){
        Word a = wordsHolder.getWord(0);
    }
}
