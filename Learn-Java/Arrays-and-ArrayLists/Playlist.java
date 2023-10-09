/*
 * You’re heading to a desert island, cut off from the world, for the next six months. Luckily, you can bring a playlist of your favorite music ♪♪
 * Also, this is a chance to put your hard-earned Java skills to the test. Your mission, should you choose to accept it:
 * Build Playlist.java with the best possible playlist of music using a Java ArrayList. Choose wisely.
 */
import java.util.ArrayList;

class Playlist {
  public static void main(String[] args) {

    //Create a new ArrayList that holds Strings
    ArrayList<String> desertIslandPlaylist = new ArrayList<String>();

    //Adding strings to the ArrayList
    desertIslandPlaylist.add("Moscow Mule");
    desertIslandPlaylist.add("Depues de la Playa");
    desertIslandPlaylist.add("Me porto bonito");
    desertIslandPlaylist.add("Titi Me Pregunto");
    desertIslandPlaylist.add("Un Ratito");
    desertIslandPlaylist.add("Yo No Soy Celoso");
    desertIslandPlaylist.add("Tarot");

    //Remove songs from playlist
    desertIslandPlaylist.remove(4);
    desertIslandPlaylist.remove(5);
    
    //Prints out the songs in the Playlist
    System.out.println(desertIslandPlaylist); 

    //Prints the amount of songs in the playlist
    System.out.print("The amount of songs your Desert Island Playlist has: ");
    System.out.println(desertIslandPlaylist.size());

    //Swapping songs in the playlist
    int index1 = desertIslandPlaylist.indexOf("Moscow Mule");
    int index2 = desertIslandPlaylist.indexOf("Me porto bonito");

    String tempA = "Moscow Mule";
    String tempB = "Me porto bonito";

    desertIslandPlaylist.set(index2, tempA);
    desertIslandPlaylist.set(index1, tempB);

    // Prints the songs after the swap
    System.out.println(desertIslandPlaylist);
  }
  
}