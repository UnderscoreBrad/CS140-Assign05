package assignment05;

import java.util.*;

public class PointSeries {

    private List<Point> points;

    public PointSeries(){
        points = new ArrayList<>();
        //I felt like it, okay?
    }

    public void addPoint(Point point){
        points.add(point);
    }

    public Point findCenter(){
        if(points == null||points.size()==0){
            return new Point (0,0);
        }
        double avgx=0, avgy=0;
        int t=0;
        for(int i = 0; i < points.size(); i++){
            if(points.get(i)!=null){
                t++;
                avgx+=points.get(i).getX();
                avgy+=points.get(i).getY();
            }
        }
        avgx/=t;
        avgy/=t;
        return new Point(avgx,avgy);
    }

    public void translate (int horz, int vert){
        for(int i = 0; i < points.size(); i++){
            if(points.get(i)!=null){
                points.set(i, new Point(points.get(i).getX()+horz,points.get(i).getY()+vert));
            }
        }
    }
    @Override
    public String toString(){
        return "" + points;
    }
}
