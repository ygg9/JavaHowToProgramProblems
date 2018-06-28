package Week2.Chapter9;

public class ShapeTest {
    public static void main(String[] args){
        // must enter points clockwise
        Point point1 = new Point(0, 0);
        Point point2 = new Point(20, 19);
        Point point3 = new Point(11, 20);
        Point point4 = new Point(5, 0);


        Quadrilateral test = new Quadrilateral(point1, point2, point3, point4);

        System.out.println(test.checkQuadrilateral());
        System.out.println(test.getArea());

        Point point5 = new Point(0, 0);
        Point point6 = new Point(20, 19);
        Point point7 = new Point(1, 1);
        Point point8 = new Point(1, 0);

        Trapezoid test2 = new Trapezoid(point5, point6, point7, point8);

        System.out.println(test2.checkTrapezoid());
        System.out.println(test2.getArea());


        Point point9 = new Point(0, 0);
        Point point10 = new Point(0, 1);
        Point point11 = new Point(20, 1);
        Point point12 = new Point(1, 0);

        RectangleInheritance test3 = new RectangleInheritance(point9, point10, point11, point12);

        System.out.println(test3.checkRectangle());
        System.out.println(test3.getArea());


        Point point13 = new Point(0, 0);
        Point point14 = new Point(0, 1);
        Point point15 = new Point(1, 1);
        Point point16 = new Point(10, 10);

        Square test4 = new Square(point13, point14, point15, point16);

        System.out.println(test4.checkSquare());
        System.out.println(test4.getArea());
    }
}
