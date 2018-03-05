package main.questions;


/**
 * @author radhikakalaiselvan
 *Created my own linkedList, since I need a method to find the next node given a node object.
 *
 */
public class RandomAccessArrayDeque {
	public class Node{
		int index;
		int value;
		Node next;
		Node(int value,int index){
			this.index=index;
			this.value=value;
			this.next=null;
		}

		Node(int value,Node next,int index){
			this.value=value;
			this.next=next;
			this.index=index;
		}
	}
	int maxSize=0;
	Node head=null;
	int currentSize=0;
	Node tailNode=null;

	RandomAccessArrayDeque(int size){
		this.maxSize=size;
	}
	Node insert(int num,int index){
		Node removedHead=null;
		Node newNode=new Node(num,index);
		if(head==null){
			head=newNode;
		}
		if(tailNode==null){
			tailNode=newNode;
		}else{
			tailNode.next=newNode;
			tailNode=newNode;
		}

		currentSize++;
		if(currentSize>maxSize){
			removedHead=head;
			head=head.next;
			currentSize--;
		}
		return removedHead;
	}

	Node findNext(Node n){
		return n.next;
	}

	Node getEndNode(){
		return tailNode;
	}

	void printDeque(){
		Node n=head;
		while(n!=null){
			System.out.println(n.value);
			n=n.next;
		}
	}
}
