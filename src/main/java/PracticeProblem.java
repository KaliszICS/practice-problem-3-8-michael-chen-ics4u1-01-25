import java.util.HashMap;

public class PracticeProblem {

	public static void main(String args[]) {
		System.out.println(minCostClimbingStairs(new int[]{10, 15, 4000, 30}));
	}

	public static int fib(int num) {
		int[] nums = new int[num + 1];
		return fibHelper(num, nums);
	}

	public static int fibHelper(int num, int[] nums) {
		if (num == 0) {
			nums[num] = 0;
			return 0;
		}

		if (num == 1) {
			nums[num] = 1;
			return 1;
		}

		if (nums[num - 1] != 0) {
			return nums[num - 1];
		} 

		nums[num - 1] = fibHelper(num - 1, nums) + fibHelper(num - 2, nums);
		return nums[num - 1];
	}

	public static int minCostClimbingStairs(int[] cost) {
		if (cost.length == 1) {
			return cost[0];
		}

		if (cost.length == 0) {
			return 0;
		}
		
		HashMap<Integer, Integer> stepsCost = new HashMap<Integer, Integer>();

		return stairHelper(cost, stepsCost, cost.length);
	}

	public static int stairHelper(int[] cost, HashMap<Integer, Integer> stepsCost, int steps) {
		if (stepsCost.containsKey(steps)) {
			return stepsCost.get(steps);
		}

		if (steps == 0) {
			stepsCost.put(steps, cost[0]);
			return cost[0];
		}

		if (steps == 1) {
			stepsCost.put(steps, cost[1]);
			return cost[1];
		}

		int twoSteps = stairHelper(cost, stepsCost, steps - 2);
		int oneStep = stairHelper(cost, stepsCost, steps - 1);
		if (steps < cost.length) {
			stepsCost.put(steps, cost[steps] + Math.min(oneStep, twoSteps));
			return stepsCost.get(steps);
		}
		stepsCost.put(steps, Math.min(oneStep, twoSteps));
		System.out.println(stepsCost);
		return stepsCost.get(steps);
	}
}
