// Problem: Insert Delete GetRandom O(1)
// Link: https://leetcode.com/problems/insert-delete-getrandom-o1/description/?envType=study-plan-v2&envId=top-interview-150

class RandomizedSet {

    private List<Integer> list;
    private Map<Integer, Integer> indexMap;
    private Random rand;

    public RandomizedSet() {
        list = new ArrayList<>();
        indexMap = new HashMap<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if (indexMap.containsKey(val)) {
            return false;
        }
        indexMap.put(val, list.size());
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if (!indexMap.containsKey(val)) {
            return false;
        }

        int idx = indexMap.get(val);
        int lastVal = list.get(list.size() - 1);

        // Move last element into idx position (if not already there)
        list.set(idx, lastVal);
        indexMap.put(lastVal, idx);

        // Remove last element
        list.remove(list.size() - 1);
        indexMap.remove(val);

        return true;
    }
    
    public int getRandom() {
        int idx = rand.nextInt(list.size());
        return list.get(idx);
    }
}