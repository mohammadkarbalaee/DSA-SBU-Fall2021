package stack;

import java.util.NoSuchElementException;

public class StackImplementation {
  public static void main(String[] args) {
    Stack<Integer> ourStack = new Stack<>(10);
    ourStack.push(25);
    ourStack.push(50);
    System.out.println(ourStack.pop());
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