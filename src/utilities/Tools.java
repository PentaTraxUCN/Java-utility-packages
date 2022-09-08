package utilities;

public final class Tools {
    // clamp limits the value to lay between the chosen max and min value
    public static long clamp (long value, long min, long max){
        return Math.max(Math.min(max, value), min);
    }
    public static double clamp (double value, double min, double max){
        return Math.max(Math.min(max, value), min);
    }

    // map changes the ratio of the given value to match somewhere inbetween the new limits
    public static long map(long value, long oldMin, long oldMax, long newMin, long newMax){
        return (value - oldMin) * (newMax - newMin) / (oldMax - oldMin) + newMin;
    }
    public static double map(double value, double oldMin, double oldMax, double newMin, double newMax){
        return (value - oldMin) * (newMax - newMin) / (oldMax - oldMin) + newMin;
    }
}
