import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            // Push opening brackets
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } 
            // Handle closing brackets
            else {
                if (stack.isEmpty()) 
                    return false;

                char top = stack.pop();

                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));       // true
        System.out.println(isValid("()[]{}"));   // true
        System.out.println(isValid("(]"));       // false
        System.out.println(isValid("([)]"));     // false
        System.out.println(isValid("{[]}"));     // true
    }
}


/*⏱️ Time & Space Complexity

Time Complexity: O(n)
Space Complexity: O(n) (stack)

🎯 How to Explain to the Interviewer (Perfect Answer)

“I use a stack to keep track of opening brackets.
When I encounter a closing bracket, I pop the top element and check if it matches.
If there is any mismatch or leftover brackets, the string is invalid.”*/