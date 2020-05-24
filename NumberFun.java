public class NumberFun {
    public static long findNextSquare(long sq) {
        if(Math.sqrt(sq)==(long)Math.sqrt(sq)){
            return (long) Math.pow(Math.sqrt(sq)+1,2);
        }else{
            return -1;
        }
    }
}
