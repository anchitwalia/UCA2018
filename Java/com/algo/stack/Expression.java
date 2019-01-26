com.algo.stack;

public class Expression {
    public int evalRPN(ArrayList<String> A) {
        Stack<Integer> s = new Stack<Integer>();
        int x = A.size();
        int i = 0;

        for(String ob : A) {

            if(ob.equals("+") || ob.equals("-") || ob.equals("*") || ob.equals("/")) {
                int a = s.pop();
                int b = s.pop();

                switch (ob) {
                    case "+": s.push(a + b); break;
                    case "-": { s.push(b - a); break; }
                    case "*": { s.push(a * b); break; }
                    case "/": { s.push(b / a); break; }
                }
            }

            else {
                s.push(Integer.valueOf(ob));
                i++;
            }

        }
        return s.pop();
    }
}
