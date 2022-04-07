package program.java.long_increasing_subsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class LongIncreasingSubsequence {

    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[99];
        
        for (int i = 0; i < arr.length; i++)
            arr[i] = random.nextInt();

        System.out.println("From the array: " + Arrays.toString(arr));
        System.out.println("\nLength of the longest increasing subsequence: " + findMaxIncreasingSubsequence(arr));
    }

    private static int findMaxIncreasingSubsequence(int[] arr) {
        
        if (arr == null || arr.length == 0)
            return 0;
  
        if (arr.length == 1) {
            System.out.println("There is only one value in the list!: " + arr[0]);
            return 1;
        }

        int currentLen, largestLen;
        currentLen = largestLen = 1;
        Set<Integer> currentLongestSubsequenceFound = new LinkedHashSet<>();
        List<List<Integer>> totalSubsequencesFoundList = new ArrayList<>();
        
        for (int lastValue = 0, i = 0; i < arr.length; lastValue = arr[i], i++) {

            if (i == 0)
                continue;

           
            if (arr[i] > lastValue) {
                currentLen += 1;
                
                largestLen = Math.max(largestLen, currentLen);

                currentLongestSubsequenceFound.add(arr[i - 1]);
                currentLongestSubsequenceFound.add(arr[i]);

            } else {
                
                totalSubsequencesFoundList.add(new ArrayList<>(currentLongestSubsequenceFound));
                currentLongestSubsequenceFound.clear();
                currentLen = 1;
            }
            if (i == arr.length - 1)
                totalSubsequencesFoundList.add(new ArrayList<>(currentLongestSubsequenceFound));

        }
        List<Integer> longestSubsequence = totalSubsequencesFoundList.stream()
                .max(Comparator.comparing(List::size))
                .get();

        if (longestSubsequence.isEmpty())
            System.out.println("No sequence of increasing numbers found!");
        else
            System.out.println("The longest increasing subsequence (first of it's length): " + longestSubsequence);

        return largestLen;
    }
}


