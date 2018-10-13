public class MyStack {
    Node first = null;

    public void push(Object value) //если LIFO, то добавляем и забираем с начала стека
    {
        if (first == null) first = new Node(null, value);
        else {
            Node newFirst = new Node(first, value);
            newFirst.setNext(first);
            first.setPrevious(newFirst);
            first = newFirst;
        }
    }

    public void remove(int index) {
        if (index > size() - 1) return;
        if (index == 0) {
            first = first.getNext();
        } else {
            Node temp = first;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.getNext();
            }
            temp.setNext(temp.getNext().getNext());
        }
    }

    public void clear(){
        first = null;
    }

    public int size(){
        int size = 0;

        for (Node temp = first; temp != null; temp = temp.getNext()) {
                size++;
        }

        return size;
    }

    public Object peek(){
        if(first == null) return null;
        return first.getValue();
    }

    public Object pop(){
        if(first == null) return null;
        Node temp = first;
        first = first.getNext();
        return temp.getValue();
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
