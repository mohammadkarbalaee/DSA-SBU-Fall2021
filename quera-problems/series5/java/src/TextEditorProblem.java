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
    if (newCharacter.equals('-')  || newCharacter.equals('>') || newCharacter.equals('<')){
      return true;
    } else {
      return false;
    }
  }

  private void insertNewCharacter(char newCharacter){
    this.editedText.add(this.cursor,newCharacter);
  }

  public String getEditedString(){
    StringBuilder finalString = new StringBuilder();
    for (int i = 0; i < this.editedText.size(); i++) {
      finalString.append(this.editedText.get(i).data);
    }
    if (finalString.toString().isEmpty()){
      return "-1";
    } else {
      return finalString.toString();
    }
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
  private int length = 0;

  public Node<T> get(int wantedNodeIndex){
    Node<T> wantedNode = this.headNode;
    int currentIndex = 0;
    while (wantedNode != null && wantedNodeIndex != currentIndex){
      wantedNode = wantedNode.nextNode;
      currentIndex++;
    }
    return wantedNode;
  }

  public void add(int indexToInsertAt,T newData){
    Node<T> currentNode;
    Node<T> newNode = new Node<>(null,newData,null);
    if (indexToInsertAt == this.length && indexToInsertAt != 0) {
      currentNode = this.get(indexToInsertAt - 1);
      newNode.nextNode = null;
      newNode.previousNode = currentNode;
      currentNode.nextNode = newNode;
    } else if(indexToInsertAt == 0) {
      if (this.headNode == null){
        this.headNode = newNode;
      } else {
        newNode.nextNode = this.headNode;
        this.headNode.previousNode = newNode;
        newNode.previousNode = null;
        this.headNode = newNode;
      }
    } else {
      currentNode = this.get(indexToInsertAt);
      if (currentNode != null){
        if (currentNode.previousNode != null) {
          newNode.nextNode = currentNode;
          newNode.previousNode = currentNode.previousNode;
          currentNode.previousNode.nextNode = newNode;
          currentNode.previousNode = newNode;
        }
      }
    }
    this.length++;
  }

  public void remove(int indexToRemove){
    Node<T> currentNode = this.get(indexToRemove);
    if (currentNode != null){
      if (currentNode.previousNode != null){
        if (currentNode.nextNode != null){
          currentNode.previousNode.nextNode = currentNode.nextNode;
          currentNode.nextNode.previousNode = currentNode.previousNode;
        } else {
          currentNode.previousNode.nextNode = null;
        }
      } else {
        if (this.headNode.nextNode != null){
          this.headNode.nextNode.previousNode = null;
          this.headNode = this.headNode.nextNode;
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