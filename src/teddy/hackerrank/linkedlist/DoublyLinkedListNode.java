package teddy.hackerrank.linkedlist;


public class DoublyLinkedListNode {
    public DoublyLinkedListNode next;
    public DoublyLinkedListNode prev;
    public int data;

    public DoublyLinkedListNode(int _data) {
        this.data = _data;
        next = null;
        prev = null;
    }
}
