import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Test extends JPanel implements ActionListener, KeyListener {
    private final Map map = new Map();
    private final Player player = new Player();
    private final Bot bot = new Bot(player);

    public Test() {
        Timer timer = new Timer(4, this);
        timer.start();
        setFocusable(true);
        addKeyListener(this);
    }

    public void paint(Graphics g) {
        super.paint(g);
        map.paint(g);
        player.paint(g);
        bot.paint(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player.handleMovement();
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        player.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        player.keyReleased(e);
    }
}
