import java.util.NoSuchElementException;

public class MyIntLinkedList {
    private DoubleLinkedListNode head;
    private DoubleLinkedListNode tail;
    private int size;

    public MyIntLinkedList() {
        this.head = new DoubleLinkedListNode();
        this.tail = head;
        this.size=0;
    }

    public MyIntLinkedList(MyIntLinkedList c) {
        this.head = c.getHead();
        this.tail = c.getTail();
        this.size = c.getSize();
    }

    private DoubleLinkedListNode getHead() {
        return this.head;
    }

    private DoubleLinkedListNode getTail() {
        return this.tail;
    }

    public int getSize() {
        return this.size;
    }

    public void add(int index, int element) {
        if (index < 0 || index > this.size)
            throw new IndexOutOfBoundsException();
        else {
            if (index == this.size)
                this.add(element);
            else {
                DoubleLinkedListNode it = new DoubleLinkedListNode(head.value(), this.head.next(), null);
                int i = -1;
                DoubleLinkedListNode newElement = new DoubleLinkedListNode(element);
                if (index == 0) {

                    newElement.next(head.next());
                    head.next().prev(newElement);
                    newElement.prev(null);
                    head.next(newElement);
                    this.size++;
                } else {
                    while (i < index) {
                        it = it.next();
                        i++;
                    }
                    newElement.next(it);
                    newElement.prev(it.prev());
                    it.prev(newElement);
                    newElement.prev().next(newElement);
                    this.size++;
                }
            }
        }
    }

    public boolean add(int e) {
        DoubleLinkedListNode newElement = new DoubleLinkedListNode(e, null, this.tail);
        this.tail.next(newElement);
        this.tail = newElement;
        this.size++;
        return true;
    }

    public DoubleLinkedListNode get(int index) {
        if (index < 0 || index > this.size)
            throw new IndexOutOfBoundsException();
        else {
            DoubleLinkedListNode it = new DoubleLinkedListNode();
            it.next(head.next());
            int i = -1;
            while (i < index) {
                it = it.next();
                i++;
            }
            return it;
        }
    }

    public boolean contains(int e) {
        DoubleLinkedListNode it = this.head.next();
        while (it != null) {
            if (it.value() == e)
                return true;
            it = it.next();
        }
        return false;
    }

    public int indexOf(int e) {
        DoubleLinkedListNode it = this.head.next();
        int i = -1;
        while (it != null) {
            i++;
            if (it.value() == e)
                return i;
            it = it.next();
        }
        return -1;
    }

    public int lastIndexOf(int e){
        int i=this.getSize();
        DoubleLinkedListNode it = this.tail;
        while (it != null) {
            i--;
            if (it.value() == e)
                return i;
            it = it.prev();
        }
        return -1;
    }

    public DoubleLinkedListNode set(int index,int e){
        if(index<0 || index>=this.getSize())
            return null;
        DoubleLinkedListNode element;
        element=this.removeElementAtIndex(index);
        this.add(index,e);
        return element;
    }

    public DoubleLinkedListNode remove(int e){
        if(this.getSize()==0 || this.contains(e)==false)
            return null;
        int i=this.indexOf(e);
        DoubleLinkedListNode element=this.get(i);
        if(i==0){
            element.next().prev(null);
            this.head.next(element.next());
            this.size--;
        }
        else if(i==this.getSize()-1){
            element.prev().next(null);
            this.tail=element.prev();
            this.size--;
        }
        else {
            element.next().prev(element.prev());
            element.prev().next(element.next());
            this.size--;
        }
        return element;
    }
    public DoubleLinkedListNode removeElementAtIndex(int index){
        if(index<0 || index>=this.getSize())
            return null;
        int element=this.get(index).value();
        return  this.remove(element);
    }
    public void clear(){
        this.head.next(null);
        this.tail=head;
        this.size=0;
    }

    public boolean addAll(MyIntLinkedList c){
        if(c.size==0)
            return false;
        this.tail.next(c.head.next());
        c.head.prev(this.tail);
        this.size+=c.size;
        return true;
    }
    public boolean addAll(int index,MyIntLinkedList c){
        if(index<0 || index>=this.getSize())
            return false;
        if(index==0){
            c.tail.next(this.head.next());
            this.head.next().prev(c.tail);
            this.head=c.head;
            this.size+=c.size;
            return true;
        }
        DoubleLinkedListNode it=new DoubleLinkedListNode(this.head.next().value(),head.next(),null);
        int i=-1;
        while(i<index){
            it=it.next();
            i++;
        }
        c.tail.next(it);
        it.prev().next(c.head.next());
        it.prev(c.tail);
        c.head.next().prev(it.prev());
        this.size+=c.size;
        return true;
    }

    public int[] toArray(){
        int[] array=new int[this.getSize()];
        DoubleLinkedListNode it;
        it=this.head.next();
        int i=0;
        while(it.next()!=null) {
            array[i++] = it.value();
            it = it.next();
        }
        array[i]=it.value();
        return array;
    }
}
