package Week2;

public class RectangleInheritance extends Trapezoid {

    RectangleInheritance(){
        setPoint1(new Point());
        setPoint2(new Point());
        setPoint3(new Point());
        setPoint4(new Point());
    }

    RectangleInheritance(Point point1, Point point2, Point point3, Point point4){
        setPoint1(point1);
        setPoint2(point2);
        setPoint3(point3);
        setPoint4(point4);
    }

    public boolean checkRectangle(){
        if(checkTrapezoid()){
            if(checkParallel1() && checkParallel2()){
                return true;
            }
        }
        return false;
    }
}
