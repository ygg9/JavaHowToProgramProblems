package Week2;

public class Quadrilateral {
    private Point point1;
    private Point point2;
    private Point point3;
    private Point point4;

    Quadrilateral(){
        this.point1 = new Point();
        this.point2 = new Point();
        this.point3 = new Point();
        this.point4 = new Point();
    }

    Quadrilateral(Point point1, Point point2, Point point3, Point point4 ){
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
        this.point4 = point4;
    }

    public double getArea(){
        double firstShoelace = point1.getxCoordinate() * point2.getyCoordinate() + point2.getxCoordinate() * point3.getyCoordinate() + point3.getxCoordinate() * point4.getyCoordinate();
        double secondShoeLace = point1.getyCoordinate() * point2.getxCoordinate() + point2.getyCoordinate() * point3.getxCoordinate() + point3.getyCoordinate() * point4.getxCoordinate();
        return .5 * Math.abs(firstShoelace - secondShoeLace);
    }

    public Point getPoint1() {
        return point1;
    }

    public void setPoint1(Point point1) {
        this.point1 = point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public void setPoint2(Point point2) {
        this.point2 = point2;
    }

    public Point getPoint3() {
        return point3;
    }

    public void setPoint3(Point point3) {
        this.point3 = point3;
    }

    public Point getPoint4() {
        return point4;
    }

    public void setPoint4(Point point4) {
        this.point4 = point4;
    }

    public double getDistance(Point point1, Point point2){
        double squareX = Math.pow(point2.getxCoordinate() - point1.getxCoordinate(), 2.0);
        double squareY = Math.pow(point2.getyCoordinate() - point1.getyCoordinate(), 2.0);
        return Math.sqrt(squareX + squareY);
    }

    public boolean checkQuadrilateral(){
        if (!checkIntersect(point1, point2, point3, point4)) {
            if(!checkIntersect(point1, point4, point2, point3)){
                return true;
            }
        }
        return false;
    }

    public boolean checkIntersect(Point point1, Point point2, Point point3, Point point4){
        int o1 = checkOrientation(point1, point2, point4);
        int o2 = checkOrientation(point1, point2, point3);
        int o3 = checkOrientation(point4, point3, point1);
        int o4 = checkOrientation(point4, point3, point1);

        if(o1 != o2 && o3 != o4){
            return true;
        }

        if(o1 == 0 && onSegment(point1, point4, point2))
            return true;

        if(o2 == 0 && onSegment(point1, point3, point2))
            return true;

        if(o3 == 0 && onSegment(point4, point1, point3))
            return true;

        if(o4 == 0 && onSegment(point4, point2, point3))
            return true;

        return false;
    }

    public boolean onSegment(Point point1, Point point2, Point point3){
        if(point2.getxCoordinate() <= Math.max(point1.getxCoordinate(), point3.getxCoordinate()) &&
                point2.getxCoordinate() >= Math.min(point1.getxCoordinate(), point3.getxCoordinate()) &&
                point2.getyCoordinate() >= Math.min(point1.getyCoordinate(), point3.getyCoordinate())
                )
            return true;

        return false;
    }

    //return -1 if counterclockwise
    //return 0 if collinear
    //return 1 if clockwise
    public int checkOrientation(Point point1, Point point2, Point point3){
        int difference;
        difference = (point2.getyCoordinate() - point1.getyCoordinate()) * (point3.getxCoordinate() - point2.getxCoordinate()) - (point3.getyCoordinate() - point2.getyCoordinate()) * (point2.getxCoordinate() - point1.getxCoordinate());
        if (difference == 0){
            return 0;
        }

        return (difference > 0) ? 1: -1;
    }
}
