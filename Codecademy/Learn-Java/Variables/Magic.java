public class Magic {
	public static void main(String[] args) {

    //Variable Declarations
    int myNumber = 24;    //original number
    int stepOne = myNumber * myNumber;
    int stepTwo = stepOne + myNumber;
    int stepThree = stepTwo / myNumber;
    int stepFour = stepThree + 17;
    int stepFive = stepFour - myNumber;
    int stepSix = stepFive / 6;

    //Print statements
    System.out.println(stepSix);
	}
}