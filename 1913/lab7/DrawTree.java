// Authors: Vennela Dupati
// CSCI 1913
import java.awt.Color;

public class DrawTree { 
public static void main(String[] args) {
    
    // creates new shape
    ShapeDrawer shape = new ShapeDrawer();

    //creates triangle, makes it brown, and draws it
    Point p1 = new Point(30,110);
    Point p2 = new Point(50,50);
    Point p3 = new Point(70,110);
    Triangle t = new Triangle(p1,p2,p3);
    Color triangleColor= new Color(150,75,0);
    shape.setFill(triangleColor);
    shape.setStroke(triangleColor);
    shape.draw(t);

    // creates array of points, makes fake polygon with those points, makes it green, and draws it
    Point[] points = new Point [5];

    points[0] = new Point(0,70);
    points[1] = new Point(30,40);
    points[2] = new Point(50,30);
    points[3] = new Point(70,40);
    points[4] = new Point(100,70);

    Triangle[] polygon = ShapeUtils.makeFakePoly(points);
    Color polyColor= new Color(0,153,0);
    shape.setFill(polyColor);
    shape.setStroke(polyColor);
    shape.draw(polygon);
   
    // creates circle, makes it yellow, and draws it
    Point sunCenter = new Point(20,20);
    Circle sun = new Circle(sunCenter,8);
    shape.setFill(new Color(255,255,0));
    shape.setStroke(new Color(255,255,0));
    shape.draw(sun);


    //creates circle, makes it purple, and draws it
    Point decCenter = new Point(50,30);
    Circle decor = new Circle(decCenter,3);
    shape.setFill(new Color(102,102,255));
    shape.setStroke(new Color(102,102,255));
    shape.draw(decor);


    // creates file of drawing
    shape.writeToFile("tree.png");

    
    
}

}