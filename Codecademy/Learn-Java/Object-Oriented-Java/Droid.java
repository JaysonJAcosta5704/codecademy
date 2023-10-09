public class Droid{
    String name;
    int batteryLevel = 100;
  
    //Objects
      public Droid(String droidName){
        name = droidName;
      }
  
    // Methods
      // Performing a task
      public void performTask(String task){
        batteryLevel = batteryLevel - 10;
        System.out.println("The drone " + name + " is performing the task " + task + " right now! Current battery level: " + batteryLevel +"%");
        System.out.println();
      }
  
  
      // Stating battery level
      public void currentBattery(){
        System.out.println("The current battery level of the drone " + name + " is " + batteryLevel + "%");
        System.out.println();
      }
  
      // To String
      public String toString(){
        return "Hello! I am a drone! You have named me " + name + ". My battery level is at " + batteryLevel + "%!";
      }
  
      // Main
    public static void main(String[] args){
  
  
        // New instance of object Droid
        Droid Codey = new Droid("Codey");
        Codey.performTask("Recording");
  
        // New instance of object Droid
        Droid snorlax = new Droid("Snorlax");
        snorlax.performTask("Sleeping");
        snorlax.currentBattery();
        snorlax.performTask("Fighting");
        
        System.out.println(snorlax);
    }
  }