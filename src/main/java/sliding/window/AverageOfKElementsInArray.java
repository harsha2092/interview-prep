package sliding.window;

import java.util.ArrayList;
import java.util.List;

public class AverageOfKElementsInArray {
    public int[] findAverageOfKElementsInArray(int[] numbers, int k) {
        List<Integer> averages = new ArrayList<Integer>();

        int start=0;
        int end=0;
        int sum=0;
        while(end < numbers.length){
            sum = sum + numbers[end];
            if(start - end == k){
                averages.add(sum/k);
            } else if(start - end == k+1){
                sum = sum - start;
                int average = sum/k;
            }
            end++;
        }

        return averages.stream().mapToInt(Integer::intValue).toArray();
    }
}
