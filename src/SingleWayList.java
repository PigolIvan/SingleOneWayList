import java.util.Iterator;
import java.util.NoSuchElementException;

public class SingleWayList<T> implements Iterable<T> {
    private Node<T> head;
    private int size = 0;
    private Node<T> tail;

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }
    public class MyIterator implements Iterator<T>{
        private Node<T> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }
        @Override
        public T next(){
            T data = current.data;
            current = current.next;
            return data;
        }
    }
    public static class Node<T> {
        T data;
        Node<T> next;
        public Node(T data){
            this.data = data;
            this.next = null;
        }
    }
    public void addFirst(T data){
        Node<T> newNode = new Node<T>(data);
        newNode.next = head;
        head = newNode;
        size++;
    }
    public void add(T data){
        Node<T> newNode = new Node<T>(data);
        if(head == null) {
            head = newNode;
            tail = newNode;
        }else{
            Node<T> current = head;
            Node<T> last = tail;
            while(last.next != null){
                last = last.next;
            }
            last.next = newNode;
            tail = newNode;
        }
        size++;
    }
    public void removeFirst(){
        if(head != null){
            head = head.next;
            tail = tail.next;
            size--;
        }
    }
    public void removeLast(){
        if (head == null){
            return;
        }
        if (head.next == null){
            head = null;
            tail = null;
            size--;
            return;
        }
        Node<T> current = head;
        while (current.next.next != null){
            current = current.next;
        }
        current.next = null;
        tail = current;
        size--;
    }
    public void printList(){
        Node<T> current = head;
        while(current != null){
            System.out.println(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    public T get(int index){
        if (index < 0){
            throw new IndexOutOfBoundsException();
        }
        Node<T> current = head;
        for (int i = 0; i<index; i++){
            if (current == null){
                throw new IndexOutOfBoundsException();
            }
            current = current.next;
        }
        return current.data;
    }
    public int getSize(){
        return size;
    }
    public void setValue(int index, T data){
        if (index < 0){
            throw new IndexOutOfBoundsException();
        }
        Node<T> current = head;
        for(int i = 0; i < index; i++){
            if(current == null){
                throw new IndexOutOfBoundsException();
            }
            current = current.next;
        }
        current.data = data;
    }
    public void tailPrint(){
        System.out.println(tail.data);
    }
}
