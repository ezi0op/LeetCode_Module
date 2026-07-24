class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;// total gas - total cost

		int tank = 0;// current tank gas
		// starting point of the gas station
		int start = 0;

		// loop through the gas stations and check if we can complete the circuit or not

		for (int i = 0; i < gas.length; i++) {
			// first we are calculating the difference between gas and cost at each gas
			// station and adding it to the total and tank
			int diff = gas[i] - cost[i];
			// adding the difference to the total and tank
			total += diff;
			tank += diff;
			// if the tank is less than 0 then we cannot complete the circuit from the
			// current starting point
			if (tank < 0) {
				// so we need to change the starting point to the next gas station and reset the
				// tank to 0
				start = i + 1;
				tank = 0;
			}
		}

		return total >= 0 ? start : -1;

    }
}