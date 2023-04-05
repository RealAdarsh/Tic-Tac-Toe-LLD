package Factory;

import Models.DifficultyLevel;
import Strategies.BotPlayingStrategy.BotPlayingStrategy;
import Strategies.BotPlayingStrategy.RandomBotPlayingStrategty;

public class BotPlayingFactory {
    public static BotPlayingStrategy getStrategyForDifficultyLevel(DifficultyLevel difficultyLevel){
        return new RandomBotPlayingStrategty();
    }
}
