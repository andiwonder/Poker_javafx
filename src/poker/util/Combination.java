package poker.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination {

    /**
     * if n = 7 , and k = 3 then u go from [0,1,2] , [0,1,3] ... [0,5,6]
     * since 6 cannot be incremented further, go to [1,2,3] , [1,2,4]
     * then increment 1 to 2 and so on.
     */

    public static List<int []> combinations;

    static {
        // input array
        int[] input = {0,1,2,3,4,5,6};
        // sequence length
        int k = 5;

        List<int[]> subsets = new ArrayList<>();

        // here we'll keep indices
        int[] s = new int[k];

        // pointing to elements in input array
        if (k <= input.length) {
            // first index sequence: 0, 1, 2, ...
            for (int i = 0; (s[i] = i) < k - 1; i++);
            subsets.add(getSubset(input, s));
            // same as while(true)
            for(;;) {
                int i;
                // find position of item that can be incremented
                for (i = k - 1; i >= 0 && s[i] == input.length - k + i; i--);
                if (i < 0) {
                    break;
                }
                // increment this item
                s[i]++;
                // fill up remaining items
                for (++i; i < k; i++) {
                    s[i] = s[i - 1] + 1;
                }
                subsets.add(getSubset(input, s));
            }
        }
        combinations = subsets;
    }

    public static List<int []> getCombinations(){
        return combinations;
    }


    private static int[] getSubset(int[] input, int[] subset) {
        int[] result = new int[subset.length];
        for (int i = 0; i < subset.length; i++){
            result[i] = input[subset[i]];
        }
        return result;
    }

}
