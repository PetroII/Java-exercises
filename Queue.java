import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Queue {
    public static int solveSuperMarketQueue(int[] customers, int n) {
        if(customers.length == 0){
            return 0;
        }else{
            int result = 0;
            if(n == 1){
                for(int i : customers){
                    result += i;
                }
                return result;
            }else {
                int min_val;
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    if(i < customers.length) {
                        list.add(customers[i]);
                    }else{
                        break;
                    }
                }
                for (int i = n; i < customers.length; i++) {
                    min_val = Collections.min(list);
                    result += min_val;
                    for (int j = 0; j < list.size(); j++) {
                        if (list.get(j) == min_val) {
                            list.set(j, 0);
                        } else {
                            list.set(j, list.get(j) - min_val);
                        }
                    }
                    for (int j = 0; j < list.size(); j++) {
                        if (i != customers.length) {
                            if(list.get(j) == 0){
                                list.set(j, customers[i]);
                                i++;
                            }
                        } else {
                            break;
                        }
                    }
                    i--;
                }
                return result + Collections.max(list);
            }
        }
    }
}
