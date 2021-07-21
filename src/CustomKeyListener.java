import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CustomKeyListener implements KeyListener {

    Snake snake;

    public CustomKeyListener (Snake snake) {
        this.snake = snake;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 39 && snake.getxDir() != -1) {
            snake.setxDir(1);
            snake.setyDir(0);
        }
        if (e.getKeyCode() == 37 && snake.getxDir() != 1) {
            snake.setxDir(-1);
            snake.setyDir(0);
        }
        if (e.getKeyCode() == 38 && snake.getyDir() != 1) {
            snake.setyDir(-1);
            snake.setxDir(0);
        }
        if (e.getKeyCode() == 40 && snake.getyDir() != -1) {
            snake.setyDir(1);
            snake.setxDir(0);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
