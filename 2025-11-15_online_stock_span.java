// Problem: Online Stock Span
// Link: https://leetcode.com/problems/online-stock-span/description/

class StockSpanner {

    private Stack<int[]> st;  // each element: {price, span}

    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;

        // merge spans of previous prices <= current
        while (!st.isEmpty() && st.peek()[0] <= price) {
            span += st.pop()[1];
        }

        st.push(new int[]{price, span});
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */