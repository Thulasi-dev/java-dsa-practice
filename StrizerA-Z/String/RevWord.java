public static String revWord(String s) {
		String result ="";
		int i=s.length()-1;
		
		while(i>=0) {
			while(i>=0&&s.charAt(i)==' ') {
				i--;
			}
			
			if(i<0)
				break;
			
			int end=i;
			
			while(i>=0&&s.charAt(i)!=' ') {
				i--;
			}
			
			int start = i+1;
			
			String word = "";
			for(int j=start;j<=end;j++) {
				word+=s.charAt(j);
			}
			
			if(result.length()>0) {
				result+=' ';
			}
			result+=word;
		}
		return result;
	}


// Input: "I am a developer";
// Output: developer a am I
