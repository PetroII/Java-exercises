public class TwoToOne {
    public static String longest (String s1, String s2) {
        String s3;
        if(s1.equals(s2)){
            s3 = s1;
        }else{
            s3 = s1 + s2;
        }

        StringBuilder output = new StringBuilder();

        for(int i = 0; i < s3.length(); i++) {
            if(!output.toString().contains(Character.toString(s3.charAt(i)))) {
                output.append(s3.charAt(i));
            }
        }

        char temp;
        for(int i = 0; i < output.length(); i++){
            for(int j = i + 1; j < output.length(); j++){
                if(output.charAt(i) > output.charAt(j)){
                    temp = output.charAt(i);
                    output.setCharAt(i, output.charAt(j));
                    output.setCharAt(j, temp);
                }
            }
        }

        return output.toString();
    }
}
