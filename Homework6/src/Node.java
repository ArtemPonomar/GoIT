public class Node {
    private Node previous;
    private Object value;
    private Node next;

    public Node(Node previous, Object value) {
        this.previous = previous;
        this.value = value;
        this.next = null;
    }

    public Object getValue() {
        return value;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Node getPrevious() {
        return previous;
    }
}
