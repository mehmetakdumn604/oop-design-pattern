package com.mycompany.oop1.Iterator;

public interface LinkedList<T> {

    // kullanılacak olan metodlar eklendi
    public void addNode(T data);// düğümün sonuna veri ekleme

    public void add(int index, T element);// belirli bir indexe veri ekleme

    public boolean isEmpty();// linkedlistin boş olup olmadığını kontrol etme

    public boolean add(T data);// düğümün sonuna veri eklenip eklenemeyeceğini kontrol eden metod

    public void clear();// linked listteki tüm düğümleri temizleme

    public T get(int index); // listedeki ilgili indexteki veriyi alma

    public int size(); // listenin içerisinde toplam data sayısını alma

}
