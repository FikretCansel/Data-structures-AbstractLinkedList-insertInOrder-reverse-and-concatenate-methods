public class ss<T extends Comparable<T>> extends AbstractLinkedList<T> {

    @Override
    public void insertInOrder(T value) {
        Node<T> current = getHead();

        if (current == null) {
            addFirst((T) value);
        }
        else {
            while (current != null) {
                if (value.compareTo(current.value) > 0) {



                    if(current.next == null){
                        addLast(value);
                        break;
                    }
                }
                if (value.compareTo(current.value) < 0) {
                    moveInsert(current,value);//insert methodunu çagır(insert methodu elemanları yer degiştirir ve ekle)
                    break;
                }
                if(value.compareTo(current.value) == 0){//eger bir sonraki elemana eşitse
                    insertAfter(current,value);//insertAfter methodunu çagır(dügümün bir sonraki elamanına ekler)
                }
                current=current.next;
            }
        }
    }

    @Override
    public AbstractLinkedList<T> reverse() {
        ss<T> list=new ss<>();//boş liste oluştur
        Node<T> current=getHead();
        while(current!=null)
        {
            list.addFirst(current.value);
            current=current.next;
        }
        return list;
    }

    @Override
    public AbstractLinkedList<T> concatenate(AbstractLinkedList<T> list) {
        ss list1 =new ss();
        Node<T> node1=getHead();
        Node<T> node2= list1.getHead();
        while(node1!=null){//dügüm boş degilse(dügüm ilerledigi için son elemana gelince null oluyor ve döngü bitiyor)
            list1.addLast(node1.value);
            node1=node1.next;
        }
        while(node2!=null){
            list1.addLast(node2.value);
            node2=node2.next;

        }
        return list1;

    }

    public void insertAfter(Node<T> node,T value){
        Node<T> newNode=new Node<T>(value,node.next);
        node.next=newNode;
    }

    public void moveInsert(Node<T> node, T value){
        Node<T> tempValue=new Node<T>(value,null);
        Node<T> newNode=new Node<T>(value,node.next);
        tempValue.value=node.value;
        node.next=newNode;
        node.value=value;
        node.next.value=tempValue.value;
    }
}