public class Diamond {
    public static String print(int n) {
        if(n%2 == 0 || n < 1){
            return null;
        }else {
            StringBuilder result = new StringBuilder();
            int counter = 1;
            for (int i = 1; i <= n; i++) {
                result.append("\n*");
                if (i <= n / 2) {
                    result.append("**".repeat(i - 1));
                } else {
                    result.append("**".repeat(n - i));
                }
                if (i <= n / 2 + 1) {
                    result.append(" ".repeat(n / 2 + 1 - i));
                } else {
                    result.append(" ".repeat(counter));
                    counter++;
                }
            }
            result = result.reverse();

            return result.toString();
        }
    }
}
