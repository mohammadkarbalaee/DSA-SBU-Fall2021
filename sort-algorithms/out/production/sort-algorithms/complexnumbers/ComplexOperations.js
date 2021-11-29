class ComplexNumber {
    constructor() {

    }

    add(complexNumber1, complexNumber2){
        let resultComplexNumber = new ComplexNumber();
        resultComplexNumber.setReal(complexNumber1.getReal() + complexNumber2.getReal());
        resultComplexNumber.setImaginary([complexNumber1.getImaginary()[0] + complexNumber2.getImaginary()[0],'i']);
        return resultComplexNumber;
    }

    multiply(complexNumber1, complexNumber2){
        let resultComplexNumber = new ComplexNumber();
        let realReal = complexNumber1.getReal() * complexNumber2.getReal();
        let realImaginary = complexNumber1.getReal() * complexNumber2.getImaginary()[0];
        let imaginaryReal = complexNumber1.getImaginary()[0] * complexNumber2.getReal();
        let imaginaryImaginary = -1 * (complexNumber1.getImaginary()[0] * complexNumber2.getImaginary()[0]);
        resultComplexNumber.setReal(realReal + imaginaryImaginary);
        resultComplexNumber.setImaginary([realImaginary + imaginaryReal,'i'])
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
        return `${this.real} + ${this.imaginary[0]}${this.imaginary[1]}`;
    }
}

let complexClass = new ComplexNumber();

let num1 = new ComplexNumber();
num1.setReal(3);
num1.setImaginary([5,'i']);
let num2 = new ComplexNumber();
num2.setReal(10);
num2.setImaginary([20,'i']);

console.log('1st number:  ' + num1.getNumber());
console.log('2nd number:  ' + num2.getNumber());

console.log('result of sum:  ' + complexClass.add(num1,num2).getNumber());
console.log('result of multiply:  ' + complexClass.multiply(num1,num2).getNumber());