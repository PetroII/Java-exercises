public class BouncingBall {
    public static int bouncingBall(double h, double bounce, double window) {
        if(h <= 0 || bounce <= 0 || bounce >= 1 || window >= h){
            return -1;
        }else{
            int result = 0;
            double ball_height = h;
            while(ball_height > window){
                result += 1;
                ball_height *= bounce;
                if(ball_height > window){
                    result += 1;
                }
            }
            return result;
        }
    }

}
