class Solution {
    public int elevatorRequests(int n, int[] requests) {
        int totalTime = 0, currentFloor = 0;
		for (int i = 0; i < requests.length; i++) {
			// get target
			int target = requests[i];
			// get diff btw current and target floor and add it to total time
			totalTime += Math.abs(currentFloor - target);
			// assign target to current floor for next iteration
			currentFloor = target;
		}
		return totalTime;

    }
}