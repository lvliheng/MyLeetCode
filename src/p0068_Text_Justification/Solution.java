package p0068_Text_Justification;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("[\n"
				+ "   \"This    is    an\",\n"
				+ "   \"example  of text\",\n"
				+ "   \"justification.  \"\n"
				+ "]");
		
		System.out.println();
		
		printResult(fullJustify2(new String[] {"This", "is", "an", "example", "of", "text", "justification."}, 16));
		printResult(fullJustify2(new String[] {"What","must","be","acknowledgment","shall","be"}, 16));
		printResult(fullJustify2(new String[] {"Listen","to","many,","speak","to","a","few."}, 6));
		printResult(fullJustify2(new String[] {"What","must","be","shall","be."}, 5));
	}
	
	public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        String curr = "";
        
        for(int i = 0; i < words.length; i++) {
        	if(curr.length() + words[i].length() < maxWidth) {
        		if(i == words.length - 1) {
        			curr += words[i];
        					
        			String blank = "";
        			if(curr.length() < maxWidth) {
        				for(int n = 0; n < maxWidth - curr.length(); n++) {
        					blank += " ";
        				}
        			}
        			
        			result.add(curr + blank);
        			
        			curr = "";
        		} else {
        			curr += words[i] + " ";
        		}
        	} else if(curr.length() + words[i].length() == maxWidth) {
        		curr += words[i];
        		result.add(curr);
        		
        		curr = "";
        	} else {
        		String[] currList = curr.split(" ");
        		curr = curr.replace(" ", "");
        		int blankCounts = maxWidth - curr.length();
        		String temp = "";
        		
        		for(int j = 0; j < currList.length; j++) {
        			String blank = "";
        			if(j <= currList.length - 1 && blankCounts > 0) {
        				if(currList.length <= 1) {
        					blank = " ";
            				for(int n = 0; n < blankCounts - 1; n++) {
            					blank += " ";
            				}
            			} else {
            				if(blankCounts % (currList.length - 1) > 0 && (j <= blankCounts % (currList.length - 1) - 1)) {
            					for(int m = 0; m < blankCounts / (currList.length - 1) + 1; m++) {
                					blank += " ";
                				}
                			} else {
                				for(int m = 0; m < blankCounts / (currList.length - 1); m++) {
                					blank += " ";
                				}
                			}
            			}
        			}
        			
        			if(currList.length == 1) {
        				temp += currList[j] + blank;
        			} else if(j < currList.length - 1) {
        				temp += currList[j] + blank;
        			} else {
        				temp += currList[j];
        			}
        		}
        		
        		result.add(temp);
        		
        		if(i == words.length - 1) {
        			curr = words[i];
        			
        			String blank = "";
        			if(curr.length() < maxWidth) {
        				for(int n = 0; n < maxWidth - curr.length(); n++) {
        					blank += " ";
        				}
        			}
        			
        			result.add(curr + blank);
        		}
        		
        		if(words[i].length() < maxWidth) {
    				curr = words[i] + " ";
    			} else {
    				curr = words[i];
    			}
        	}
        }
        
        return result;
    }
	
	public static List<String> fullJustify2(String[] words, int maxWidth) {
		List<String> result = new ArrayList<>();
        
		int i = 0;
		while(i < words.length) {
			int j = i, len = 0;
			
			while(j < words.length && len + words[j].length() + j - i <= maxWidth) {
				len += words[j++].length();
			}
			
			String out = "";
			int space = maxWidth - len;
			
			for(int k = i; k < j; k++) {
				out += words[k];
				if(space > 0) {
					int temp = 0;
					if(j == words.length) {
						if(j - k == 1) {
							temp = space;
						} else {
							temp = 1;
						}
					} else {
						if(j - k - 1 > 0) {
							if( space % (j - k - 1) == 0) {
								temp = space / (j - k - 1);
							} else {
								temp = space / (j - k - 1) + 1;
							}
						} else {
							temp = space;
						}
					}
					
					for(int n = 0; n < temp; n++) {
						out += " ";
					}
					space -= temp;
				}
			}
			
			result.add(out);
			i = j;
		}
        
        return result;
    }
	
	private static void printResult(List<String> result) {
		System.out.println();
		
		for(String item : result) {
			System.out.println(item + "  " + item.length());
		}
	}

}
