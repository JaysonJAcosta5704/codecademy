public class DNA{
    public static void main(String[] args){
      String dna = "ATGCGATACGCTTGA";
      String dnaStart = "ATG";
      String dnaEnd = "TGA";
      if (dnaStart.equals(dna.substring(0, 3)) && dnaEnd.equals(dna.substring(dna.length()-3, dna.length())) && dna.length() % 3 == 0){
        System.out.println("This DNA is a protien!");
      }
      else {
        System.out.println("This DNA is not a protien.");
      }
    }
  }