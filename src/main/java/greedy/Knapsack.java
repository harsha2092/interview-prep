package greedy;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class Knapsack {

    public class ValuePerUnitWeight {
        public int weight;
        public float valuePerUnitWeight;
    }

    class SortByValuesPerUnitWeight implements Comparator<ValuePerUnitWeight> {
        public int compare(ValuePerUnitWeight v1, ValuePerUnitWeight v2) {
            if(v1.valuePerUnitWeight > v2.valuePerUnitWeight){
                return 1;
            }
            if(v1.valuePerUnitWeight < v2.valuePerUnitWeight){
                return -1;
            }

            return 0;
        }
    }

    public int findMaximumProfit(int[] weights, float[] values, int targetWeight) {
        ValuePerUnitWeight[] valuesPerUnitWeight = new ValuePerUnitWeight[weights.length];
        for(int i=0; i<weights.length; i++){
            ValuePerUnitWeight valuePerUnitWeight = new ValuePerUnitWeight();
            valuePerUnitWeight.valuePerUnitWeight = values[i]/weights[i];
            valuePerUnitWeight.weight = weights[i];
            valuesPerUnitWeight[i] = valuePerUnitWeight;
        }

        Arrays.sort(valuesPerUnitWeight, new SortByValuesPerUnitWeight().reversed());
        System.out.println("valuesPerUnitWeight");
        for (ValuePerUnitWeight valuePerUnitWeight:
             valuesPerUnitWeight) {
            System.out.println(valuePerUnitWeight.weight + " " + valuePerUnitWeight.valuePerUnitWeight);
        }



        int profit = 0;
        for(int i=0; i < valuesPerUnitWeight.length; i++){
            if(targetWeight == 0){
                return profit;
            }

            if(targetWeight - valuesPerUnitWeight[i].weight >= 0) {
                profit += valuesPerUnitWeight[i].weight * valuesPerUnitWeight[i].valuePerUnitWeight;
            } else{
                profit += targetWeight * valuesPerUnitWeight[i].valuePerUnitWeight;
            }

            targetWeight = targetWeight - valuesPerUnitWeight[i].weight;
        }

        return profit;
    }

    public void testFindMaximumProfit(){
        // case 1 when my target is greater than all the weights
        float[] values = new float[]{2, 4, 6};
        int[] weights = new int[]{1, 2, 3};
        int target = 10;

        System.out.println("find maximum profit case 1: " + findMaximumProfit(weights, values, target));

        // case 2 when my target is equal to all the weights
        values = new float[]{2, 4, 6};
        weights = new int[]{1, 6, 3};
        target = 10;

        System.out.println("find maximum profit case 2: " + findMaximumProfit(weights, values, target));

        // case 3 when my target is less than all the weights
        values = new float[]{2, 4, 6};
        weights = new int[]{1, 6, 3};
        target = 3;

        System.out.println("find maximum profit case 3: " + findMaximumProfit(weights, values, target));
    }
}
