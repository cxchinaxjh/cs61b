import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListDeque61B<T> implements Deque61B<T> {
    private static class Node<T> {
        T data;
        Node<T> nxt,pre;
        private Node(T data, Node<T> nxt, Node<T> pre) {
            this.data = data;
            this.nxt = nxt;
            this.pre = pre;
        }
    }
    public Node<T> sentinel;
    public int len=0;
    public LinkedListDeque61B() {
        sentinel = new Node<>(null, null, null);
        sentinel.nxt = sentinel;
        sentinel.pre = sentinel;
        len = 0;
    }

    @Override
    public void addFirst(T x) {
        Node<T> newNode=new Node<>(x,sentinel.nxt,sentinel);
        sentinel.nxt.pre=newNode;
        sentinel.nxt=newNode;
        len++;
    }

    @Override
    public void addLast(T x) {
        Node<T> newNode=new Node<>(x,sentinel,sentinel.pre);
        sentinel.pre.nxt=newNode;
        sentinel.pre=newNode;
        len++;
    }

    @Override
    public List<T> toList() {
        List<T> list=new ArrayList<>();
        Node<T> node=sentinel;
        for(int i=1;i<=len;i++){
            node=node.nxt;
            list.add(node.data);
        }
        return list;
    }

    @Override
    public boolean isEmpty() {
        return len == 0;
    }

    @Override
    public int size() {
        return len;
    }

    @Override
    public T removeFirst() {
        if (len==0) return null;
        T ans;
        ans=sentinel.nxt.data;
        sentinel.nxt = sentinel.nxt.nxt;
        sentinel.nxt.pre = sentinel;
        len--;
        return ans;
    }

    @Override
    public T removeLast() {
        if (len==0) return null;
        T ans;
        ans=sentinel.pre.data;
        sentinel.pre = sentinel.pre.pre;
        sentinel.pre.nxt = sentinel;
        len--;
        return ans;
    }

    @Override
    public T get(int index) {
        Node<T> node=sentinel.nxt;
        for (int i = 0; i < index; i++) {
            node=node.nxt;
        }
        return node.data;
    }
    public T getans(Node<T> node,int index)
    {
        if (index==0) return node.data;
        return getans(node.nxt,index-1);
    }
    @Override
    public T getRecursive(int index) {
        Node<T> node=sentinel.nxt;
        return getans(node,index);
    }
}
