import java.util.LinkedList;
import java.util.Scanner;

public class TextEditorProblem {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String text = input.next();
    TextEditor textEditor = new TextEditor();
    for (int i = 0; i < text.length(); i++) {
      textEditor.getNewCharacter(text.charAt(i));
    }
    System.out.println(textEditor.getEditedString());
  }
}

class TextEditor{

  private LinkedList<Character> editedText;
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
      finalString.append(this.editedText.get(i));
    }
    if (finalString.toString().isEmpty()){
      return "-1";
    } else {
      return finalString.toString();
    }
  }
}