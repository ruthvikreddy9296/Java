package academy.learnprogramming.config;

import academy.learnprogramming.GuessCount;
import academy.learnprogramming.MaxNumber;
import academy.learnprogramming.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config/game.properties")
public class GameConfig {

    @Value("${game.maxNumber:20}")
    private int maxNumber=100;
    @Value("${game.guessCount:5}")
    private  int guessCount=5;
    @Value("${game.minNumber:5}")
    private int minNumber=5;

    @Bean
    @MaxNumber
    public int getMaxNumber(){
        return maxNumber;
    }

    @Bean
    @GuessCount
    public  int getGuessCount(){
        return guessCount;
    }

    @Bean
    @MinNumber
    public int getMinNumber(){
        return minNumber;
    }
}
