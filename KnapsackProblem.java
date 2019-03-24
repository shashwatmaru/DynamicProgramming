import java.util.*;

/* A Naive recursive implementation of 0-1 Knapsack problem */
class KnapsackProblem
{

    /**
     * Key for memoization
     */
    static class Index {
        int remainingWeight;
        int remainingItems;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Index index = (Index) o;

            if (remainingWeight != index.remainingWeight) return false;
            return remainingItems == index.remainingItems;

        }

        @Override
        public int hashCode() {
            int result = remainingWeight;
            result = 31 * result + remainingItems;
            return result;
        }
    }

    /**
     * Solves 0/1 knapsack in top down DP
     */
    public static int topDownRecursive(ArrayList<Integer>weights, int maxCapacity) {
        //map of key(remainingWeight, remainingCount) to maximumValue they can get.
        Map<Index, Integer> map = new HashMap<>();
        return topDownRecursiveUtil(weights, maxCapacity, weights.size(), 0, map);
    }

    public static int topDownRecursiveUtil(ArrayList<Integer>weights, int remainingWeight, int totalItems, int currentItem, Map<Index, Integer> map) {
        //if currentItem exceeds total item count or remainingWeight is less than 0 then
        //just return with 0;
        if(currentItem >= totalItems || remainingWeight <= 0) {
            return 0;
        }

        //fom a key based on remainingWeight and remainingCount
        Index key = new Index();
        key.remainingItems = totalItems - currentItem -1;
        key.remainingWeight = remainingWeight;

        //see if key exists in map. If so then return the maximumValue for key stored in map.
        if(map.containsKey(key)) {
            return map.get(key);
        }
        int maxValue;
        //if weight of item is more than remainingWeight then try next item by skipping current item
        if(remainingWeight < weights.get(currentItem)) {
            maxValue = topDownRecursiveUtil(weights, remainingWeight, totalItems, currentItem + 1, map);
        } else {
            //try to get maximumValue of either by picking the currentItem or not picking currentItem
            maxValue = Math.max(weights.get(currentItem) + topDownRecursiveUtil(weights, remainingWeight - weights.get(currentItem), totalItems, currentItem + 1, map),
                    topDownRecursiveUtil(weights, remainingWeight, totalItems, currentItem + 1, map));
        }
        //memoize the key with maxValue found to avoid recalculation
        map.put(key, maxValue);
        return maxValue;

    }

    // Driver program to test above function
    public static void main(String args[])
    {
        ArrayList<Integer> weights = new ArrayList<Integer>();
        weights.add(3);
        weights.add(1);
        weights.add(3);
        weights.add(5);
        int  W = 7;
       // System.out.println(knapSack(weights,W));
        int r1 = topDownRecursive(weights,W);
        System.out.println(r1);
        }
}