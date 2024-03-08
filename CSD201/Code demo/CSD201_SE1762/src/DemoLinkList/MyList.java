/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DemoLinkList;

/**
 *
 * @author Fpt
 */
public class MyList {

    Node head, tail;

    public MyList() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    void addLast(int value) {
        Node node = new Node(value);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    void addFirst(int value) {
        // btvn
        // kiểm tra xem nếu value là số nguyên tố thì do nothing, ngược lại addfirst vào list
        Node node = new Node(value);
        if (isEmpty()) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    void addIndex(int value, int index) {
        if (index < 0) {
            return;
        }
        if (index == 0) {
            addFirst(value);
        } else {
            Node cur = head;
            int pos = 0;
            while (cur != null) {
                if (index - 1 == pos) {
                    break;
                }
                cur = cur.next;
                pos++;
            }
            if (cur == null) {
                return;
            } else {
                Node node = new Node(value);
                node.next = cur.next;
                cur.next = node;
            }
        }
    }

    // in ra
    void display() {
        Node curent = head;
        while (curent != null) {
            System.out.print(curent.value + ", ");
            curent = curent.next;
        }
        System.out.println("");
    }

    // xoa
    void deleteFirst() {
        if (isEmpty()) {
            return;
        } else {
            head = head.next;
        }
    }

    int delFirst() {
        if (isEmpty()) {
            return -1;
        } else {
            int value = head.value;
            head = head.next;
            return value;
        }
    }

    void deleteLast() {
        if (isEmpty()) {
            return;
        }
        if (head == tail) {
            head = tail = null;
        } else {
            Node cur = head;
            while (cur.next.next != null) {
                cur = cur.next;
            }
            tail = cur;
            cur.next = null;

        }
    }

    int delLast() {
        int value = -1;
        if (isEmpty()) {
            return -1;
        }
        if (head == tail) {
            value = tail.value;
            head = null;
            tail = null;
            return value;

        } else {
            Node cur = head;
            // while(cur.next != tail)
            while (cur.next.next != null) {
                cur = cur.next; // đi tìm vị trí trước tail, cha của tail
            }
            value = cur.next.value;
            cur.next = null;
            tail = cur;
            return value;
        }

    }

    void deleteIndex(int index) {
        if (index < 0) {
            return;
        }
        if (index == 0) {
            delFirst();
        } else {
            Node cur = head;
            int pos = 0;
            while (cur.next != null) {
                if (index - 1 == pos) {
                    break;
                }
                cur = cur.next;
                pos++;
            }
            if (cur.next == null) {
                return;
            } else {

                cur.next = cur.next.next;

            }
        }
    }

    int delIndex(int index) {
        int value = -1;
        if (index < 0) {
            return value;
        }
        if (index == 0) {
            value = delFirst();
        } else {
            Node cur = head;
            int pos = 0;
            while (cur.next != null) {
                if (index - 1 == pos) {
                    break;
                }
                cur = cur.next;
                pos++;
            }
            if (cur.next == null) {// phan tu can tìm qua lon vì luc này cur là cha
                return value;
            }
            if (cur.next == tail) {
                value = delLast();
            } else {// index nam trong khoảng từ 0 đến nhỏ hơn size - 1
                value = cur.next.value;
                cur.next = cur.next.next;
            }

        }
        return value;
    }

    void myDelete() {
        // tìm và xóa bò phần tử đầu tiên và lớn nhất trong list
        // tìm và xóa bỏ phần tử cuối cùng lớn nhất trong list
        // tìm và xóa bò phần tử đầu tiên và bé nhất trong list
        // tìm và xóa bỏ phần tử cuối cùng bé nhất trong list 
        // tìm và xóa bỏ phần tử ddaaauf tiên và lớn thứ 2 trong list
        // cách: tìm max1 lớn nhât. Duyệt lits từ đầu đến cuối số nào mà nhỏ hơn max1 đồng thời lớn hơn max2 cập nhật max2 bằng số vừa duyệt
        if (isEmpty()) {
            return;
        }
        Node cur = head;
        int max = cur.value;
        int count = 0;
        for (Node i = head; i != null; i = i.next) {
            if (max < i.value) {
                max = i.value;
            }
        }
        for (Node i = head; i != null; i = i.next) {
            if (max == i.value) {
                break;
            }
            count++;
        }

        delIndex(count);// gọi hàm có sẵn
    }

    int delIndex1(int index) {
        if (index < 0) {
            return -1;
        }
        if (index == 0) {
            return delFirst();
        }
        Node cur = findIndex(index);
        if (cur == null) {
            return -1;// index quá lớn
        }
        if (cur == tail) {
            return delLast();
        }
        int value = cur.next.value;
        cur.next = cur.next.next;
        return value;
    }

    Node findIndex(int index) {
        // tìm và trả về node có vị trí index
        if (index < 0) {
            return null;
        }
        Node cur = head;
        int pos = 0;
        while (cur != null) {
            if (index - 1 == pos) {
                break;
            }
            cur = cur.next;
            pos++;
        }
        if (cur == null) {
            return null;// index quá lớn
        }
        return cur;
    }

    Node findFather(int value) {
        // 1.tìm và trả về node cha của node có giá trị value
        // 2.tìm và trả về node cha có giá trị cuối cùng là value
        if (isEmpty()) {
            return null;
        }
        Node cur = head;
        while (cur.next != null) {
            if (cur.next.value == value) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    Node findNodeFirst(int value) {
        //1. tìm và trả về node đầu tiên có giá trị value
        //2. tìm và trả về node cuối cùng có giá trị value
        if (isEmpty()) {
            return null;
        }
        Node cur = head;
        while (cur != null) {
            if (cur.value == value) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    Node findNodeLast(int value) {
        if (isEmpty()) {
            return null;
        }
        if (head == tail) {
            return head;
        }
        Node cur = head;
        Node temp = head;
        while (cur != null) {
            if (cur.value == value) {
                temp = cur;
            }
            cur = cur.next;
        }

        if (temp != head) {
            return temp;
        } else {
            return null;
        }
    }

    // cho 1 cái linklist chứa 1 cái list object abc(String, int size)
    // đi tìm node mà có cái size lớn nhất và size nhỏ nhất sau đó đổi chỗ cho nhau
    // cho list đảo ngược list
    // cho list --> sort tất cả list theo tăng dần của x1, nếu x1 giống nnhau thì sort đến x2, ...
    // sort 10 phần tử đầu tiên theo quy luật trên
    // cho list sort tất cả phần tử theo thứ tự tăng dần của value
    void sort() {
        if (isEmpty()) {
            return;
        }
        if (head == tail) {
            return;
        }
        for (Node i = head; i.next != null; i = i.next) {
            for (Node j = i.next; j != null; j = j.next) {
                if (i.value > j.value) {
                    int temp = i.value;
                    i.value = j.value;
                    j.value = temp;

                }
            }
        }
    }

    public static void main(String[] args) {
        MyList my = new MyList();
        my.addFirst(1);
        my.addFirst(2);
        my.addFirst(3);
        my.addFirst(4);
        my.addFirst(5);
        my.addFirst(6);
        my.addLast(10);
        my.addLast(20);
        my.addLast(30);
        my.display();
        my.addIndex(100, 8);
        my.display();
        // my.deleteFirst(); 
        // my = new MyList();
        System.out.println("phan tu dau " + my.delFirst());
        my.display();
        System.out.println("phan tu last " + my.delLast());
        my.display();
        System.out.println("phan tu bi xóa ở index 2  là" + my.delIndex(2));
        my.sort();

        my.display();

        System.out.println("Cha của phần tử có index 2 là: " + my.findIndex(2).value);
    }
}
