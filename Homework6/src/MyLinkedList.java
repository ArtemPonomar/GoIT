public class MyLinkedList {

    Node firstNode = null;


    public void add(Object t) //добавляет элемент в конец
    {
        if (firstNode == null) {
            firstNode = new Node(null, t);
        } else {
            Node temp = firstNode;
            while (temp.getNext() != null)
                temp = temp.getNext();
            temp.setNext(new Node(temp, t));
        }
    }

    public void remove(int index) //удаляет элемент под индексом
    {
        if (index > size() - 1) return;
        if (index == 0) firstNode = firstNode.getNext();
        else {
            Node temp = firstNode;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.getNext();
            }
            temp.setNext(temp.getNext().getNext());
        }
    }

    public void clear() //очищает коллекцию
    {
        firstNode = null;
    }

    public int size() //возвращает размер коллекции
    {
        int size = 0;

        for (Node temp = firstNode; temp != null; temp = temp.getNext()){
            size++;
        }

        return size;
    }

    public Object get(int index) //возвращает элемент под индексом
    {
        if (index > size() - 1) return null;

        if (index == 0) return firstNode;

        Node temp = firstNode;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        return temp.getValue();
    }

    @Override
    public String toString() {
        String result = "";
            for (Node temp = firstNode; temp != null; temp = temp.getNext())
                result += temp.getValue() + " ";
        return result;
    }
}
