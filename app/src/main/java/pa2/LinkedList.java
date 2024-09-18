package pa2;

/**
 * A sorted singly linked list of integers
 */
public class LinkedList {
    /**
     * A node in the linked list
     */
    public Node head;

    /**
     * Constructor
     * Initialize the linked list with a null head
     */
    public LinkedList() {
        this.head = null; 
    }

    /** 
     * Add a new node to the linked list 
     * so that the list remains sorted
     * @param value The value to add
     * @return void
     */
    public void add(int value) {
        Node newNode = new Node(value); 
        if (this.head == null || head.value >= value) {
            newNode.next = head; 
            this.head = newNode; 
        }
        else {
            Node current = head; 
            while (current.next != null && current.next.value < value){
                current = current.next; 
            }
            newNode.next = current.next; 
            current.next = newNode; 
        }
    }

    /**
     * Remove the first node with the given value
     * If the value is not found, do nothing
     * @param value The value to remove
     * @return void
     */
    public void remove(int value) {
        if (this.head == null){
            return;
        }
        if (this.head.value == value){
            this.head = this.head.next; 
        }
        Node current = head; 
        while (current.next != null && current.next.value != value) {
            current = current.next; 
        }
        if (current.next != null ){
            current.next = current.next.next;    
        }
        // if (current.next.next == null) {
        //     current.next = null; 
        // }
    }

    /**
     * Traverse the linked list RECURSIVELY and returns a string representation of the list
     * @param current
     * @return String
     */
    private String traverse(Node current){
        if (current == null){
            return ""; 
        }
        else{
            return current.value + " " + traverse(current.next);
        }
    }

    /**
     * Traverse the linked list and returns a string representation of the list
     * @return String
     */
    public String traverse(){
        return traverse(head);
    }

    /**
     * Traverse the linked list RECURSIVELY and 
     * returns the reverse string representation of the list
     * e.g. the linked list 1 -> 2 -> 3 -> 4 will be printed as 4 3 2 1
     * @return String
     */
    public String reverse(){
        return reverse(head);  
    }

    private String reverse(Node current) {
        if (current == null){
            return""; 
        }
        else{
            return reverse(current.next)+current.value+ " ";
        }
    }

    /**
     * Merges two sorted linked list and returns the 
     * merged linked list that is also sorted
     * @param list1 The first sorted linked list
     * @param list2 The second sorted linked list 
     * @return LinkedLists
     */
    
    public static LinkedList merge(LinkedList list1, LinkedList list2){
       LinkedList mergedList = new LinkedList();
       
       Node current1 = list1.head; 
       Node current2 = list2.head;

       while (current1 != null && current2 != null){
        if(current1.value < current2.value){
            mergedList.add(current1.value);
            current1 = current1.next; 
        }
        else{
            mergedList.add(current2.value);
            current2 = current2.next;
        }
       }
       while (current1 != null){
        mergedList.add(current1.value);
        current1 = current1.next;
       }
       while (current2 != null){
        mergedList.add(current2.value); 
        current2 = current2.next; 
       }
       return mergedList;
    }


    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list.traverse());
        list.remove(3);
        System.out.println(list.traverse());
    }
}