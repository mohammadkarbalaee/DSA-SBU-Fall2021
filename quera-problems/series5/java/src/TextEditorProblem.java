public class TextEditorProblem {
  public static void main(String[] args) {
//    Scanner input = new Scanner(System.in);
//    String text = input.next();
//    TextEditor textEditor = new TextEditor();
//    for (int i = 0; i < text.length(); i++) {
//      textEditor.getNewCharacter(text.charAt(i));
//    }
//    System.out.println(textEditor.getEditedString());
    LinkedList<Character> myList = new LinkedList<>();
//    myList.insertAt(new Node<>(null,'a',null));
//    myList.insertAt(new Node<>(null,'b',null));
//    myList.insertAt(new Node<>(null,'c',null));
//    myList.insertAt(new Node<>(null,'d',null));
//    System.out.println(myList.getNodeAt(0).data);
    myList.add(0,'a');
    myList.add(0,'b');
    myList.add(1,'c');
    myList.remove(1);
    System.out.println(myList.get(0).data);
    System.out.println(myList.get(1).data);
  }
}

//class TextEditor{
//
//  private LinkedList<Character> editedText;
//  private int cursor;
//
//  public TextEditor(){
//    this.editedText = new LinkedList<>();
//    this.cursor = -1;
//  }
//
//  public void getNewCharacter(Character newCharacter){
//    if (isCommand(newCharacter)){
//      if (newCharacter.equals('-')){
//        deleteCharAtCursor();
//      } else if(newCharacter.equals('>')){
//        if (this.cursor < (this.editedText.size() - 1)){
//          this.cursor++;
//        }
//      } else if (newCharacter.equals('<')){
//        if (this.cursor > -1){
//          this.cursor--;
//        }
//      }
//    } else {
//      this.cursor++;
//      insertNewCharacter(newCharacter);
//    }
//  }
//
//  private void deleteCharAtCursor() {
//    if (this.cursor != -1){
//      this.editedText.remove(this.cursor);
//      this.cursor--;
//    }
//  }
//
//  private boolean isCommand(Character newCharacter){
//    if (newCharacter.equals('-')  || newCharacter.equals('>') || newCharacter.equals('<')){
//      return true;
//    } else {
//      return false;
//    }
//  }
//
//  private void insertNewCharacter(char newCharacter){
//    this.editedText.add(this.cursor,newCharacter);
//  }
//
//  public String getEditedString(){
//    StringBuilder finalString = new StringBuilder();
//    for (int i = 0; i < this.editedText.size(); i++) {
//      finalString.append(this.editedText.get(i));
//    }
//    if (finalString.toString().isEmpty()){
//      return "-1";
//    } else {
//      return finalString.toString();
//    }
//  }
//}



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
    Node<T> currentNode = this.get(indexToInsertAt);
    Node<T> newNode = new Node<>(null,newData,null);
    if (currentNode != null){
      if (currentNode.previousNode != null){
        newNode.nextNode = currentNode;
        newNode.previousNode = currentNode.previousNode;
        currentNode.previousNode.nextNode = newNode;
        currentNode.previousNode = newNode;
      } else {
        newNode.nextNode = this.headNode;
        this.headNode.previousNode = newNode;
        newNode.previousNode = null;
        this.headNode = newNode;
      }
    } else {
      this.headNode = newNode;
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

  int length(){
    return this.length;
  }
}