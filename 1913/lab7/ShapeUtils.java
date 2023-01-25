
public class ShapeUtils {
    
    
    /**
     * 
     * @param p1 -- first point
     * @param p2 -- second point
     * @return the distance between the two points
     */
    public static double distance(Point p1, Point p2) {

        double a, b, c, d;
        a = p1.getX();
        b = p1.getY();
        c = p2.getX();
        d = p2.getY();
        
        return Math.sqrt(Math.pow((a-c),2)+Math.pow((b-d),2));
    }

    /**
     * 
     * @param points -- an array of points
     * @return the average point (averages x value and y value seperately)
     * 
     */
    public static Point getCenter(Point[] points) {

        if (points.length > 0) {

            double countX = 0.0;
            double countY = 0.0;

            for(int i = 0; i<points.length; i++) {
                countX = countX + points[i].getX();
                countY = countY + points[i].getY();
            }

            double centerX= countX/(points.length);
            double centerY = countY/(points.length);
            

        Point answer = new Point(centerX, centerY);
        return answer;
        }

        else {
            Point answer = new Point(0, 0);
            return answer;

        }

    }

    /**
     * 
     * @param points -- an array of points
     * @return -- an array of triangles able to form with those points
     */
    public static Triangle[] makeFakePoly(Point[] points) {
        Triangle[] output = new Triangle [points.length];

        for(int i = 0; i<points.length-1; i++) {
            output[i] = new Triangle(points[i],points[i+1], getCenter(points));
        }
        output[points.length-1] = new Triangle(points[points.length-1], points[0],getCenter(points));

        return output;
    }

    /**
     * 
     * @param c -- a circle with center and radius
     * @return returns area of the circle
     */
    public static double getArea(Circle c) {
        return Math.pow(c.getRadius(),2) * Math.PI;
    }

    /**
     * 
     * @param t -- a triangle with three points
     * @return the area of the triangle
     */
    public static double getArea(Triangle t) {
        
        double t1 = t.getP1().getX() * (t.getP2().getY()-t.getP3().getY());
        double t2 = t.getP2().getX() * (t.getP3().getY()-t.getP1().getY());
        double t3 = t.getP3().getX() * (t.getP1().getY()-t.getP2().getY());

        double area = 0.5 * Math.abs(t1+t2+t3);

        return area;
    }
    
    /**
     * 
     * @param t -- a triangle with three points
     * @param p -- a point
     * @return whether or not the point is in the triangle
     */
    public static boolean isIn(Triangle t, Point p) {
        Point a = t.getP1();
        Point b = t.getP2();
        Point c = t.getP3();

        Triangle x = new Triangle(p,b,c);
        Triangle y= new Triangle(a,p,c);
        Triangle z = new Triangle(a,b,p);

        double totalArea = getArea(x) + getArea(y) + getArea(z);

        return Math.abs(totalArea- getArea(t)) <0.00001;
    }

    /**
     * 
     * @param c -- a circle with a center and radius
     * @param p -- a point
     * @return whether or not the point is in the circle
     */
    public static boolean isIn(Circle c, Point p) {

        return distance(c.getCenter(),p) <= c.getRadius();
    }

    /**
     * 
     * @param c1 -- a circle with a center and radius
     * @param c2 -- a circle with a center and radius
     * @return whether or not the circles overlap
     */
    public static boolean isThereOverlap(Circle c1, Circle c2) {
        return distance(c1.getCenter(),c2.getCenter()) < c1.getRadius() + c2.getRadius();
    }


}
