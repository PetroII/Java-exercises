public class MinMax {
    public static int[] minMax(int[] arr) {
        int min = arr[0];
        int max = arr[0];

        for (int value : arr) {
            if (value > max) {
                max = value;
            } else if (value < min) {
                min = value;
            }
        }
        return new int[]{min,max};
    }
}
