/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DemoTree;

/**
 *
 * @author Fpt
 */
public class MyBSTree {

    Node root;

    public MyBSTree() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    void insert(Car c) {
        Node node = new Node(c);// node mới sẽ được gán vào cây
        if (isEmpty()) {
            root = node;
        } else {
            // ta đi tìm node (cha của node can add)
            Node cu = root;
            Node father = null;
            while (cu != null) { // duyệt cho đến khi có node rỗng và nằm đúng vị trí
                if (cu.infor.price == c.price) {
                    System.out.println("Key: " + c.price + "da ton tai");
                    return;
                }
                father = cu; // nếu cu ko phải node cần tìm nó sẽ được gán làm cha và duyệt các node sau
                if (cu.infor.price > c.price) {// duyệt qua cây nếu giá trị curent lớn hơn c cần tìm duyệt sang left không thì sang right
                    cu = cu.left;
                } else {
                    cu = cu.right;
                }
            }
            if (father.infor.price > c.price) {
                father.left = node; // duyệt đến thg cha của nó và xét giá trị
            } else {
                father.right = node;
            }

        }
    }

    void visit(Node p) { // in ra node
        if (p == null) {
            return;
        }
        System.out.print(p.infor + ",");
    }

    void preOrder(Node p) { // đệ quy lần lượt từ cha đến con từ trái sang phải
        if (p == null) {
            return;
        }
        visit(p); // gặp node nào in node đấy ra trước
        preOrder(p.left);
        preOrder(p.right);
    }

    void preOrder() {
        preOrder(root);// duyệt bắt đầu từ gốc
    }

    void postOrder(Node p) {
        if (p == null) {
            return;
        }
        postOrder(p.left);
        postOrder(p.right);
        visit(p); // gặp lần cuối thì in ra   
    }

    void postOrder() {
        postOrder(root);
    }

    void inOrder(Node p) {
        if (p == null) {
            return;
        }
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }

    void inOrder() {
        inOrder(root);
    }
    
    public Node findFather(int Key){// tìm và trả về node cha của node mà có key bằng input, nếu ko tìm thấy thì trả về null
        Node cu = root;
        Node father = null;
        while(cu != null){
            if(cu.infor.price == Key){
                return father;
            }
            father = cu;
            if(cu.infor.price > Key) cu = cu.left;
            else cu = cu.right;
        }
        
        return null;
    }
    
    public Node search(int Key){
        // tìm và trả về Node có price = 
        Node cu = root;
        while(cu != null){
            if(cu.infor.price == Key){
                return cu;
            }
            if(cu.infor.price > Key) cu = cu.left;
            else cu = cu.right;
        }
        return null;
    }
    
    void breath_first(Node pp){ // duyệt theo chiều rộng
        if(pp == null) return;
        // xây dựng 1 cái queue, mà ở đó value chính là Node Tree
        MyQueue my = new MyQueue();
        my.EnQueue(pp);
        while(!my.isEmpty()){
            Node p = my.Dequeue();
            if(p.left != null){
                my.EnQueue(p.left);
                
            }
            if(p.right != null){
                my.EnQueue(p.right);
            }
            visit(p);
        }
        
    }
    
    void breath_first(){
        breath_first(root);
    }
    
    void deleteByCopyLeft(Node p){
        // xóa bỏ node có price = key
        if(p == null || p.left == null) return; // không node nào được xóa bỏi copying
        // ta tìm giá trị có giá trị ngoài cùng bên phải của con bên trái
        if(p.left.right == null){// con bên trái chính là giá trị ngoài cùng bên phải của nó
            p.infor = p.left.infor;
            p.left = p.left.left;
            return;
        }
        Node cu = p.left.right;
        Node father = p.left;
        while(cu.right != null){// đi tìm node ngoài cùng bên phải của con trái
            father = cu;
            cu = cu.right;
        }
        p.infor = cu.infor;
        father.right = null;// xóa bỏ node ngoài cùng bên phải của con trái 
    }

    void deleteByCopying(int key){
        Node p = search(key);
        deleteByCopyLeft(p);
    }
 
