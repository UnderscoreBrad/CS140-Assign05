package assignment05;

import java.util.*;
//Tester Copy-Pasted from Piazza

public class Tester2 {

    private static int numWrong;

    public static void main(String[] args) {
        testQ1();
        System.out.println("--------------------");
        testQ2();
        System.out.println("--------------------");
        testQ3();
        System.out.println("--------------------");
        System.out.println(numWrong + " tests failed");
    }

    public static void testQ1() {
        System.out.println("*********TESTING QUESTION 1********\n");
        testEquality("[3, 3, 4, 6, 0]",
                LengthCalculator.stringLengths(new ArrayList<String>(Arrays.asList("car", "dog", "rats", "monkey", ""))));
        testEquality("[3, 4, 5, 2, 8, 6]",
                LengthCalculator.stringLengths(new ArrayList<String>(Arrays.asList("car", "dogs", "apple", "me", null, "migraine", "walnut", null))));
    }

    public static void testQ2() {
        System.out.println("*********TESTING QUESTION 2********\n");
        int[] array = {0,1,2,3,4,5,6,7,8,9,10};
        testEquality(new double[]{4*100.0/11, 4*100.0/11, 3*100.0 / 11},
                Partitioner.moduloPartition(array, 3));
        testEquality(new double[]{6*100.0/11, 5*100.0/11},
                Partitioner.moduloPartition(array, 2));
        try{
            Partitioner.moduloPartition(array, -1);
            ++numWrong;
            System.out.println("FAILED: Did not throw exception for non-positive modulo");
        }
        catch(IllegalArgumentException e){
            System.out.println("Passed: " + e.getMessage());
        }
        catch(Exception e){
            ++numWrong;
            System.out.println("FAILED: non-positive modulo broke moduloPartition");
            System.out.println("ERROR MESSAGE SHOWN BELOW");
            e.printStackTrace(System.out);
        }
    }

    public static void testQ3() {
        System.out.println("*********TESTING QUESTION 3********\n");
        Point origin = new Point(0, 0);
        testEquality("0.0", origin.getX());
        testEquality("0.0", origin.getY());
        testEquality("(0.0, 0.0)", origin.toString());
        PointSeries points = new PointSeries();
        points.addPoint(new Point(2, 4));
        points.addPoint(new Point(3, 3));
        points.addPoint(new Point(4, 8));
        testEquality("[(2.0, 4.0), (3.0, 3.0), (4.0, 8.0)]", points);
        testEquality("(3.0, 5.0)", points.findCenter());
        points.translate(1,3);
        testEquality(new ArrayList<Point>(Arrays.asList(new Point(3,7),
                new Point(4,6), new Point(5,11))), points);

    }

    private static void testEquality(Object expected, Object actual) {
        if (!expected.toString().equals(actual.toString())) {
            ++numWrong;
            System.out.printf("FAILED: Expected '%s', received '%s'\n",
                    expected.toString(),
                    actual.toString());
        } else {
            System.out.printf("Passed: '%s' == '%s'\n",
                    expected.toString(),
                    actual.toString());
        }
    }

    private static void testEquality(double[] expected, double[] actual) {
        testEquality(Arrays.toString(expected), Arrays.toString(actual));
    }
}


