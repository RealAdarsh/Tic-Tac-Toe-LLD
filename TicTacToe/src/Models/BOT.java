package Models;

import Factory.BotPlayingFactory;
import Strategies.BotPlayingStrategy.BotPlayingStrategy;

public class BOT extends Player{
    private DifficultyLevel difficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;

    public BOT(String name, char symbol, DifficultyLevel difficultyLevel){
        super(name, symbol,PlayerType.BOT);
        this.difficultyLevel=difficultyLevel;
        this.botPlayingStrategy= BotPlayingFactory.getStrategyForDifficultyLevel(difficultyLevel);
    }

    public DifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public BotPlayingStrategy getBotPlayingStrategy() {
        return botPlayingStrategy;
    }

    public void setBotPlayingStrategy(BotPlayingStrategy botPlayingStrategy) {
        this.botPlayingStrategy = botPlayingStrategy;
    }
}
