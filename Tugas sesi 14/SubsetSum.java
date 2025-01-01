import java.util.ArrayList;
import java.util.List;

public class SubsetSum {

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8};
        int target = 10;
        List<List<Integer>> result = findSubsets(arr, target);

        System.out.println("Subset yang jumlahnya sama dengan target " + target + ": " + result);
    }

    public static List<List<Integer>> findSubsets(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(arr, target, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] arr, int target, int start, List<Integer> currentSubset, List<List<Integer>> result) {
        int currentSum = currentSubset.stream().mapToInt(Integer::intValue).sum();

        if (currentSum == target) {
            result.add(new ArrayList<>(currentSubset));
        }

        if (currentSum >= target) {
            return;
        }

        for (int i = start; i < arr.length; i++) {
            currentSubset.add(arr[i]);
            backtrack(arr, target, i + 1, currentSubset, result);
            currentSubset.remove(currentSubset.size() - 1);
        }
    }
}