    void deleteByCopyingRight(Node p) {

        if (p == null || p.right == null) {
            return;
        }
        if (p.right.right == null) {
            p.right = p.right.left;
        } else {
            Node father = p.right;
            Node cur = p.right.right;
            while (cur.right != null) {
                father = cur;
                cur = cur.right;
            }
            p.right.infor = cur.infor;
            father.right = cur.left;
        }

    }

    void deleteByMergingLeft(Node p) {
        if (p == null || p.left == null) {
            return;
        }
        // đi tìm node ngoai ben phai cua con ben trai  
        Node father = findFather(p.infor.price);// nếu mà father == null -> Node p chính là root
        Node cu = p.left;
        while (cu.right != null) {
            cu = cu.right;
        }
        cu.right = p.right;
        if (father == null) {
            root = root.left;
        } else{
            if(father.infor.price < p.infor.price){// node cần xóa nằm bên phải của node cha
                father.right = p.left;
                    
            } else{
                father.left = p.left;
            }
        }
    }
    
    void deleteByMergingRight(Node p){
        
    }
    
    void deleteByMerging(int key){
        Node p = search(key);
        deleteByMergingLeft(p);
    }
    Node leftRotate(Node p){
        return null;
    }
    
    Node rightRotate(Node p){
        if(p == null || p.left == null){
            return p;
        }
        Node c = p.left;
        Node temp = c.right;
        c.right = p;
        p.left = temp;
        return c;
        
    }
    
    void leftRotate(int key){
        
    }
    
//    Node parent(Node ch) {
//        if (ch == root || ch == null) {
//            return null;
//        }
//        Node p = root;
//        Node parent = null;
//        while (p != null) {
//            if (p.info.type == ch.info.type) {
//                break;
//            }
//            parent = p;
//            if (p.info.type > ch.info.type) {
//                p = p.left;
//            } else {
//                p = p.right;
//            }
//        }
//        return parent;
//    }
//     void rotateLeft(Node par) {
//        if (par == null || par.right == null) {
//            return;
//        }
//        Node ch = par.right;
//        par.right = ch.left;
//        ch.left = par;
//        if (parent(par) == null) {
//            root = ch;
//            return;
//        }
//        if (parent(par).left == par) {
//            parent(par).left = ch;
//        } else {
//            parent(par).right = ch;
//        }
//    }
    
    void rightRotate(int key){
        Node p = search(key);
        if(p == null || p.left == null) return;
        Node f = findFather(key);
        Node afterRotate = rightRotate(p);
        if(f == null){
            root = afterRotate;
                
        } else{
            if(f.left.infor.price == key) f.left = afterRotate; 
            else f.right = afterRotate;
        }
        
    }
}

class Main {

    public static void main(String[] args) {
        MyBSTree t = new MyBSTree();
        t.insert(new Car("A", 8));
        t.insert(new Car("A", 4));
        t.insert(new Car("A", 12));
        t.insert(new Car("A", 2));
        t.insert(new Car("A", 6));
        t.insert(new Car("A", 10));
        t.insert(new Car("A", 14));
        t.insert(new Car("A", 1));
        t.insert(new Car("A", 3));
        t.insert(new Car("A", 5));
        t.insert(new Car("A", 7));
        t.insert(new Car("A", 7));
        t.insert(new Car("A", 9));
        t.insert(new Car("A", 11));
        t.insert(new Car("A", 13));
        t.insert(new Car("A", 15));
        //t.deleteByCopying(4);
        t.rightRotate(12);
        //t.deleteByMerging(4);
        t.preOrder();
        System.out.println("");
        t.postOrder();
        System.out.println("");
        t.inOrder();
        System.out.println("");
        t.breath_first();
        System.out.println("");
        t.root.left.infor.name = "B";
        t.breath_first();
        System.out.println("");
        
    }
}
// cây nhị phân tìm kiếm BSTree (BSTree) binary tree là cây nhị phân mà giá trị node con trái < parent < giá node bên phải (không có bằng, giá trị key trong cây là duy nhất)
// nếu con phải empty thì không tính

