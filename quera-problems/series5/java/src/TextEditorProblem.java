import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TextEditorProblem {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer input = new StringTokenizer(br.readLine());
    String text = input.nextToken();
    TextEditor textEditor = new TextEditor();
    for (int i = 0; i < text.length(); i++) {
      textEditor.getNewCharacter(text.charAt(i));
    }
    System.out.println(textEditor.getEditedString());
  }
}

class TextEditor{

  private final LinkedList<Character> editedText;
  private int cursor;

  public TextEditor(){
    this.editedText = new LinkedList<>();
    this.cursor = -1;
  }

  public void getNewCharacter(Character newCharacter){
    if (isCommand(newCharacter)){
      if (newCharacter.equals('-')){
        deleteCharAtCursor();
      } else if(newCharacter.equals('>')){
        if (this.cursor < (this.editedText.size() - 1)){
          this.cursor++;
        }
      } else if (newCharacter.equals('<')){
        if (this.cursor > -1){
          this.cursor--;
        }
      }
    } else {
      this.cursor++;
      insertNewCharacter(newCharacter);
    }
  }

  private void deleteCharAtCursor() {
    if (this.cursor != -1){
      this.editedText.remove(this.cursor);
      this.cursor--;
    }
  }

  private boolean isCommand(Character newCharacter){
    return newCharacter.equals('-') || newCharacter.equals('>') || newCharacter.equals('<');
  }

  private void insertNewCharacter(char newCharacter){
    this.editedText.add(this.cursor,newCharacter);
  }

  public String getEditedString(){
    StringBuilder finalString = new StringBuilder();
    for (int i = 0; i < this.editedText.size(); i++) {
      finalString.append(this.editedText.get(i).getData());
    }
    if (finalString.toString().isEmpty()){
      return "-1";
    } else {
      return finalString.toString();
    }
  }
}

class Node<T>{
  private T data;
  private Node<T> previousNode;
  private Node<T> nextNode;

  Node(Node<T> previousNode,T data,Node<T> nextNode){
    this.previousNode = previousNode;
    this.data = data;
    this.nextNode = nextNode;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public Node<T> getPreviousNode() {
    return previousNode;
  }

  public void setPreviousNode(Node<T> previousNode) {
    this.previousNode = previousNode;
  }

  public Node<T> getNextNode() {
    return nextNode;
  }

  public void setNextNode(Node<T> nextNode) {
    this.nextNode = nextNode;
  }
}

class LinkedList<T>{
  private Node<T> headNode = null;
  private Node<T> tailNode = null;
  private int length = 0;

  public Node<T> get(int wantedNodeIndex){
    int middle = this.length / 2;
    Node<T> wantedNode;

    if (wantedNodeIndex > middle){
      wantedNode = this.tailNode;
      int currentIndex = this.length - 1;
      while (wantedNode != null && wantedNodeIndex != currentIndex){
        wantedNode = wantedNode.getPreviousNode();
        currentIndex--;
      }
    } else {
      wantedNode = this.headNode;
      int currentIndex = 0;
      while (wantedNode != null && wantedNodeIndex != currentIndex){
        wantedNode = wantedNode.getNextNode();
        currentIndex++;
      }
    }
    return wantedNode;
  }

  public void add(int indexToInsertAt,T newData){
    Node<T> currentNode;
    Node<T> newNode = new Node<>(null,newData,null);
    if (indexToInsertAt == this.length && indexToInsertAt != 0) {
      newNode.setNextNode(null);
      newNode.setPreviousNode(this.tailNode);
      this.tailNode.setNextNode(newNode);
      this.tailNode = newNode;
    } else if(indexToInsertAt == 0) {
      if (this.headNode == null){
        this.headNode = newNode;
        this.tailNode = this.headNode;
      } else {
        newNode.setNextNode(this.headNode);
        this.headNode.setPreviousNode(newNode);
        newNode.setPreviousNode(null);
        this.headNode = newNode;
      }
    } else {
      currentNode = this.get(indexToInsertAt);
      if (currentNode != null){
        if (currentNode.getPreviousNode() != null) {
          newNode.setNextNode(currentNode);
          newNode.setPreviousNode(currentNode.getPreviousNode());
          currentNode.getPreviousNode().setNextNode(newNode);
          currentNode.setPreviousNode(newNode);
        }
      }
    }
    this.length++;
  }

  public void remove(int indexToRemove){
    if (indexToRemove == this.length - 1) {
      if (this.headNode == this.tailNode) {
        this.headNode = null;
        this.tailNode = null;
      } else {
        this.tailNode.getPreviousNode().setNextNode(null);
        this.tailNode = this.tailNode.getPreviousNode();
      }
      this.length--;
      return;
    }
    Node<T> currentNode = this.get(indexToRemove);
    if (currentNode != null){
      if (currentNode.getPreviousNode() != null){
        if (currentNode.getNextNode() != null){
          currentNode.getPreviousNode().setNextNode(currentNode.getNextNode());
          currentNode.getNextNode().setPreviousNode(currentNode.getPreviousNode());
        }
      } else {
        if (this.headNode.getNextNode() != null){
          this.headNode.getNextNode().setPreviousNode(null);
          this.headNode = this.headNode.getNextNode();
        } else {
          this.headNode = null;
        }
      }
    }
    this.length--;
  }

  int size(){
    return this.length;
  }
}