#include <iostream>

using namespace std;


void countingSort(int inputArray[][2],int index,int range,int arrayLength){
    int outputArray[arrayLength][2];
    int cumulativeFrequency[range + 1];

    for (int i = 0; i <= range; i++) {
        cumulativeFrequency[i] = 0;
    }
    for (int i = 0; i < arrayLength; i++) {
        cumulativeFrequency[inputArray[i][index]]++;
    }
    for (int i = 1; i < range; i++){
        cumulativeFrequency[i] += cumulativeFrequency[i - 1];
    }
    for (int i = arrayLength - 1; i >= 0; i--) {
        outputArray[cumulativeFrequency[inputArray[i][index]] - 1][0] = inputArray[i][0];
        outputArray[cumulativeFrequency[inputArray[i][index]] - 1][1] = inputArray[i][1];
        cumulativeFrequency[inputArray[i][index]]--;
    }

    for (int i = 0; i < arrayLength; ++i){
        inputArray[i][0] = outputArray[i][0];
        inputArray[i][1] = outputArray[i][1];
    }
}

void radixSort(int cards[][2],int array_length){
    countingSort(cards,1,5,array_length);
    countingSort(cards,0,5,array_length);
}


int main(){
    int array_length;
    cin >> array_length;
    int cards[array_length][2];
    for (int i = 0; i < array_length; i++){
        string card_string = "";
        cin >> card_string;
        if ("X1" == card_string){
            cards[i][0] = 0;
            cards[i][1] = 0;
        } else if ("X2" == card_string){
            cards[i][0] = 0;
            cards[i][1] = 1;
        } else if ("X3" == card_string){
            cards[i][0] = 0;
            cards[i][1] = 2;
        } else if ("X4" == card_string){
            cards[i][0] = 0;
            cards[i][1] = 3;
        } else if ("X5" == card_string){
            cards[i][0] = 0;
            cards[i][1] = 4;
        } else if ("Y1" == card_string){
            cards[i][0] = 1;
            cards[i][1] = 0;
        } else if ("Y2" == card_string){
            cards[i][0] = 1;
            cards[i][1] = 1;
        } else if ("Y3" == card_string){
            cards[i][0] = 1;
            cards[i][1] = 2;
        } else if ("Y4" == card_string){
            cards[i][0] = 1;
            cards[i][1] = 3;
        } else if ("Y5" == card_string){
            cards[i][0] = 1;
            cards[i][1] = 4;
        } else if ("Z1" == card_string){
            cards[i][0] = 2;
            cards[i][1] = 0;
        } else if ("Z2" == card_string){
            cards[i][0] = 2;
            cards[i][1] = 1;
        } else if ("Z3" == card_string){
            cards[i][0] = 2;
            cards[i][1] = 2;
        } else if ("Z4" == card_string){
            cards[i][0] = 2;
            cards[i][1] = 3;
        } else if ("Z5" == card_string){
            cards[i][0] = 2;
            cards[i][1] = 4;
        }
    }
    
    radixSort(cards,array_length);

    for (int i = 0; i < array_length; i++) {
      int numberRepresentation = (cards[i][0] * 10) + cards[i][1];
      switch (numberRepresentation){
        case 0: cout << "X1"; break;
        case 1: cout << "X2"; break;
        case 2: cout << "X3"; break;
        case 3: cout << "X4"; break;
        case 4: cout << "X5"; break;
        case 10: cout << "Y1"; break;
        case 11: cout << "Y2"; break;
        case 12: cout << "Y3"; break;
        case 13: cout << "Y4"; break;
        case 14: cout << "Y5"; break;
        case 20: cout << "Z1"; break;
        case 21: cout << "Z2"; break;
        case 22: cout << "Z3"; break;
        case 23: cout << "Z4"; break;
        case 24: cout << "Z5"; break;
      }
      cout << " ";
    }
    return 0;
}