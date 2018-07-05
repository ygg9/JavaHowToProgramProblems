package Week2.Chapter9;

public class Trapezoid extends Quadrilateral {

    Trapezoid() {
        setPoint1(new Point());
        setPoint2(new Point());
        setPoint3(new Point());
        setPoint4(new Point());
    }

    Trapezoid(Point point1, Point point2, Point point3, Point point4) {
        setPoint1(point1);
        setPoint2(point2);
        setPoint3(point3);
        setPoint4(point4);
    }

    public boolean checkTrapezoid() {
        if (checkQuadrilateral()) {
            if (checkParallel1() || checkParallel2()) {
                return true;
            }
        }
        return false;
    }

    // checks if first line is parallel with opposite line
    public boolean checkParallel1() {
        Point point1 = getPoint1();
        Point point2 = getPoint2();
        Point point3 = getPoint3();
        Point point4 = getPoint4();

        double denom1 = point1.getxCoordinate() - point2.getxCoordinate();
        double denom2 = point3.getxCoordinate() - point4.getxCoordinate();
        if (denom1 == 0 || denom2 == 0) {
            if (denom1 == denom2) {
                return true;
            }
            return false;
        }

        double slope1To2 = (point1.getyCoordinate() - point2.getyCoordinate()) / (point1.getxCoordinate() - point2.getxCoordinate());
        double slope3To4 = (point3.getyCoordinate() - point4.getyCoordinate()) / (point3.getxCoordinate() - point4.getxCoordinate());
        if (slope1To2 == slope3To4) {
            return true;
        }
        return false;
    }

    public boolean checkParallel2() {
        Point point1 = getPoint1();
        Point point2 = getPoint2();
        Point point3 = getPoint3();
        Point point4 = getPoint4();

        double denom1 = point1.getxCoordinate() - point2.getxCoordinate();
        double denom2 = point3.getxCoordinate() - point4.getxCoordinate();
        if (denom1 == 0 || denom2 == 0) {
            if (denom1 == denom2) {
                return true;
            }
            return false;
        }

        double slope2To3 = (point2.getyCoordinate() - point3.getyCoordinate()) / (point2.getxCoordinate() - point3.getxCoordinate());
        double slope4To1 = (point4.getyCoordinate() - point1.getyCoordinate()) / (point4.getxCoordinate() - point1.getxCoordinate());
        if (slope2To3 == slope4To1) {
            return true;
        }
        return false;
    }
}
