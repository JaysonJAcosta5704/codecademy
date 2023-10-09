/*
This program is a calculator created in Java using an object, 
an instance, and five methods.
This was done on December 24th, 2022 (12/24/2022)
This was done on Codecademy by Jayson Acosta
*/

public class Calculator{

    // Calculator constructor
    public Calculator(){
  
    }
  
    // Addition method
    public int add(int a, int b){
      int sum = a + b;
      System.out.println("The sum of " + a + " + " + b + " equals " + sum);
      return sum;
    }
  
    // Subtraction method
    public int subtract(int a, int b){
      int difference = a - b;
      System.out.println("The difference of " + a + " - " + b + " equals " + difference);
      return difference;
    }
  
    // Multiplication method
    public int multiply(int a, int b){
      int product = a * b;
      System.out.println("The product of " + a + " * " + b + " equals " + product);
      return product;
    }
  
    // Division method
    public int divide(int a, int b){
      int quotient = a / b;
      int remainder = a % b;
      System.out.println("The quotient of " + a + " / " + b + " equals " + quotient + " with a remainder of " + remainder);
      return quotient;
    }
  
    // Modulo (remainder) method
    public int modulo(int a, int b){
      int remainder = a % b;
      System.out.println("The modulo of " + a + " % " + b + " equals " + remainder);
      return remainder;
    }
  
    // Main method:
    public static void main(String[] args){
  
    // Instance of Calculator 
    Calculator myCalculator = new Calculator();
  
    // Addition
    myCalculator.add(5,7);
  
    // Subtraction
    myCalculator.subtract(45,11);
  
    // Multiplication
    myCalculator.multiply(5,7);
  
    // Division
    myCalculator.divide(45,5);
  
    // Modulo
    myCalculator.modulo(132, 24);
    }
  }