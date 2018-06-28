package Week2.Chapter8;

public class Rectangle{
    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void setWidth(double width) throws OutOfRange {
        if(width > 0.0 && width < 20.0){
            this.width = width;
        }
        else{
            throw new OutOfRange("Width out of range. Must be between 0-20");
        }
    }

    public void setHeight(double height) throws OutOfRange {
        if(height > 0.0 && height < 20.0){
            this.height = height;
        }
        else{
            throw new OutOfRange("Height out of range. Must be between 0-20");
        }
    }

    double width, height;
    Rectangle(){
        width = 1;
        height = 1;
    }

}