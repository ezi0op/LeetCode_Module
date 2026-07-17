class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
	  return helper(ransomNote, magazine);
    }

    private boolean helper(String ransom, String magazine) {

        if (ransom.isEmpty()) {
            return true;
        }

        char ch = ransom.charAt(0);
        int index = magazine.indexOf(ch);

        if (index == -1) {
            return false;
        }

        String newMagazine =
                magazine.substring(0, index) +
                magazine.substring(index + 1);

        return helper(ransom.substring(1), newMagazine);
    }
}