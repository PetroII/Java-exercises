public class Order {
    public static String order(String words) {
        if(words == null || words.isEmpty()){
            return "";
        }else{
            int counter = 0;
            for(int i = 0; i < words.length(); i++){
                if(Character.isDigit(words.charAt(i))){
                    counter++;
                }
            }

            StringBuilder output = new StringBuilder();
            for(int i = 1; i <= counter; i++){
                for(int j = 0; j < words.length(); j++){
                    if(words.charAt(j)==Character.forDigit(i,10)){
                        int temp = j;
                        while(words.charAt(j)!=' ' && j != words.length() - 1){
                            j++;
                        }

                        int last;
                        if(words.charAt(j)==' ') {
                            last = j - 1;
                        }else{
                            last = j;
                        }

                        j = temp;
                        while(words.charAt(j)!=' ' && j != 0){
                            j--;
                        }

                        int first;
                        if(words.charAt(j)==' ') {
                            first = j + 1;
                        }else{
                            first = j;
                        }

                        for(int k = first; k <= last; k++){
                            output.append(words.charAt(k));
                        }

                        if(i != counter) {
                            output.append(" ");
                        }
                        break;
                    }
                }
            }

            return output.toString();

        }
    }
}
