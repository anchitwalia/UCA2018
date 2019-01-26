com.algo.stack;

public class RainWaterTrapped {
  public int trap(final List<Integer> A) {
      Stack<Integer> s = new Stack<Integer>();
      int result = 0;
      int x = A.size();

      for(int i = 0; i < x; i++) {
          while(!s.isEmpty() && A.get(i) > A.get(s.peek())) {
              int y = s.pop();
              if(s.isEmpty()) {
                  break;
              }
              int dist = i - s.peek() - 1;
              int height = Math.min(A.get(s.peek()), A.get(i)) - A.get(y);
              result += (dist*height);
          }
          s.push(i);
      }
      return result;
  }
}
