public class Fracts {
    public static String convertFrac(long[][] lst) {
        String result = "";
        if(lst.length == 0){
            return result;
        }else if(lst.length == 1){
            result = "(" + lst[0][0] + "," + lst[0][1] + ")";
            return result;
        }else {
            for (int i = 0; i < lst.length; i++) {
                int max = 1;
                for (int j = 2; j <= Math.min(lst[i][0], lst[i][1]); j++) {
                    if (lst[i][0] % j == 0 && lst[i][1] % j == 0) {
                        max = j;
                    }
                }
                lst[i][0] /= max;
                lst[i][1] /= max;
            }
            long common = lst[0][1];
            for(int i = 1; i < lst.length; i++){
                common = lcm(common, lst[i][1]);
            }
            for (int i = 0; i < lst.length; i++) {
                result += "(" + common / lst[i][1] * lst[i][0] + "," + common + ")";
            }
            return result;
        }
    }
    private static long gcd(long a, long b){
        while (b > 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    private static long lcm(long a, long b){
        return a * (b / gcd(a, b));
    }
}
