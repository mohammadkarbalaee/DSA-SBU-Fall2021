const prompt = require("prompt-sync")();


let rowsQuantity;
let columnsQuantity;
let matrix = [];

function getRowAndColumn(){
    rowsQuantity = parseInt(prompt('how many rows does your matrix have?     '));
    columnsQuantity = parseInt(prompt('how many columns does your matrix have?     '));
    console.log('');
}

function getMatrix(){
    for (let i = 0; i < rowsQuantity; i++) {
        let newRow = Array.from([]);
        for (let j = 0; j < columnsQuantity; j++) {
            newRow.push(parseInt(prompt(`type in a${i + 1}${j + 1}:     `)));
        }
        matrix.push(newRow);
    }
}

function isNonZeroRow(rowIndex){
    for (let i = 0; i < columnsQuantity; i++) {
        if (matrix[rowIndex][i] !== 0){
            return true;
        }
    }
    return false;
}

function findFirstNonZeroIndex(rowIndex){
    for (let i = 0; i < columnsQuantity; i++) {
        if(matrix[rowIndex][i] !== 0){
            return i;
        }
    }
}

function divideByScaler(divisor,rowIndex){
    for (let i = 0; i < columnsQuantity; i++) {
        matrix[rowIndex][i] /= divisor;
    }
}

function multiplyThenAddTwoRows(mainRowIndex,targetRowIndex,coefficient){
    let mainRow = Array.from(matrix[mainRowIndex]);
    for (let i = 0; i < columnsQuantity; i++) {
        mainRow[i] = coefficient * mainRow[i];
        matrix[targetRowIndex][i] += mainRow[i];
    }
}


function transform(){
    for (let i = 0; i < rowsQuantity; i++) {
        if (isNonZeroRow(i)){
            let firstNonZeroIndex = findFirstNonZeroIndex(i);
            divideByScaler(matrix[i][firstNonZeroIndex],i);
            for (let j = i + 1; j < rowsQuantity; j++) {
                multiplyThenAddTwoRows(i,j,-matrix[j][firstNonZeroIndex]);
            }

            for (let j = i - 1; j >= 0; j--) {
                multiplyThenAddTwoRows(i,j,-matrix[j][firstNonZeroIndex]);
            }
        }
    }
    return matrix;
}

function showMatrix(){
    console.log('\nthe transformed  matrix: \n');
    for (let i = 0; i < rowsQuantity; i++) {
        if(matrix[i] === (-0)){
            console.log(0);
        } else {
            console.log(matrix[i]);
        }
    }
}


getRowAndColumn();
getMatrix();
transform();
showMatrix();
