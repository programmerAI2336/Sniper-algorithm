import java.awt.*;

public class Bot extends Entity {
    private final Player player;

    public Bot(Player player) {
        this.player = player;
    }

    {
        x = 658;
        y = 359;
        width = 50;
        length = 50;
    }

    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect((int) x, (int) y, width, length);
    }

    public void aim() {
        double a1 = x - player.y;
        double a2 = player.xSpeed;
        double b1 = y - player.y;
        double b2 = player.ySpeed;
        double cosOfAngle1 = (a1 * a2 + b1 * b2) / (Math.sqrt(Math.pow(a1, 2) + Math.pow(b1, 2)) * Math.sqrt(Math.pow(a2, 2) + Math.pow(b2, 2)));
    }
}
