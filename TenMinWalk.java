public class TenMinWalk {
    public static boolean isValid(char[] walk) {
        if(walk.length != 10){
            return false;
        }else {
            int n_num = 0;
            int s_num = 0;
            int w_num = 0;
            int e_num = 0;

            for (char c : walk) {
                switch (c) {
                    case 'n':
                        n_num++;
                        break;
                    case 's':
                        s_num++;
                        break;
                    case 'w':
                        w_num++;
                        break;
                    case 'e':
                        e_num++;
                        break;
                }
            }

            return n_num == s_num && w_num == e_num;
        }
    }
}
