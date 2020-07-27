import java.awt.Point;

public class LinkedStack {

    private static class Node{

        /**
         * Creates data to hold a Point
         */
        private Point data;

        /**
         * Next node that is null
         */
        private Node next;

        /**
         * Creates a new node
         * @param d data to be held
         * @param n points to next node
         */
        public Node(Point d, Node n){

            data = d;
            next = n;
        }

        /**
         * Puts the data into a string
         * @return  data as a string
         */
        public String toString(){

            return data.toString();
        }
    }

    /**
     * Creates the top of the stack
     */
    private Node top;

    /**
     * Creates a new stack
     */
    public LinkedStack(){

        top = null;
    }

    /**
     * Checks if the stack is empty
     * @return  true if the list is empty, false otherwise
     */
    public boolean isEmpty(){

        return top == null;
    }

    /**
     * Adds to the stack
     * @param s point to be added
     */
    public void push(Point s){

        top = new Node(s, top);
    }

    /**
     * Removes the top data from the stack
     * @return  removed data
     */
    public Point pop(){

        Point retVal = new Point();
        if(!isEmpty()){

            retVal = top.data;
            top = top.next;
        }

        return retVal;
    }

    /**
     * Looks at the top of the stack
     * @return  data at the top of the stack
     */
    public Point peek(){

        Point retVal = new Point();
        if(!isEmpty()){

            retVal = top.data;
        }

        return retVal;
    }

    /**
     * Converts the stack into strings to be printed
     * @return  string to be printed
     */
    public String toString(){

        String s = "";
        Node n = top;
        while(n != null){

            s = s+ n.data + " ";
            n = n.next;
        }

        return s;
    }

    /**
     * Calculates the size of the stack
     * @return  size of the stack
     */
    public int size(){

        int count = 0;
        Node n = top;
        while(n != null){

            count++;
            n = n.next;
        }

        return count;
    }
}
