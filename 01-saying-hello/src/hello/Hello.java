package hello;

public class Hello
{
  public static void main(final String[] arguments) {
    System.out.print("Hallo, ");

    if (arguments.length > 0) {
      System.out.print(arguments[0]);
    } else {
      System.out.print("Du");
    }

    System.out.println("!");
  }
}
