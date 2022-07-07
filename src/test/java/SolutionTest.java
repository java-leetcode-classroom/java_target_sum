import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
  final private Solution sol = new Solution();
  @Test
  void findTargetSumWaysExample1() {
    assertEquals(5, sol.findTargetSumWays(new int[]{1,1,1,1,1}, 3));
  }
  @Test
  void findTargetSumWaysExample2() {
    assertEquals(1, sol.findTargetSumWays(new int[]{1}, 1));
  }
  @Test
  void findTargetSumWaysExample3() {
    assertEquals(0, sol.findTargetSumWays(new int[]{2}, 1));
  }

  @Test
  void findTargetSumWaysV1Example1() {
    assertEquals(5, sol.findTargetSumWaysV1(new int[]{1,1,1,1,1}, 3));
  }
  @Test
  void findTargetSumWaysV1Example2() {
    assertEquals(1, sol.findTargetSumWaysV1(new int[]{1}, 1));
  }
  @Test
  void findTargetSumWaysV1Example3() {
    assertEquals(0, sol.findTargetSumWaysV1(new int[]{2}, 1));
  }

  @Test
  void findTargetSumWaysDFSExample1() {
    assertEquals(5, sol.findTargetSumWaysDFS(new int[]{1,1,1,1,1}, 3));
  }
  @Test
  void findTargetSumWaysDFSExample2() {
    assertEquals(1, sol.findTargetSumWaysV1(new int[]{1}, 1));
  }
  @Test
  void findTargetSumWaysDFSExample3() {
    assertEquals(0, sol.findTargetSumWaysV1(new int[]{2}, 1));
  }
}