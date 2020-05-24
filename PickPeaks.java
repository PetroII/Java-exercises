import java.util.*;

public class PickPeaks {
    public static Map<String, List<Integer>> getPeaks(int[] arr) {
        Map<String,List<Integer>> result = new HashMap<>();
        List<Integer> pos = new ArrayList<>();
        List<Integer> peaks = new ArrayList<>();
        if(arr.length >= 3) {
            for (int i = 1; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1] && arr[i] > arr[i - 1]) {
                    pos.add(i);
                    peaks.add(arr[i]);
                }else if(arr[i] == arr[i+1] && arr[i] > arr[i-1] && i+2 < arr.length){
                    for(int j = i + 2; j < arr.length; j++){
                        if(arr[i] > arr[j]){
                            pos.add(i);
                            peaks.add(arr[i]);
                            break;
                        }else if(arr[i] < arr[j]){
                            break;
                        }
                    }
                }
            }
        }
        result.put("pos",pos);
        result.put("peaks",peaks);
        return result;
    }
}
