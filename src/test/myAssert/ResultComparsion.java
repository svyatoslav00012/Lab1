package test.myAssert;

public class ResultComparsion {

    public static final double EPSILON = 1e-12;

    public static boolean double2DArrayEquals(double[][] arr1, double[][] arr2) {
        if (arr1.length != arr2.length)
            return false;
        for (int i = 0; i < arr1.length; ++i)
            if (!doubleArrayEquals(arr1[i], arr2[i]))
                return false;
        return true;
    }

    public static boolean doubleArrayEquals(double[] arr1, double[] arr2) {
        if (arr1.length != arr2.length)
            return false;
        for (int i = 0; i < arr1.length; ++i)
            if (!doubleEquals(arr1[i], arr2[i]))
                return false;
        return true;
    }

    public static boolean doubleEquals(double d1, double d2) {
        return doubleEquals(d1, d2, EPSILON);
    }

    public static boolean doubleEquals(double d1, double d2, double EPS) {
        return Math.abs(d1 - d2) < EPS;
    }
}
