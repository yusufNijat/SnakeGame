
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                game.update();
            }
        };
        Timer timer = new Timer("Timer");
        timer.scheduleAtFixedRate(timerTask, 0, 100);
    }
}
