package hello;

public class Hello
{
  public static void main(final String[] arguments) {
    if (arguments.length == 0) {
      System.out.println(hello(null));
      return;
    } 
    
    forLoop(arguments);
    forEach(arguments);
    whileLoop(arguments);
    repeatLoop(arguments);
  }
  
  private static void forLoop(String[] arguments) {
    for(int i = 0; i < arguments.length; ++i) {
      System.out.println(hello(arguments[i]));
    }
  }
  
  private static void forEach(String[] arguments) {
    for (String name : arguments) {
      System.out.println(hello(name));
    }
  }
  
  private static void whileLoop(String[] arguments) {
    int index = 0;
    while (index < arguments.length) {
      System.out.println(hello(arguments[index++]) + " Have a nice day!");
    }
  }
  
  private static void repeatLoop(String[] arguments) {
    int index = 0;
    do {
      System.out.println(hello(arguments[index]) + " Yo!");
      index += 1;
    } while (index < arguments.length);
  }
  
  public static String hello(String name) {
    StringBuilder greeting = new StringBuilder("Hallo, ");

    if (name == null || name.isEmpty()) {
      greeting.append("Du");
    } else {
      greeting.append(name);
    }

    return greeting.append("!").toString();
  }
}
