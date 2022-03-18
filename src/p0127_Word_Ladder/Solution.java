package p0127_Word_Ladder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution {

	
	
	public static void main(String[] args) {
		List<String> wordList = new ArrayList<>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("tog");
		wordList.add("cog");
		
		System.out.println("5 --> " + ladderLength("hit", "cog", wordList));
	}
	
	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> wordSet = new HashSet<>(wordList);
        
        int count = 0;
        
        while(!queue.isEmpty()) {
        	int size = queue.size();
        	for(int i = 0; i < size; i++) {
        		String current = queue.poll();
        		
        		if(current.equals(endWord)) {
        			return count + 1;
        		}
        		
        		for(int j = 0; j < current.length(); j++) {
        			char[] letters = current.toCharArray();
        			
        			for(char letter = 'a'; letter <= 'z'; letter++) {
        				letters[j] = letter;
        				String temp = new String(letters);
        				
        				if(wordSet.contains(temp)) {
        					queue.add(temp);
        					wordSet.remove(temp);
        				}
        			}
        		}
        	}
        	
        	count++;
        }
        
        return 0;
    }
}
