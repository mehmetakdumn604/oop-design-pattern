package com.mycompany.oop1.Iterator;

public class CustomLinkedList<T> implements LinkedList<T> {
    // inner class
    class Node<T> {

        private T data;// Diğer projelerle uyum sağlaması açısından T kullanıldı
        private Node<T> next;

        // düğüm yapısı oluşturuldu
        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T newData) {
            data = newData;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> newNext) {
            next = newNext;
        }

    }

    // oluşturulan düğüm yapısını linked listede kullanımı
    private Node<T> head = null;
    private Node<T> tail = null;
    private int currentSize;

    public CustomLinkedList() {
        head = null;
        tail = null;
        currentSize = 0;
    }

    public void addNode(T data) {
        Node<T> newNode = new Node<T>(data);
        // listenin boş olup olmadığını kontrol etme
        if (head == null) {
            // eğer boş ise head ve tail newNode' a point edecek
            head = newNode;
            tail = newNode;
        } else {
            // newNode will be added after tail such that tail's next will point to newNode
            tail.next = newNode;
            // newNode will become new tail of the list
            tail = newNode;
        }
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean add(T e) {
        if (isEmpty()) {// eğer linked liste boş ise önce head düğümü oluşturulması gerekli
            head = new Node<T>(e, null);
            tail = head;// oluşturulan bu head tüğümü kuyruğa eklenmeli
        } else {
            // eğer ki boş değilse yeni eklenecek düğüm ilgili son kuyruğun bir sonraki
            // düğümüne eklenir
            tail.setNext(new Node<T>(e, null));
            tail = tail.getNext();
        }
        currentSize++;// yeni bir veri eklendiği için listenin eleman sayısı bir artırılır
        return true;
    }

    @Override
    public void clear() {// adından anlaşılacağı üzere listedeki tüm head tail gibi düğümleri bağlarını
                         // (koparmak) null a bağlıyor dolayısıyla liste tamamen temizlenmiş oluyor.
        head = null;
        tail = null;
        currentSize = 0;

    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size()) {
            // eğer ki index 0 dan küçük veya liste boyutuna büyük eşit olursa (ki zaten bu
            // dizi kavramına ters bir durum) bu durumda bir exception fırlatılır
            throw new IndexOutOfBoundsException();
        }

        if (index < size() - 1) {
            // index listenin sonundaki elemanı almamızı istiyorsa current düğümümüz son
            // elemana kadar next yapılır ve sona varıldığında indexin istediği ilgili
            // datayı döndürür.
            Node<T> current = head;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
            return current.getData();
        }
        return tail.getData();
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size()) {
            add(element);
            return;
        }
        if (index == 0) {
            head = new Node<T>(element, head);

        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            current.setNext(new Node<T>(element, current.getNext()));

        }
        currentSize++;

    }

    @Override
    public int size() {
        // liste boyutunu veren metod
        return currentSize;
    }

}
