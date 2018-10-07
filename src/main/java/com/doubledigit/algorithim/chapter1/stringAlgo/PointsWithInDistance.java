package com.doubledigit.algorithim.chapter1.stringAlgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Vivek Kumar Mishra on 29/09/2018.
 */
public class PointsWithInDistance {


    public static void main(String[] args) {
        List<Point> points =
                Arrays.asList(new Point(4, 6), new Point(1, 6), new Point(3, 4),
                        new Point(2, 9), new Point(5, 9), new Point(4, 9));

        List<Point> allPointWithinDistance = getAllPointWithinDistance(points, new Point(4, 7), 3);

    }


    public static List<Point> getAllPointWithinDistance(List<Point> list, Point point, double distance){
        List<Point> withinDistance = new ArrayList<>();
        list.parallelStream().forEach(p ->{
            if(p.isWithinDistance(point, distance)){
                withinDistance.add(p);
            }
        });

        System.out.println(String.format("Points within %s of point x = %s, y = %s",
                distance, point.getX(), point.getY()));

        withinDistance.parallelStream().forEach(p -> {
            System.out.println(String.format("Points: x = %s, y = %s" , p.getX(), p.getY()));
        });
        return withinDistance;
    }



    public static class Point{
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        //Helper method to calculate the distance from another point....
        public double getDistance(Point otherPoint){
            return Math.sqrt(Math.pow(otherPoint.x -x, 2) + Math.pow(otherPoint.y - y, 2));
        }

        public boolean isWithinDistance(Point otherPoint, double distance){
            if(Math.abs(otherPoint.x -x) > distance  || Math.abs(otherPoint.y - y) > distance){
                return false;
            }
            return getDistance(otherPoint) <= distance;
        }




    }
}
