class ComplexNumber {
    constructor() {

    }

    add(complexNumber1, complexNumber2){
        let resultComplexNumber = new ComplexNumber();
        resultComplexNumber.setReal(complexNumber1.getReal() + complexNumber2.getReal());
        resultComplexNumber.setImaginary(complexNumber1.getImaginary() + complexNumber2.getImaginary());
        return resultComplexNumber;
    }

    setReal(real){
        this.real = real;
    }

    setImaginary(imaginary){
        this.imaginary = imaginary;
    }

    getReal(){
        return this.real;
    }

    getImaginary(){
        return this.imaginary;
    }

    getNumber(){
        return `${this.real} + ${this.imaginary}i`;
    }
}

let complexClass = new ComplexNumber();

let num1 = new ComplexNumber();
num1.setReal(3);
num1.setImaginary(5);
let num2 = new ComplexNumber();
num2.setReal(10);
num2.setImaginary(20);

console.log('1st number:  ' + num1.getNumber());
console.log('2nd number:  ' + num2.getNumber());

console.log('result of sum:  ' + complexClass.add(num1,num2).getNumber());