
import java.util.*;

public class Frequency<T extends Object> {



    public static void main(String[] args) {
        String[] testList = {"a", "b", "b", "c", "b", "a","a","b"};
        Frequency<String> m = new Frequency<String>();
        Object[] result = m.frequency(testList);

        Arrays.stream(result).forEach(System.out::println);


    }

    /**
     * Take a list of arguments and return a array sorted by the most common argument
     * TODO:Make Generic
     * @param args
     */
    Object[] frequency(T[] args)  {
        HashMap<T,Integer> frequencyMap = new HashMap<>();
        PriorityQueue<SearchNode<T>> pq = new PriorityQueue<>();

        // Put all entities in a HashTable to count frequency. A hash table is used because of the O(1)
        // complexity for the insertion and lookup(without too many collisions)
        for(int i = 0; i<args.length; i++) {
            if(!frequencyMap.containsKey(args[i])) {
                frequencyMap.put(args[i],1);
            } else {
                frequencyMap.put(args[i],frequencyMap.get(args[i])+1);
            }
        }

        // Iterate through each entry, create corresponding SearchNode and add to priorityqueue.
        for(Map.Entry<T,Integer> keyValuePair : frequencyMap.entrySet()) {
            pq.add(new SearchNode(keyValuePair.getKey(),keyValuePair.getValue()));
        }
        ArrayList<T> result = new ArrayList<>();

        // add the elements into a arraylist, convert to array and return.
        while (!pq.isEmpty()) {
            result.add(pq.poll().value);
        }
        return result.toArray();

    }


    class SearchNode<T> implements Comparable {
        T value;
        Integer frequency;

        public SearchNode(T value, Integer frequency) {
            this.value = value;
            this.frequency = frequency;
        }

        @Override
        public int compareTo(Object o) {
            if (((SearchNode) o).frequency > this.frequency) {
                return 1;
            } else if (((SearchNode) o).frequency < this.frequency) {
                return -1;
            } else {
                return 0;
            }
        }
    }


}
