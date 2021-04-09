package mvc.core;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class Word {
    int id;
    String letters;
}
