import java.util.Scanner;
import java.text.DecimalFormat;

class Assignment7A {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    DecimalFormat df = new DecimalFormat("0.0#");
    float finalGrade = 0;
    float[][] grades = new float[][] {
      new float[13], //Labs
      new float[8], //Assignments
      new float[1], //Midterm
      new float[1], //Final Exam
    };

    System.out.println("[CSE 1321L Grade Calculator]");

    for (float[] arr : grades) {
      String category = arr == grades[0] ? "Labs" : arr == grades[1] ? "Assignments" : arr == grades[2] ? "Midterm" : arr == grades[3] ? "Exam" : "";
      float percentage = arr == grades[0] ? 0.10f : arr == grades[1] ? 0.40f : arr == grades[2] ? 0.20f : arr == grades[3] ? 0.30f : 0f;

      if (arr != grades[0]) System.out.println();
      System.out.println(category);

      for (int i = 0; i < arr.length; i++) {
        System.out.print("Enter Grade #" + (i + 1) + ": ");
        arr[i] = sc.nextFloat();
      }

      float weighted = Weighted(Average(arr, arr.length), percentage);
      finalGrade += weighted;

      System.out.println("Weighted Points: " + df.format(weighted));
    }

    sc.close();

    System.out.println("\nYour final grade for CSE1321L is: " + df.format(finalGrade));
  }

  public static float Average(float[] arr, int size) {
    float avg = 0;

    for (float i : arr) avg += i;

    avg /= size;

    return avg;
  }

  public static float Weighted(float avg, float percentage) {
    return avg * percentage;
  }
}