/*
    Tại sao lại có cây nhị phân, ứng dụng cây nhị phân
    Đối với cấc bài toán về tìm kiếm thì linklisst không giải quyết tốt vì nó tìm kiếm tuần tự
    do đó độ phức tạp thuật toán là O(n)
    nếu dùng mảng mà sắp xếp thì chúng ta có thể áp dụng thuật toán tìm kiếm nhị phân --> độ phức tạp thuật toán là O(log(n)), tuy nhiên trước khi tìm kiếm dữ liệu cần phải sort
    ---> độ phức tạp thuật toán là O(n.log(n)), nếu như quâ trình vận hành muốn thay đổi dữ liệu thêm vào , xóa đi, .. ta phải mất O(n) đồng thời phải mất O(n.log(n)) đẻ sort lại
    --> đối với các bài toán dữ liệu tĩnh khoogn thay đổi trong suốt quá trình tồn tại thì ta có thể dùng mảng và sort 1 lần để tìm kiếm
    Tuy nhiên loại bài toán ấy gần như ko tốn tại nên 
    Bài toán dữ liệu nặng về tìm kiếm nhưng vẫn có thể thay đổi thăng giáng dữ liệu --> dùng mảng sẽ ko tốt -->  chậm ở các thao tác xóa thêm O(n) và sort O(n.logn)

    --> để giải quyết bài toán này --> ta dùng BSTree
    BSTree sinh ra để tìm kiếm, tìm kiếm O(logn), thêm vào và xóa đi cũng là O(logn), ko cần sort vì nó có quy luật khi thêm vào hoặc xóa
    khi thêm/xóa phải luôn đảm bảo cái tree không bị phá vỡ cấu trúc BSTree, cũng khá phức tạp

    Insert/ search / duyệt 
    với BSTree thì khoogn có update
    Tại sao BSTree lại ko có update? Chúng ta chỉ có thể update thông tin khác chứ không thể update thông tin về key vì có thể phá vỡ cấu trúc cây nhị phân. trong bs tree key là duy nhất việc update tương đương với delete -> insert cái mới
    
    Làm thế nào để delete node trong tree mà vẫn đảm bảo được cấu trúc cây nhị phân
    Nếu mà node cần xóa là leaf(external node) tìm cha của nó cho father.left = null hoặc father.right = null
    Nếu mà node cần xóa là internal node, nhưng nó chỉ có 1 con, thì lấy con của node cần xóa thế vào vị trí của node cần xóa, hay nói đơn giản lấy ông cưu mang trục cháu
    
    Làm thế nào để xóa 1 node có 2 con nhưng vẫn đảm bảo cây nhị phân
    Có 2 cách làm 
    Cách 1: delete by Copying(lấy thằng giàu nhất nhánh nghèo hoặc thằng nghèo nhất nhánh giàu) --> chuyển về bài toán có 1 hoặc ko có con
    Đi tìm giá trị ngoài cùng bên phải của con bên trái của node cần xóa rồi copy vào vị trí cần xóa sau đó xóa bỏ giá trị ngoài cùng bên phải của con bên trái(giá trị vừa mang đi copy) -- thay bằng thằng lớn nhất
    (delete by copying con trái(mặc định của PE và FE nếu như không nói gì)
    Delete by copying con phải
    Đi tìm giá trị ngoài bên trái của con bên phải node cần xóa, copy node vào vị trí cần xóa và xóa bỏ phần tử vừa tìm 
    
    Cách 2: Delete by Merging(left, right)
left:
    Lấy toàn bộ con bên phải của node cần xóa rồi gán vào bên phải của node ngoài cùng bên phải của con bên trái, sau đó tôn con trái lên làm cha
right:
    Lấy toàn bộ con bên trái của node cần xóa gán vào bên trái của node ngoài cùng bên trái của con bên phải, sau đó tôn con phải lên làm cha
Ý nghĩa của việc delete by copying and merging?
+) Đối với delete by copying (nhẹ nhàng) đảo chính trong êm đẹp(gần như mọi vị trí không thay đổi chỉ có duy nhất node copy thay đổi) --> độ cao tree kko đổi cùng lắm giảm 1 đơn vị
+) Đối với delete by merging (thay đổi lớn) có thể rất nhiều vị trí bị thay đổi --> độ cao của cây có thể thay đổi rất nhiều

*/
