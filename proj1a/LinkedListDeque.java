public class LinkedListDeque<Items> {

    /** 节点类型创建 */
    public class Node{
        Items item;
        Node prev;
        Node next;

        public Node(){
            item = null;
            prev = this;
            next = this;
        }
        public Node(Items x, Node p, Node q){
            item = x;
            prev = p;
            next = q;
        }
    }

    /** 链表变量声明 */
    public Node sentinel;
    private int size;

    public LinkedListDeque(){
        sentinel = new Node(null,null,null);
        size = 0;
    }

    /** 首位添加节点 */
    public void addFirst(Items x){
        if(isEmpty()){
            Node f = new Node(x,sentinel,sentinel);
            sentinel.next = f;
            sentinel.prev = f;
        }else {
            sentinel.next.prev = new Node(x,sentinel,sentinel.next);
            sentinel.next = sentinel.next.prev;
        }
        size = size + 1;
    }

    public void addLast(Items x){
        if(isEmpty()){
            Node f = new Node(x,sentinel,sentinel);
            sentinel.next = f;
            sentinel.prev = f;
        }else {
            sentinel.prev.next = new Node(x,sentinel.prev,sentinel);
            sentinel.prev = sentinel.prev.next;
        }
        size = size + 1;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        Node p = sentinel.next;
        for(int i =0;i < size;i++){
            if(i > 0) {
                System.out.print(' ');
            }
            System.out.print(p.item);
            p = p.next;
        }
    }

    public Items removeFirst(){
        if(this.isEmpty()){
            return null;
        }
        Items x;
        Node first = this.sentinel.next;
        x = first.item;
        sentinel.next = first.next;
        first.next.prev =  sentinel;
        size = size - 1;
        return x;
    }

    public Items removeLast(){
        if(this.isEmpty()){
            return null;
        }
        Items x;
        Node Last = this.sentinel.prev;
        x = Last.item;
        sentinel.prev = Last.prev;
        Last.prev.next = sentinel;
        size = size - 1;
        return x;
    }

    public Items get(int index){
        if(index <= 0|| index > size){
            return null;
        }
        Node p = sentinel;
        for(int i = 0;i < index;  i++){
            p = p.next;
        }
        return p.item;
    }

    public Items getRecursive(int index){
        if(size > 0 && (index <= 0|| index > size)) {
            return null;
        }
        if(index == 1){
            return this.sentinel.next.item;
        }
        LinkedListDeque<Items> l = new LinkedListDeque<>();
        l.sentinel = this.sentinel.next;
        return l.getRecursive(index - 1);
    }

/*    public static void main(String[] args){
        LinkedListDeque<Integer> LL = new LinkedListDeque<>();
        LL.addFirst(10);
        LL.addFirst(20);
        LL.addLast(222);
        LL.addFirst(30);
        LL.addLast(999);
        LL.printDeque();
        System.out.println();
        System.out.println(LL.getRecursive(6));
        System.out.println(LL.size());
    }*/
}
