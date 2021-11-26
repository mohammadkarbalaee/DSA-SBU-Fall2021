#include <iostream>

using namespace std;

double findMedian(int array[],int subArrayLength,bool isLenthOdd){
double median = 0;
int middleIndex = (subArrayLength + 1) / 2;
    if (isLenthOdd){
        median = array[middleIndex];
    } else {
        median = (array[middleIndex] + array[middleIndex - 1]) / 2.0;
    }
    return median;
}

bool isOdd(int arrayLength){
    if (arrayLength % 2 == 0){
        return false;
    } else {
        return true;
    }
}

int main(){
    int arrayLength;
    cin >> arrayLength;
    int array[arrayLength];
    for (int i = 0; i < arrayLength; i++){
        cin >> array[i];
        for (int m = 0, j = i; m < j; m++, j--) {
        int minValue = array[m];
        int maxValue = array[m];
        int minimumIndex = m;
        int maximumIndex = m;
        for (int k = m; k <= j; k++) {
          if (array[k] > maxValue) {
            maxValue = array[k];
            maximumIndex = k;
          } else if (array[k] < minValue) {
            minValue = array[k];
            minimumIndex = k;
          }
        }
        swap(array[m], array[minimumIndex]);
        if (array[minimumIndex] == maxValue){
          swap(array[j], array[minimumIndex]);
        } else {
          swap(array[j], array[maximumIndex]);
        }
      }
      cout << findMedian(array,i,isOdd(i + 1));
    }

    return 0;
}