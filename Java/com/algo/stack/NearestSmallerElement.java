com.algo.stack;

public class NearestSmallerElement {
  public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
      Stack<Integer> s = new Stack<Integer>();
      ArrayList<Integer> l = new ArrayList<Integer>();
      int popped = 0;
      for(int i = 0; i < A.size(); i++){
          while(!s.isEmpty() && s.peek() >= A.get(i)){
              popped = s.pop();
          }
          if(s.isEmpty())
              l.add(-1);
          else
              l.add(s.peek());
          s.push(A.get(i));
      }

      return l;
  }
}
