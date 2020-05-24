public class PerfectPower {
    public static int[] isPerfectPower(int n) {
        int number;
        double power;
        int[] result = new int[2];
        for(int i = 2; i <= Math.sqrt(n); i++){
            number = 1;
            power = 1;
            while(power < n){
                number++;
                power = Math.pow(i,number);
            }
            if(power == n){
                result[0] = i;
                result[1] = number;
                break;
            }
        }
        if(result[0] > 0){
            return result;
        }else{
            return null;
        }
    }
}
