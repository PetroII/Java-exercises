public class Accumul {
    public static String accum(String s) {
        StringBuilder output = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            output.append(Character.toUpperCase(s.charAt(i)));
            for(int j = 0; j < i; j++){
                output.append(Character.toLowerCase(s.charAt(i)));
            }
            if(i != s.length() - 1) {
                output.append("-");
            }
        }
        return output.toString();
    }
}
