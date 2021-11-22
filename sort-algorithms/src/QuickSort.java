import java.util.Arrays;

public class QuickSort {

  private static int[] array = {100,-15,6,0,10,11,200,1};

  public static void main(String[] args) {
    quickSort(0,array.length - 1);
    System.out.println(Arrays.toString(array));
  }

  private static void quickSort(int startIndex, int endIndex) {
    if (startIndex < endIndex){
      int previousPivotIndex = partition(startIndex,endIndex);
      quickSort(startIndex,previousPivotIndex - 1);
      quickSort(previousPivotIndex + 1,endIndex);
    }
  }

  private static int partition(int startIndex, int endIndex) {
    int pivot = array[endIndex];
    int startOfLeftHalf = startIndex - 1;
    for (int startOfRightHalf = startIndex; startOfRightHalf < endIndex - 1; startOfRightHalf++) {
      if (array[startOfRightHalf] <= pivot){
        startOfLeftHalf++;
        swap(startOfLeftHalf,startOfRightHalf);
      }
    }
    swap(startOfLeftHalf + 1,endIndex);
    return startOfLeftHalf + 1;
  }

  private static void swap(int i,int j){
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}