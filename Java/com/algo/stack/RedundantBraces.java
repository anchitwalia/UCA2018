com.algo.stack;

public class RedundantBraces {
    public int braces(String A) {
        Stack<Character> s = new Stack<Character>();
        for(int i = 0; i < A.length(); i++) {
            if(A.charAt(i) == '(' || A.charAt(i) == '+' || A.charAt(i) == '-' || A.charAt(i) == '*' || A.charAt(i) == '/') {
                s.push(A.charAt(i));
            }
            else if (A.charAt(i) == ')') {
                boolean flag = false;
                while(s.peek() != '(') {
                    flag = true;
                    s.pop();
                }
                if(!flag) {
                    return 1;
                }
                s.pop();
            }
        }
        return 0;
    }
}
