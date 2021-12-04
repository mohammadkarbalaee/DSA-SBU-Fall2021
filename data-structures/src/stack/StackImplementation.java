package stack;

import java.util.NoSuchElementException;

public class StackImplementation {
  public static void main(String[] args) {
    Stack<Integer> myStack = new Stack<>(10);
    myStack.push(25);
    myStack.push(50);
    System.out.println(myStack.pop());
  }
}

class Stack<T>{
  private final T[] array;
  private int top = -1;

  Stack(int arrayLength){
    this.array = (T[]) new Object[arrayLength];
  }

  public boolean isStackEmpty(){
    return this.top == -1;
  }

  public void push(T element){
    this.top++;
    array[this.top] = element;
  }

  public T pop() throws NoSuchElementException {
    if (isStackEmpty()){
      throw new NoSuchElementException("stack is already empty");
    } else {
      this.top--;
      return this.array[this.top + 1];
    }
  }
}