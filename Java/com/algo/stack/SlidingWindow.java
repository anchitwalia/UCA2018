com.algo.stack;

public class SlidingWindow {
    public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        ArrayList<Integer> l = new ArrayList<Integer>();
        Deque<Integer> d = new LinkedList<Integer>();
        int x = A.size();
        int i = 0;

        if(x <= B) {
            int a = Collections.max(A, null);
            l.add(a);
            return l;
        }
        for(i = 0; i < B; i++) {
            while(!d.isEmpty() && A.get(i) >= A.get(d.peekLast())) {
                d.removeLast();
            }
            d.addLast(i);
        }
        for( ; i < x; i++) {
            l.add(A.get(d.peekFirst()));
            while(!d.isEmpty() && d.peekFirst() <= (i - B)) {
                d.removeFirst();
            }
            while(!d.isEmpty() && A.get(i) >= A.get(d.peekLast())) {
                d.removeLast();
            }
            d.addLast(i);
        }
        l.add(A.get(d.peekFirst()));
        return l;
    }
}
