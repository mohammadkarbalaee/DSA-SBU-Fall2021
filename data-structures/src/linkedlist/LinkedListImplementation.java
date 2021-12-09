package linkedlist;

public class LinkedListImplementation {
  public static void main(String[] args) {
    LinkedList<Integer> ourLinkedList = new LinkedList<>();
    CircularLinkedList<Integer> ourCircularLinkedList = new CircularLinkedList<>();
    Node<Integer> newNode = new Node<>(null,10,null);
    ourLinkedList.insert(newNode);
    ourLinkedList.delete(newNode);
    ourLinkedList.insert(newNode);
    ourLinkedList.insert(new Node<>(null,20,null));
    ourLinkedList.insert(new Node<>(null,30,null));
    ourLinkedList.insert(new Node<>(null,40,null));
    ourLinkedList.insert(new Node<>(null,50,null));
    ourLinkedList.insert(new Node<>(null,60,null));
    ourLinkedList.insert(new Node<>(null,70,null));
    ourLinkedList.insert(new Node<>(null,80,null));
    ourLinkedList.insert(new Node<>(null,90,null));
    ourLinkedList.insert(new Node<>(null,100,null));
    ourLinkedList.printAllNodes();
    System.out.println();

    Node<Integer> newNodeCircular = new Node<>(null,10,null);
    ourCircularLinkedList.insert(newNodeCircular);
    ourCircularLinkedList.insert(newNodeCircular);
    ourCircularLinkedList.insert(new Node<>(null,20,null));
    ourCircularLinkedList.insert(new Node<>(null,30,null));
    ourCircularLinkedList.insert(new Node<>(null,40,null));
    ourCircularLinkedList.insert(new Node<>(null,50,null));
    ourCircularLinkedList.insert(new Node<>(null,60,null));
    ourCircularLinkedList.insert(new Node<>(null,70,null));
    ourCircularLinkedList.insert(new Node<>(null,80,null));
    ourCircularLinkedList.insert(new Node<>(null,90,null));
    ourCircularLinkedList.insert(new Node<>(null,100,null));
    System.out.println(ourCircularLinkedList.search(10).data);
  }
}

class Node<T>{
  public T data;
  public Node<T> previousNode;
  public Node<T> nextNode;

  Node(Node<T> previousNode,T data,Node<T> nextNode){
    this.previousNode = previousNode;
    this.data = data;
    this.nextNode = nextNode;
  }
}

class LinkedList<T>{
  public Node<T> headNode = null;

  public Node<T> search(T wantedData){
    Node<T> wantedNode = this.headNode;
    while (wantedNode != null && wantedNode.data != wantedData){
      wantedNode = wantedNode.nextNode;
    }
    return wantedNode;
  }

  public void insert(Node<T> newNode){
    newNode.nextNode = this.headNode;
    if (this.headNode != null){
      this.headNode.previousNode = newNode;
    }
    newNode.previousNode = null;
    this.headNode = newNode;
  }

  public void delete(Node<T> nodeToDelete){
    if (nodeToDelete.previousNode != null){
      nodeToDelete.previousNode.nextNode = nodeToDelete.nextNode;
    } else {
      this.headNode = nodeToDelete.nextNode;
    }
    if (nodeToDelete.nextNode != null){
      nodeToDelete.nextNode.previousNode = nodeToDelete.previousNode;
    }
  }

  public void printAllNodes(){
    Node<T> walkingHead = this.headNode;
    while (walkingHead != null){
      System.out.print(walkingHead.data + " ");
      walkingHead = walkingHead.nextNode;
    }
  }
}

class CircularLinkedList<T> extends LinkedList<T>{

  Node<T> nullNode = new Node<>(null,null,null);

  @Override
  public Node<T> search(T wantedData){
    Node<T> wantedNode = this.nullNode.nextNode;
    while (wantedNode != this.nullNode && wantedNode.data != wantedData){
      wantedNode = wantedNode.nextNode;
    }
    return wantedNode;
  }

  @Override
  public void insert(Node<T> newNode){
    newNode.nextNode = this.nullNode.nextNode;
    this.nullNode.previousNode = newNode;
    this.nullNode.nextNode = newNode;
    newNode.previousNode = this.nullNode;
  }

  @Override
  public void delete(Node<T> nodeToDelete){
    nodeToDelete.previousNode.nextNode = nodeToDelete.nextNode;
    nodeToDelete.nextNode.previousNode = nodeToDelete.previousNode;
  }

  @Override
  public void printAllNodes(){
    Node<T> walkingHead = this.nullNode.nextNode;
    while (walkingHead != this.nullNode){
      System.out.print(walkingHead.data + " ");
      walkingHead = walkingHead.nextNode;
    }
  }
}