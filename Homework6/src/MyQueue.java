public class MyQueue {
    Node first = null;
    Node last = null;

    public void add(Object value) {
        if (first == null) {
            first = new Node(null, value);
            last = first;
        } else {
            last.setNext(new Node(last, value));
            last = last.getNext();
        }
    }

    public void remove(int index) {
        if (first == null) return;
        Node temp = first;
        if (index == 0) first = first.getNext();
        else {
            for (int i = 0; i < index - 1; i++) {
                temp = temp.getNext();
            }
            temp.setNext(temp.getNext().getNext());
        }
    }

    public void clear() {
        first = null;
        last = null;
    }

    public int size() {
        if (first == null) return 0;

        Node temp = first;
        int size = 1;

        while (temp.getNext() != null) {
            temp = temp.getNext();
            size++;
        }

        return size;
    }

    public Object peek() {  
        return last.getValue();
    }

    public Object poll() {
        if (first == null) return null;
        Object value = last.getValue();
        last = last.getPrevious();
        last.setNext(null);
        return value;
    }

    @Override
    public String toString() {
        String result = "";
        for (Node temp = first; temp != null; temp = temp.getNext()){
            result += temp.getValue() + " ";
        }
        return result;
    }
}
