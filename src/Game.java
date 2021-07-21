import javax.swing.*;
import java.awt.*;

public class Game extends JPanel {

    Snake snake;
    private final int tileWidth;
    private final int tileHeight;
    private int appleX, appleY;
    private boolean ate;

    public Game () {
        JFrame frame = new JFrame();
        frame.setSize(500, 600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(this);
        frame.setVisible(true);

        snake = new Snake();

        tileWidth = getWidth() / 20;
        tileHeight = getHeight() / 24;
        snake.setSnakePartWidth(tileWidth - 2);
        snake.setSnakePartHeight(tileHeight - 2);
        frame.addKeyListener(new CustomKeyListener(snake));

        generateApple();
    }

    public void paint (Graphics g) {
        g.setColor(Color.yellow);
        g.fillRect(0, 0, getWidth(), getHeight());
        for (BodyPart b : snake.getBodyParts()) {
            g.setColor(Color.black);
            g.fillRect(b.getPosX() * tileWidth - 1, b.getPosY() * tileHeight - 1, snake.getSnakePartWidth(), snake.getSnakePartHeight());
        }
        g.setColor(Color.RED);
        g.fillRect(appleX * tileWidth - 1, appleY * tileHeight - 1, tileWidth - 2, tileHeight - 2);
    }

    public void update () {
        BodyPart head = snake.getBodyParts().get(snake.getBodyParts().size() - 1);
        int x = head.getPosX();
        int y = head.getPosY();
        for (BodyPart part : snake.getBodyParts()) {
            if (part.equals(head)) {
                continue;
            }
            if (x == part.getPosX() && y  == part.getPosY()) {
                System.exit(0);
            }
        }
        if (x == appleX && y == appleY) {
            ate = true;
            generateApple();
            for (BodyPart p : snake.getBodyParts()) {
                if (p.getPosX() == appleX && p.getPosY() == appleY) {
                    generateApple();
                    update();
                }
            }
        }
        if (snake.getxDir() == 1) {
            if (ate) {
                snake.getBodyParts().add(new BodyPart(x + 1, y));
                ate = false;
                return;
            }
            if (head.getPosX() == 20) {
                snake.getBodyParts().add(new BodyPart(0, y));
            }
            else {
                snake.getBodyParts().add(new BodyPart(x + 1, y));
            }
            snake.getBodyParts().remove(0);
        }
        if (snake.getxDir() == -1) {
            if (ate) {
                snake.getBodyParts().add(new BodyPart(x - 1, y));
                ate = false;
                return;
            }
            if (head.getPosX() == 0) {
                snake.getBodyParts().add(new BodyPart(20, y));
            }
            else {
                snake.getBodyParts().add(new BodyPart(x - 1, y));
            }
            snake.getBodyParts().remove(0);
        }
        if (snake.getyDir() == 1) {
            if (ate) {
                snake.getBodyParts().add(new BodyPart(x, y + 1));
                ate = false;
                return;
            }
            if (head.getPosY() == 24) {
                snake.getBodyParts().add(new BodyPart(x, 0));
            }
            else {
                snake.getBodyParts().add(new BodyPart(x, y + 1));
            }
            snake.getBodyParts().remove(0);
        }
        if (snake.getyDir() == -1) {
            if (ate) {
                snake.getBodyParts().add(new BodyPart(x, y - 1));
                ate = false;
                return;
            }
            if (head.getPosY() == 0) {
                snake.getBodyParts().add(new BodyPart(x, 24));
            }
            else {
                snake.getBodyParts().add(new BodyPart(x, y - 1));
            }
            snake.getBodyParts().remove(0);
        }
        paint(getGraphics());
    }

    public void generateApple () {
        appleX = (int)(Math.random() * 20);
        appleY = (int)(Math.random() * 24);
    }
}
