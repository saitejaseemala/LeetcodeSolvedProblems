class Solution {
    public String convertToTitle(int columnNumber) {
	StringBuilder title = new StringBuilder();
	while (columnNumber != 0) {
		title.appendCodePoint('A' + --columnNumber % 26);
		/* the above step can be functionally broken down into 2 steps:
		    title.appendCodePoint('A' + (columnNumber - 1) % 26);
		    columnNumber--;
		*/ 
		columnNumber /= 26;
	}
	return title.reverse().toString();
}
}