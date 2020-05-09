public class DoubleLinkedListNode {
    private int value;
    private DoubleLinkedListNode next;
    private DoubleLinkedListNode previous;

    public DoubleLinkedListNode(int value,
                                DoubleLinkedListNode next,
                                DoubleLinkedListNode previous) {
        this.value = value;
        this.next = next;
        this.previous = previous;
    }

    public DoubleLinkedListNode(int value) {
        this(value, null, null);
    }

    public DoubleLinkedListNode() {}

    public void value(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public DoubleLinkedListNode next() {
        return next;
    }

    public void next(DoubleLinkedListNode next) {
        this.next = next;
    }

    public DoubleLinkedListNode prev() {
        return previous;
    }

    public void prev(DoubleLinkedListNode previous) {
        this.previous = previous;
    }
}
