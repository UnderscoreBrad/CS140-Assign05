package assignment05;

import org.junit.*;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Assignment05Tests {

    @Test
    public void testRemoveNulls_1() throws Exception {
        List<String> strs = new ArrayList<>(Arrays.asList("a", null, "b", null, "c"));
        LengthCalculator.removeNulls(strs);
        Assert.assertEquals(new ArrayList<>(Arrays.asList("a", "b", "c")), strs);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNulls_2() throws Exception {
        LengthCalculator.removeNulls(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStringLengths_1() throws Exception {
        List<String> strs = new ArrayList<>(Arrays.asList(null, null));
        LengthCalculator.stringLengths(strs);
    }

    @Test
    public void testStringLengths_2() throws Exception {
        List<String> strs = new ArrayList<>(Arrays.asList("a", null, "ab", null, "abc"));
        List<Integer> lengths = LengthCalculator.stringLengths(strs);
        Assert.assertEquals(new ArrayList<>(Arrays.asList(1,2,3)), lengths);
        for(String str : strs) {
            if(str == null) {
                Assert.assertTrue(false);
            }
        }
    }

    @Test
    public void testModuloPartition_1() throws Exception {
        int[] nums = new int[] {1,5,4,6,2,7,8,19};
        double[] partitionProps = Partitioner.moduloPartition(nums, 3);

        Assert.assertTrue(Arrays.equals(new double[] {12.5, 50.0, 37.5}, partitionProps));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testModuloPartition_2() throws Exception {
        Partitioner.moduloPartition(null, 3);
    }

    @Test
    public void testFindCenter_1() throws Exception {
        PointSeries series = new PointSeries();

        series.addPoint(new Point(0, 0));
        series.addPoint(new Point(0, 2));
        series.addPoint(new Point(2, 0));
        series.addPoint(new Point(2, 2));

        Point center = series.findCenter();

        Assert.assertEquals(1., center.getX(), 0.0000001);
        Assert.assertEquals(1., center.getY(), 0.0000001);
    }

    @Test
    public void testFindCenter_2() throws Exception {
        PointSeries series = new PointSeries();

        series.addPoint(new Point(0, 0));
        series.addPoint(null);
        series.addPoint(new Point(0, 2));
        series.addPoint(null);

        Point center = series.findCenter();

        Assert.assertEquals(0., center.getX(), 0.0000001);
        Assert.assertEquals(1., center.getY(), 0.0000001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTranslate_1() throws Exception {
        PointSeries series = new PointSeries();
        series.addPoint(new Point(0, 0));
        series.translate(-1, 0);
    }

    @Test
    public void testTranslate_2() throws Exception {
        PointSeries series = new PointSeries();

        series.addPoint(new Point(0, 0));
        series.addPoint(null);
        series.addPoint(new Point(0, 2));
        series.addPoint(null);

        series.translate(1, 1);

        Point center = series.findCenter();

        Assert.assertEquals(1., center.getX(), 0.0000001);
        Assert.assertEquals(2., center.getY(), 0.0000001);
    }
}
