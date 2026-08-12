class LRUCache {

    public class Node {
        int key,value;
        Node prev, next;
        Node(int key,int value) {
            this.key = key;
            this.value = value;
        }
    }

    public class DoublyLinkedList {
        Node head;
        Node rear;

        void add(Node node) {
            if(head == null) {
                head = node;
                rear = node;
            } else {
                rear.next = node;
                node.prev = rear;
                rear = node;
            }
        }

        void remove(Node node) {
            if (node.prev != null) {
                node.prev.next = node.next;
            } else {
                head = node.next;
            }
            if (node.next != null) {
                node.next.prev = node.prev;
            } else {
                rear = node.prev;
            }
            node.prev = null;
            node.next = null;
        }

        void moveToRear(Node node) {
            if(node == rear) return;
            else {
                remove(node);
                add(node);
            }
        }
    }

    DoublyLinkedList list;
    Map<Integer, Node> map;
    int curr_length;
    int capacity;

    public LRUCache(int capacity) {
        this.list = new DoublyLinkedList();
        this.map = new HashMap<>();
        this.capacity = capacity;
        this.curr_length = 0;
    }

    public int get(int key) {
        Node node = map.get(key);
        if(node!= null) {
            list.moveToRear(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            list.moveToRear(node);
        } else {
            Node node = new Node(key,value);
            map.put(key,node);
            list.add(node);
            curr_length++;
            if(curr_length > capacity) {
                map.remove(list.head.key);
                list.remove(list.head);
                curr_length--;
            }
        }
    }
}
