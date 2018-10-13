import java.util.Arrays;
import java.util.List;

public class MyArrayList {
    private Object[] arr = new Object[0];

    public void add(Object t) //добавляет элемент в конец
    {
        Object[] temp = new Object[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        temp[temp.length - 1] = t;

        arr = temp;
    }

    public void remove(int index) //удаляет элемент под индексом
    {
        Object[] temp = new Object[arr.length - 1];
        for (int i = 0; i < index; i++) {
            temp[i] = arr[i];
        }
        for (int i = index; i < arr.length - 1; i++) {
            temp[i] = arr[i + 1];
        }

        arr = temp;
    }

    public void clear() //очищает коллекцию
    {
        arr = new Object[0];
    }

    public int size() //возвращает размер коллекции
    {
        return arr.length;
    }

    public Object get(int index) //возвращает элемент под индексом
    {
        return arr[index];
    }

    @Override
    public String toString() {
        return "arr=" + Arrays.toString(arr);
    }
}
