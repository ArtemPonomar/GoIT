public class MyHashMap {
    SimpleNode first = null;

    public void put(int key, Object value) {
        if (first == null) {
            first = new SimpleNode(null, key, value);
        } else {
            for (SimpleNode temp = first; temp.getNext() != null; temp = temp.getNext())
                if (temp.getKey() == key) return;
            SimpleNode temp = first;
            first = new SimpleNode(temp, key, value);
        }
    }

    public void remove(int key) {
        if (first == null) return;
        if (first.getNext() == null && first.getKey() == key) first = first.getNext();
        else {
            for (SimpleNode temp = first; temp.getNext() != null; temp = temp.getNext()) {
                if (temp.getNext().getKey() == key) {
                    temp.setNext(temp.getNext().getNext());
                    return;
                }
            }
        }
    }

    public void clear() {
        first = null;
    }

    public int size() {
        if (first == null) return 0;
        int count = 1;
        for (SimpleNode temp = first; temp.getNext() != null; temp = temp.getNext()) {
            count++;
        }
        return count;
    }

    public Object get(int key){
        if(first == null) return null;
        for (SimpleNode temp = first; temp.getNext() != null; temp = temp.getNext()) {
            if(temp.getKey() == key) return temp.getValue();
        }
        return null;
    }

    @Override
    public String toString() {
        String result = "";
        for(SimpleNode temp = first; temp != null; temp = temp.getNext()){
            result += temp.getKey() + ":" + temp.getValue()+ " ";
        }
        return result;
    }
}

    class SimpleNode {
        private SimpleNode next;
        private int key;
        private Object value;

        public SimpleNode(SimpleNode next, int key, Object value) {
            this.next = next;
            this.key = key;
            this.value = value;
        }

        public SimpleNode getNext() {
            return next;
        }

        public void setNext(SimpleNode next) {
            this.next = next;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }
    }