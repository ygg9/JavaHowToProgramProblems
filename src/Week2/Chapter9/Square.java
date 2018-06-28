package Week2.Chapter9;

public class Square extends RectangleInheritance {
    Square(){
        setPoint1(new Point());
        setPoint2(new Point());
        setPoint3(new Point());
        setPoint4(new Point());
    }

    Square(Point point1, Point point2, Point point3, Point point4){
        setPoint1(point1);
        setPoint2(point2);
        setPoint3(point3);
        setPoint4(point4);
    }

    public boolean checkSquare(){
        if(checkRectangle()){
            double length1, length2;
            length1 = getDistance(getPoint1(), getPoint2());
            length2 = getDistance(getPoint2(), getPoint3());
            if(length1 == length2){
                return true;
            }
        }
        return false;
    }
}
