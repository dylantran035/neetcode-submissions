class MyLinkedList {
    private ListNode head;
    private ListNode tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    
    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        ListNode current;

        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        }
        else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current.val;
    }
    
    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head;
        if (head != null) {
            head.prev = newNode;
        }
        else {
            tail = newNode;
        }
        head = newNode;
        size++;
    }
    
    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);
        newNode.prev = tail;
        if (tail != null) {
            tail.next = newNode;
        }
        else {
            head = newNode;
        }
        tail = newNode;
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if (index > size || index < 0) return;
        if (index <= 0) {
            addAtHead(val);
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        }

        ListNode prev = getNode(index - 1);
        ListNode newNode = new ListNode(val);
        ListNode next = prev.next;

        prev.next = newNode;
        newNode.prev = prev;
        newNode.next = next;
        next.prev = newNode;
        size++;
    }

    public ListNode getNode(int index) {
        if (index < 0 || index >= size) return null;
        ListNode current;

        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        }
        else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current;
    }
    
    public void deleteAtIndex(int index) {
        if (index >= size || index < 0) return;
        ListNode delNode = getNode(index);
        ListNode nextNode = delNode.next;
        ListNode prevNode = delNode.prev;

        if (prevNode != null) { prevNode.next = nextNode; }
        else { head = nextNode; }

        if (nextNode != null) { nextNode.prev = prevNode; }
        else { tail = prevNode; }
        size--;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode prev;

    ListNode(int val) {
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */