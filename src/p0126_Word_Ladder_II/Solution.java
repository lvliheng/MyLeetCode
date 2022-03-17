package p0126_Word_Ladder_II;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {
	
	
	public static void main(String[] args) {
		
		List<String> wordList = new ArrayList<>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");
		
		System.out.println("[[\"hit\",\"hot\",\"dot\",\"dog\",\"cog\"],[\"hit\",\"hot\",\"lot\",\"log\",\"cog\"]] -->");
		
		List<List<String>> result = findLadders("hit", "cog", wordList);
		
		for(List<String> list : result) {
			for(String item : list) {
				System.out.print(item + " ");
			}
			
			System.out.println();
		}
	}
	
	public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> wordSet = new HashSet<>(wordList);
        
        if(wordSet.contains(beginWord)) {
        	wordSet.remove(beginWord);
        }
        
        if(!wordSet.contains(endWord)) {
        	return new ArrayList<>();
        }
        
        boolean flag = false;
        Map<String, Set<String>> memory = new HashMap<>();
        
        while(!queue.isEmpty()) {
        	int size = queue.size();
        	Set<String> thisLevel = new HashSet<>();
        	
        	for(int i = 0; i < size; i++) {
        		String current = queue.poll();
        		
        		for(int j = 0; j < current.length(); j++) {
        			char[] letters = current.toCharArray();
        			
        			for(char letter = 'a'; letter <= 'z'; letter++) {
        				letters[j] = letter;
        				String temp = new String(letters);
        				
        				if(temp.equals(endWord) || wordSet.contains(temp)) {
        					if(!memory.containsKey(temp)) {
        						memory.put(temp, new HashSet<>());
        					}
        					memory.get(temp).add(current);
        				}
        				
        				if(temp.equals(endWord)) {
        					flag = true;
        				} else if(wordSet.contains(temp)) {
        					thisLevel.add(temp);
        				}
        			}
        		}
        	}
        	
        	for(String item : thisLevel) {
        		wordSet.remove(item);
        		queue.add(item);
        	}
        	
        	if(flag) {
        		break;
        	}
        }
		
		if(memory.isEmpty()) {
			return new ArrayList<>();
		}
		
		List<List<String>> result = new ArrayList<>();
		List<String> current = new ArrayList<>();
		current.add(endWord);
		
		return backTrace(memory, current, result, endWord);
    }
	
	private static List<List<String>> backTrace(Map<String, Set<String>> memory, List<String> current, List<List<String>> result, String word) {
		if(!memory.containsKey(word)) {
			List<String> temp = new ArrayList<>(current);
			Collections.reverse(temp);
			result.add(temp);
		} else {
			for(String item : memory.get(word)) {
				current.add(item);
				result = backTrace(memory, current, result, item);
				current.remove(current.size() - 1);
			}
		}
		
		return result;
	}
}
