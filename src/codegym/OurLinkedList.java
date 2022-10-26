package codegym;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class OurLinkedList<T> {
    private Node<T> first = new Node<>();
    private Node<T> last = new Node<>();

    public OurLinkedList() {
        first.next = last;
        last.prev = first;
    }

    public void printAll() {
        Node currentElement = first.next;
        while ((currentElement) != null) {
            System.out.println(currentElement.value);
            currentElement = currentElement.next;
        }
    }


    public void add(int index, T value) {
        Node node = new Node();
        node.value = value;
        Node currentElement = first.next;
        for(int i = 0; i < index; i++) {
            currentElement = currentElement.next;
        }
        Node ref = currentElement.prev;
        ref.next = node;
        currentElement.prev = node;
        node.prev = ref;
        node.next = currentElement;
    }

    public T get(int index) {
        Node currentElement = first.next;
        int count = 0;
        while (count < index && (currentElement) != null) {
            currentElement = currentElement.next;
            count++;
        }
        return (T) currentElement.value;
    }


    public void add(T value) {
        Node node = new Node();
        node.value = value;
        Node ref = last.prev;
        ref.next = node;
        last.prev = node;
        node.prev = ref;
        node.next = last;
    }

    public static class Node<T> {
        private Node prev;
        private T value;
        private Node next;
    }

    // Retrieves and removes the head (first element) of this list.
    public T remove( ) {
        Node node = new Node();
        node = first;
        first = first.next;
        first.prev = null;

        return (T)node.value;
    }

    public <Type> Type[] toArray(Type[] a) {
        Node currentNode = first.next;
        Type[] arr = (Type[]) Array.newInstance(a.getClass().getComponentType(), this.size());
        int index = 0;
        while(currentNode.value != null) {
            System.out.println(index + ": " + currentNode.value);
            arr[index++] = (Type)currentNode.value;
            currentNode = currentNode.next;
        }

        return arr;
    }
}
