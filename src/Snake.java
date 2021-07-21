import java.util.ArrayList;
import java.util.List;

public class Snake {

    private int snakePartWidth, snakePartHeight;
    private int xDir, yDir;
    private List<BodyPart> bodyParts = new ArrayList<>();

    public Snake() {
        bodyParts.add(new BodyPart(1, 5));
        bodyParts.add(new BodyPart(2, 5));
        bodyParts.add(new BodyPart(3, 5));
        bodyParts.add(new BodyPart(4, 5));
        bodyParts.add(new BodyPart(5, 5));
        xDir = 1;
    }

    public int getSnakePartWidth() {
        return snakePartWidth;
    }

    public void setSnakePartWidth(int snakePartWidth) {
        this.snakePartWidth = snakePartWidth;
    }

    public int getSnakePartHeight() {
        return snakePartHeight;
    }

    public void setSnakePartHeight(int snakePartHeight) {
        this.snakePartHeight = snakePartHeight;
    }

    public int getxDir() {
        return xDir;
    }

    public void setxDir(int xDir) {
        this.xDir = xDir;
    }

    public int getyDir() {
        return yDir;
    }

    public void setyDir(int yDir) {
        this.yDir = yDir;
    }

    public List<BodyPart> getBodyParts() {
        return bodyParts;
    }

    public void setBodyParts(List<BodyPart> bodyParts) {
        this.bodyParts = bodyParts;
    }
}
