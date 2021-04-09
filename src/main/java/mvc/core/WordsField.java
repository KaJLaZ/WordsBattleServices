package mvc.core;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.List;

@Value
@AllArgsConstructor
public class WordsField {
    List<Word> words;
}
