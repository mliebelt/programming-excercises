package freshers.bmi;

public class ImperialSizeFormat {
  public static String shortFormat(final Size size) {
	  long feet = Math.floorDiv(size.getInches(), Size.INCHES_PER_FEET);
	  long inches = size.getInches() - feet * Size.INCHES_PER_FEET;
	  
	  return String.format("%d'%d\"", feet, inches);
  }
}
