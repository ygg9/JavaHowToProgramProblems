package Week2.Chapter9;

public class Point {
    private int xCoordinate;
    private int yCoordinate;

    Point() {
        xCoordinate = 0;
        yCoordinate = 0;
    }

    Point(int x, int y) {
        xCoordinate = x;
        yCoordinate = y;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }
}
