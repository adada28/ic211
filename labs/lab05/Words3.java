public class Words3 {
  public static void main(String[] args) {
    // Program requires two command-line arguments.
    if( args.length != 2 ) {
      System.out.println("Usage: 'java Lab05 seedValue numWords'");
      System.exit(1);
    }

    // Create a RandomWordLitRhyme object and generate random words with it.
    RandomWordLitRhyme rand = new RandomWordLitRhyme(Long.parseLong(args[0]));
    int N = Integer.parseInt(args[1]);
    for(int i = 0; i < N; i++)
      System.out.print(rand.next() + " ");
    System.out.println();
  }
}