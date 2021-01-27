import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player extends Entity implements KeyListener {
    {
        width = 50;
        length = 50;
    }
    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect((int) x, (int) y, width, length);
    }

    public void handleMovement() {
        x += xSpeed;
        y += ySpeed;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_A){
            xSpeed = -2;
        }
        if(key == KeyEvent.VK_D){
            xSpeed = 2;
        }
        if(key == KeyEvent.VK_S){
            ySpeed = 2;
        }
        if(key == KeyEvent.VK_W){
            ySpeed = -2;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_A){
            xSpeed = 0;
        }
        if(key == KeyEvent.VK_D){
            xSpeed = 0;
        }
        if(key == KeyEvent.VK_S){
            ySpeed = 0;
        }
        if(key == KeyEvent.VK_W){
            ySpeed = 0;
        }
    }
}
