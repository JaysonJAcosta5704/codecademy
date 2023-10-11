import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      System.out.println("\nWhat is your name? ");
      String customerName = input.nextLine();

      int money = 0;
      boolean validInput = false;
      while(!validInput) {
        System.out.println("\nWhat is your starting money? ");
        try {
          money = input.nextInt();
          if (money <= 0){
            throw new InputMismatchException();
          }
          validInput = true;
        } catch (InputMismatchException e){
          System.out.println("Invalid input. Please enter a positive integer.");
          input.nextLine();
        } catch (Exception e){
          System.out.println("something went wrong. Please try again: ");
          input.nextLine();
        }
      }
      Customer customer = new Customer(customerName, money);
        TakeOutSimulator takeOutSimulator = new TakeOutSimulator(customer, input);
        takeOutSimulator.startTakeOutSimulator();
      }
    }
