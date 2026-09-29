//cs211 lab 1 FRI Linked Lists
import java.util.Scanner;

class Link {
    int data;
    Link next;

    Link(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    private Link first;

    public LinkedList() {
        first = null;
    }

    public void insert(int value) {
        Link newLink = new Link(value);

        if (first == null) {
            first = newLink;
            return;
        }

        Link current = first;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newLink;
    }

    public void display() {
        Link current = first;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println();
    }

    public Link getFirst() {
        return first;
    }

    public void setFirst(Link first) {
        this.first = first;
    }
}

//my code for singly-linked list palindrome checker
//NOTE: runs for the test cases given, but doesn't work for odd numbers
public class LinkedLists1
 {

    public static boolean isPalindrome(LinkedList list) 
    {
        Link head = list.getFirst();

        // empty list or one node
        if (head == null || head.next == null) 
        {
            return true;
        }

        // find middle using slow and fast pointers
        Link slow = head;
        Link fast = head;

        while (fast != null && fast.next != null) 
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse second half
        Link prev = null;
        Link current = slow;

        while (current != null) 
        {
            Link nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        // compare first half and reversed second half
        Link firstHalf = head;
        Link secondHalf = prev;

        while (secondHalf != null) 
        {
            if (firstHalf.data != secondHalf.data) 
            {   //not a palindrome, so return false
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        //is a palindrome, so return true
        return true;
    }

    public static void main(String args[]) {
        LinkedList list = new LinkedList();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter integers (separated by spaces, ending with 'a')");

        // Example input: 10 20 30 20 10 a
        while (scanner.hasNextInt()) {
            int value = scanner.nextInt();
            list.insert(value);
        }

        scanner.close();

        System.out.println(isPalindrome(list));
        // Output: true
    }
}

//test: 1,2,2,1 is true, 1,2 is false