package Animation;

import java.awt.*;

import javax.swing.*;

public class Animation {
    int x = 0,  //70; 300
        y = 0;  //70; 90

    class DrawPanel extends JPanel {
        public void paintComponent(Graphics g) {
            g.setColor(Color.white);

            g.fillRect(0, 0, this.getWidth(), this.getHeight());

            g.setColor(Color.red);
            g.fillOval(x, y, 50, 50);
        }
    }

    public void go() {
        JFrame frame = new JFrame("Animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DrawPanel panel = new DrawPanel();
        frame.getContentPane().add(panel);

        frame.setSize(300, 300);
        frame.setVisible(true);

        // цикл после того как фрейм показался!
        // иначе ничего не увидим
        for (int i = 0; i < 130; i++) {
            x++; //3; -3;
            y++; //0; 0;
            panel.repaint();

            //добавил реверс
            if (i == 129) {
                for (i = 129; i > 0; i--) {
                    x--;
                    y--;
                    panel.repaint();

                    try {
                        Thread.sleep(50);
                    } catch (Exception e) {
                    }
                }
            }

            try {
                Thread.sleep(50);
            } catch (Exception e) {
            }
        }

    }

    public static void main(String[] args) {
        Animation circle = new Animation();
        circle.go();

    }
}
