import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class Solution {
  static class NumRecord {
    private final int total;
    private final int end;

    public NumRecord(int total, int end) {
      this.total = total;
      this.end = end;
    }

    @Override
    public boolean equals(Object o) {
      if (!(o instanceof NumRecord)) return false;
      NumRecord numRecord = (NumRecord) o;
      return total == numRecord.total && end == numRecord.end;
    }

    @Override
    public int hashCode() {
      return Objects.hash(total, end);
    }
  }
  public int findTargetSumWays(int[] nums, int target) {
    int sum = Arrays.stream(nums).sum();
    int nLen = nums.length;
    if (Math.abs(target) > sum) {
      return 0;
    }
    int[][] dp = new int[nLen][2*sum+1];
    // dp[end][sum+target]
    dp[0][sum+nums[0]] = 1;
    dp[0][sum-nums[0]] += 1;
    for (int end = 1; end < nLen; end++) {
      for (int total = -sum; total <= sum; total++) {
        if (dp[end-1][total+sum] > 0) {
          dp[end][total + nums[end] + sum] += dp[end-1][total+sum];
          dp[end][total - nums[end] + sum] += dp[end-1][total+sum];
        }
      }
    }
    return dp[nLen-1][sum+target];
  }
  public int findTargetSumWaysV1(int[] nums, int target) {
    int sum = Arrays.stream(nums).sum();
    int nLen = nums.length;
    if (Math.abs(target) > sum) {
      return 0;
    }
    int[] dp = new int[2*sum+1];
    dp[sum+nums[0]] = 1;
    dp[sum-nums[0]] += 1;
    for (int end = 1; end < nLen; end++) {
      int[] nextDp = new int[2*sum+1];
      for (int total = -sum; total <= sum; total++) {
        if (dp[total+sum] > 0) {
          nextDp[total + nums[end] + sum] += dp[total+sum];
          nextDp[total - nums[end] + sum] += dp[total+sum];
        }
      }
      dp = nextDp;
    }
    return dp[sum+ target];
  }
  public int findTargetSumWaysDFS(int[]nums, int target) {
    int sum = Arrays.stream(nums).sum();
    if (Math.abs(target) > sum) {
      return 0;
    }
    HashMap<NumRecord, Integer> cache = new HashMap<>();

    return DFS(cache, nums, 0, 0, target);
  }
  public int DFS(HashMap<NumRecord, Integer> cache, int[] nums, int end, int total, int target) {
    if (end == nums.length) {
      return (total == target)? 1: 0;
    }
    NumRecord record = new NumRecord(total, end);
    if (cache.containsKey(record)) {
      return cache.get(record);
    }
    int choosePlus = DFS(cache, nums, end+1, total + nums[end], target);
    int chooseMinus = DFS(cache, nums, end+1, total- nums[end], target);
    cache.put(record, chooseMinus+ choosePlus);
    return chooseMinus+choosePlus;
  }
}
