import javax.swing.JFrame;
import javax.swing.JPanel;

import javafx.geometry.Point2D;

import java.awt.Polygon;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp; // for applying the affine transformation

public class t7lifebar extends JPanel{

    public void paint(Graphics g) {
        Image img = createLifeBar();
        g.drawImage(img, 100,200,this);
        Image img2 = createLifeBarWithShear();
        g.drawImage(img2, 0,0,this);
     }

     private Image createLifeBar(){
        BufferedImage bufferedImage = new BufferedImage(550,50,BufferedImage.TYPE_INT_RGB);
        Graphics g = bufferedImage.getGraphics();
        //yellow
        Color start = new Color(255,255,0);
        //orange
        Color end = new Color(255,165,0);
        g.setColor(start);
        for (int j = 0; j <= 50; j++){
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

     private Image createLifeBarWithShear(){
        BufferedImage bufferedImage = new BufferedImage(800,800,BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bufferedImage.createGraphics();

        //yellow
        Color start = new Color(255,255,0);
        //orange
        Color end = new Color(255,165,0);


        g.setColor(Color.white);
        g.fillRect(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight());

        g.setColor(Color.blue);
        Polygon lifeBar = new Polygon();
        Point2D p1 = new Point2D(100, 200);

        // lifeBar.addPoint(100,200);
        // lifeBar.addPoint(100,150);
        // lifeBar.addPoint(650,150);
        // lifeBar.addPoint(650,200);
        // g.drawPolygon(lifeBar);
        // start.getRed()


        // TODO: interpolate from yellow to orange 
        // END GOAL is to do bilinear interpolation, focus on 1 dimension first
        // formula is: c = a + (b-a)*t

        //g.setColor(Color.RED);
        
        // for (int j = 0; j <= 50; j++){
        //     for (int i = 0; i <= 550; i++){
        //         if (i > 0){
        //             float t = (float)i / 550;
        //             // TODO: refactor the following into a method
        //             int currentColorR = (int)Math.round(start.getRed() + (end.getRed() - start.getRed()) * t);
        //             int currentColorB = (int)Math.round(start.getBlue() + (end.getBlue() - start.getBlue()) * t);
        //             int currentColorG = (int)Math.round(start.getGreen() + (end.getGreen() - start.getGreen()) * t);
        //             g.setColor(new Color(currentColorR,currentColorG,currentColorB));
        //         }
        //         g.drawLine(i, j, i, j);
        //     }
        // }
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

