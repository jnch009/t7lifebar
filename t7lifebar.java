import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class t7lifebar extends JPanel{

    public void paint(Graphics g) {
        Image img = createLifeBar();
        g.drawImage(img, 100,200,this);
     }

     private Image createLifeBar(){
        BufferedImage bufferedImage = new BufferedImage(550,50,BufferedImage.TYPE_INT_RGB);
        Graphics g = bufferedImage.getGraphics();

        //yellow
        Color start = new Color(255,255,0);
        //orange
        Color end = new Color(255,165,0);

        // start.getRed()


        // TODO: interpolate from yellow to orange 
        // END GOAL is to do bilinear interpolation, focus on 1 dimension first
        // formula is: c = a + (b-a)*t

        g.setColor(start);
        
        for (int j = 0; j <= 100; j++){
            for (int i = 0; i <= 550; i++){
                if (i > 0){
                    float t = (float)i / 550;
                    // TODO: refactor the following into a method
                    int currentColorR = (int)Math.round(start.getRed() + (end.getRed() - start.getRed()) * t);
                    int currentColorB = (int)Math.round(start.getBlue() + (end.getBlue() - start.getBlue()) * t);
                    int currentColorG = (int)Math.round(start.getGreen() + (end.getGreen() - start.getGreen()) * t);
                    g.setColor(new Color(currentColorR,currentColorG,currentColorB));
                }
                g.drawLine(i, j, i, j);
            }
        }
        return bufferedImage;
     }


    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.getContentPane().add(new t7lifebar());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setVisible(true);
    }

}

