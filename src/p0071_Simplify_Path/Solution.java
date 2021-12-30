package p0071_Simplify_Path;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("/home --> " + simplifyPath2("/home/"));
		System.out.println("/ --> " + simplifyPath2("/../"));
		System.out.println("/home/foo --> " + simplifyPath2("/home//foo/"));
		System.out.println("/a/c --> " + simplifyPath2("/a/./b/../c/"));
		System.out.println("/a/b/c --> " + simplifyPath2("/a/./b/c/"));
	}
	
	public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        
		for(String item : path.split("/")) {
			if(!item.equals(".") && !item.equals("..") && !item.equals("")) {
				stack.push(item);
			} else if(!stack.isEmpty() && item.equals("..")) {
				stack.pop();
			}
		}
		
		List<String> result = new ArrayList<String>(stack);
		
		return "/" + String.join("/", result);
    }
	
	public static String simplifyPath2(String path) {
        Stack<String> stack = new Stack<>();
        
		for(String item : path.split("/")) {
			if(!item.equals(".") && !item.equals("..") && !item.equals("")) {
				stack.push(item);
			} else if(!stack.isEmpty() && item.equals("..")) {
				stack.pop();
			}
		}
		
		StringBuilder result = new StringBuilder();
		
		for(String item : stack) {
			result.append("/");
			result.append(item);
		}
		if(result.length() == 0) {
			result.append("/");
		}
		
		return result.toString();
    }

}
