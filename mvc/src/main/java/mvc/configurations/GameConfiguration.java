package mvc.configurations;

import mvc.core.Word;
import mvc.core.WordsField;
import mvc.core.WordsHolder;
import mvc.services.GameEndCheckService;
import mvc.services.GameInitializerService;
import mvc.services.WordVerificationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class GameConfiguration {

    @Bean
    public GameEndCheckService gameEndCheckService(){
        return new GameEndCheckService();
    }

    @Bean
    public WordVerificationService wordVerificationService(WordsHolder wordsHolder){
        return new WordVerificationService(wordsHolder);
    }

    @Bean
    public GameInitializerService gameInitializerService(WordsField wordsField,
                                                         @Value("${WordsAmount}") int wordsAmount,
                                                         @Value("${MatchedWordsAmountOnStart}") int matchedWordsAmount){
        return new GameInitializerService(wordsField, wordsAmount, matchedWordsAmount);
    }

    @Bean
    public WordsField wordsField(WordsHolder wordsHolder){
        return new WordsField(wordsHolder.getWords());
    }

    @Bean
    public WordsHolder wordsHolder(@Value("${FirstWord}") String firstWord,
                                   @Value("${SecondWord}") String secondWord,
                                   @Value("${ThirdWord}") String thirdWord) {
        ArrayList<Word> words = new ArrayList<>();

        words.add(new Word(0, firstWord));
        words.add(new Word(1, secondWord));
        words.add(new Word(2, thirdWord));

        return new WordsHolder(words);
    }
}
