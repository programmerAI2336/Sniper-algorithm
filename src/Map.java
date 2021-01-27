import java.awt.*;

public class Map {
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 1366, 768);
        g.setColor(Color.RED);
        g.drawLine(683,0,683,768);
        g.drawLine(0,384,1366,384);
    }
}
