public class Odev1LinkedList<T extends Comparable<T>> extends AbstractLinkedList<T> {
    @Override
    public void insertInOrder(T value) {
        Node<T> current = getHead();
        //dügüm boşsa addFirst yap(headi gelen value yap)
        if (current == null) {
            addFirst((T) value);
        }
        else {//liste boş degilse
            while (current != null) {//dügümün sonu gelene kadar dön
                if (value.compareTo(current.value) > 0) {//bir sonraki eleman büyükse gönderilen deger

                    //büyükse bişey yapma

                    if(current.next == null){
                        addLast(value);
                        break;
                    }
                }
                if (value.compareTo(current.value) < 0) {//eger value bir sonraki elamandan küçükse
                    moveInsert(current,value);//moveInsert methodunu çagır(insert methodu elemanları yer degiştirir ve ekle)
                    break;
                }
                if(value.compareTo(current.value) == 0){//eger bir sonraki elemana eşitse
                    insertAfter(current,value);
                    break;
                }
                current=current.next;
            }
        }
    }

    @Override
    public AbstractLinkedList<T> reverse() {
        Odev1LinkedList<T> list1=new Odev1LinkedList<>();//boş liste oluştur
        Node<T> Newnode=getHead();
        while(Newnode!=null)//dügümün son elemanına kadar dön
        {
            list1.addFirst(Newnode.value);//listenin sürekli başına ekledigi için ters dönmüş oluyor
            Newnode=Newnode.next;//üzerinde bulundugumuz elemanı ilertletiyoruz
        }
        return list1;
    }
    @Override
    public AbstractLinkedList<T> concatenate(AbstractLinkedList<T> list) {
        Odev1LinkedList list1 =new Odev1LinkedList();
        Node<T> node1=getHead();
        Node<T> node2= list.getHead();
        while(node1!=null){//dügüm boş degilse(dügüm ilerledigi için son elemana gelince null oluyor ve döngü bitiyor)
            list1.addLast(node1.value);//listeye ekle sondan ekledigimiz için sırasıyla eklenmiş oluyoruz
            node1=node1.next;//dügümü ilerlet
        }
        while(node2!=null){
            list1.addLast(node2.value);
            node2=node2.next;//birinci listenin üstüne sondan eklenir ve birleşmiş olur

        }
        return list1;
    }

    private void insertAfter(Node<T> node,T value){
        Node<T> newNode=new Node<T>(value,node.next);
        node.next=newNode;
    }

    private void moveInsert(Node<T> node,T value){//moveInsert methodu elemanları yer degiştirir ve ekle
        Node<T> current=new Node<T>(value,node.next);
        Node<T> tempNode=new Node<T>(value,null);
        tempNode.value=node.value;
        node.next=current;
        node.value=value;
        node.next.value=tempNode.value;
    }
}