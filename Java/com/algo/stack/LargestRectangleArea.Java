com.algo.stack;

public class LargestRectangleArea {
    public int largestRectangleArea(ArrayList<Integer> A) {
        Stack<Integer> s = new Stack<Integer>();
        int x = A.size();
        int i = 0;
        int area = 0;

        for(i = 0; i<x;) {
            if(s.isEmpty() || A.get(i) >= A.get(s.peek())) {
                s.push(i);
                i++;
            }
            else {
                int value = s.pop();
                if(s.isEmpty()) {
                    area = Math.max(area, A.get(value) * i);
                }
                else {
                    area = Math.max(area, A.get(value) * (i - s.peek() - 1));
                }
            }
        }

        while(!s.isEmpty()) {
            int value = s.pop();
                if(s.isEmpty()) {
                    area = Math.max(area, A.get(value) * x);
                }
                else {
                    area = Math.max(area, A.get(value) * (i - s.peek() - 1));
                }
        }
        return area;
    }
}
