package LinkedList;

public class MyList {
    MyNode head;

    public void removeFirst(String data) {
        if (head == null) return;
        if (head.data.equals(data)) {
            head = head.next;
            return;
        }
        MyNode p = head;
        while (p.next != null && !p.next.data.equals(data))
            p = p.next;
        if (p.next != null)
            p.next = p.next.next;
    }

    public void append(String data) {
        head = append(data, head);
    }

    private MyNode append(String data, MyNode node) {
        if (node == null) return new MyNode(data, null);
        node.next = append(data, node.next);
        return node;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        for (MyNode p = head; p != null; p = p.next) builder.append(p.data).append(" ");
        int length = builder.length();
        if (length > 2) { builder.deleteCharAt(length - 1); }
        return builder.append("]").toString();
    }

    class MyNode {
        String data;
        MyNode next;

        public MyNode(String data, MyNode next) {
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        MyList list = new MyList();
        list.append("One");
        list.append("Two");
        list.append("Three");
        list.append("One");
        System.out.println(list); //One Two Three One

        list.removeFirst("One");
        System.out.println(list);  //Two Three One
        list.removeFirst("One");
        System.out.println(list);  //Two Three
        list.removeFirst("One");
        System.out.println(list);  //Two Three

        list.removeFirst("Two");
        System.out.println(list);  //Three
        list.removeFirst("Three");
        System.out.println(list);  //[]
        list.removeFirst("Three");
        System.out.println(list);  //[]
    }
}
