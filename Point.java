package assignment05;

public class Point {

    private double x, y;

    public Point(double x, double y){
        if(x<0||y<0){
            throw new IllegalArgumentException("coordinates must be non-negative");
        }
        this.x = x;
        this.y = y;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    @Override
    public String toString(){
        return "(" + x + ", " + y +")";
    }
}
