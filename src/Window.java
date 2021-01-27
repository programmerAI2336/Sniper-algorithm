import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public Window(){
        Test test = new Test();
        add(test);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setExtendedState(Frame.MAXIMIZED_BOTH);

    }
    public static void main(String[] args){
        new Window();
    }
}
