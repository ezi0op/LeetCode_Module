class Solution {
    public boolean canAliceWin(int n) {
        int remove = 10;
		boolean aliceTurn = true;
		while (n >= remove) {
			// first remove from n stones
			n -= remove;
			// decrement the number of stones that can be removed in the next turn
			remove--;
			// switch turns between Alice and Bob
			aliceTurn = !aliceTurn;
		}
		return !aliceTurn;
    }
}