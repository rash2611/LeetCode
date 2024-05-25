class Solution {
    public void findCombinations(int index, String digits, String[] mapping,String output, List<String> res){
		if(index == digits.length()){
			res.add(output);
			return;
		}
		int digit = digits.charAt(index) - '0';
		String letters = mapping[digit];
		for(int i = 0;i<letters.length();i++){
			findCombinations(index+1, digits, mapping,output + letters.charAt(i), res);
		}
	}

    public List<String> letterCombinations(String digits) {
        String output= "";
		String[] mapping = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
		List<String> res = new ArrayList<>();
        if(digits.isEmpty())
            return res;
		findCombinations(0, digits,mapping,output,res);
		return res;

    }
}