import java.lang.StringBuilder;
import java.io.*;

class Assignment7B {
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    boolean goAgain = true;

    do {
      System.out.println("Enter your message:");
      String input = br.readLine();

      System.out.print("Enter the offset value: ");
      int offset = Integer.parseInt(br.readLine());

      if (isValid(input, offset)) {
        System.out.println("\nYour secret message is...");
        System.out.println(Encrypt(input, offset));
      } else System.out.println("\nSorry, we can only process messages with letters and spaces, and the offset must be between 0 and 26.\n");

      System.out.print("Do you want to encrypt another message?: ");
      goAgain = br.readLine().equalsIgnoreCase("Y");
    } while (goAgain);

    System.out.println("\nClosing out...");
  }

  public static boolean isValid(String input, int offset) {
    return input.matches("^[ A-Za-z]+$") && (offset >= 0 && offset <= 26);
  }

  public static String Encrypt(String input, int offset) {
    StringBuilder sb = new StringBuilder();

    for (char c : input.toUpperCase().toCharArray()) {
      if (c == ' ') {
        sb.append(c);
        continue;
      }

      sb.append((char) (((c - 'A' + offset) % 26) + 'A'));
    }

    return sb.toString();
  }
}