class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        	int d1 = Math.max(x1, Math.min(xCenter, x2));
		int d2 = Math.max(y1, Math.min(yCenter, y2));
		int dx = d1 - xCenter;
		int dy = d2 - yCenter;
		return (dx * dx + dy * dy) <= (radius * radius);
    }
}