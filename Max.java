public class Max {
    public static int sequence(int[] arr) {
        int biggest = 0;
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = i; j < arr.length; j++){
                sum += arr[j];
                if(sum > biggest){
                    biggest = sum;
                }
            }
            sum = 0;
        }
        return biggest;
    }
}
