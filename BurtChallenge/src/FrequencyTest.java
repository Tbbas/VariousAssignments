import java.util.Arrays;

import static junit.framework.TestCase.assertTrue;

class FrequencyTest {
    @org.junit.jupiter.api.Test
    void frequency() {
        String[] stringList1 = {"b","b","a","b","c","b"}; // Should return {b,c,a}
        String[] stringList1Correct = {"b","c","a"};
        String[] stringTest2 = {"a","a","a","b","b","c","c","b"}; // Should return {a,b,c}
        String[] stringTest2Correct = {"a","b","c"};
        Integer[] integerList = {1,4,4,6,7,7,7,7,8,8,8,1}; // Should return {7,8,4,1,6}
        Integer[] integerListCorrect = {7,8,4,1,6};

        Frequency<String> freqString = new Frequency<String>();
        Frequency<Integer> freqInteger = new Frequency<Integer>();
        assertTrue(Arrays.equals(freqString.frequency(stringList1),stringList1Correct));
        assertTrue(Arrays.equals(freqString.frequency(stringTest2),stringTest2Correct));
        assertTrue(Arrays.equals(freqInteger.frequency(integerList),integerListCorrect));

    }

}