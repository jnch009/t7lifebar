import javafx.geometry.Point2D;
public class transformationHelpers {
    public Point2D applyShear(Point2D toShear, double tx, double ty){
        double x = toShear.getX()*1 + toShear.getY()*tx;
        double y = toShear.getX()*ty + toShear.getY()*1;
        return new Point2D(x,y);
    }
    
}