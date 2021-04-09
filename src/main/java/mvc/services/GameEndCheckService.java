package mvc.services;

import mvc.core.Game;

public class GameEndCheckService {

    public boolean isGameEnd(Game game){
        return game.getMatchedWordsAmount() >= game.getWordsAmount();
    }

    public void clientAnswerProcess(Game game, boolean isWordMatched){
        if (isWordMatched){
            game.matchWord();
        }
    }
}
