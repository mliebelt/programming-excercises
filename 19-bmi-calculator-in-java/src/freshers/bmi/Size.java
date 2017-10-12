package freshers.bmi;

public class Size {
	private static final int MINIMAL_SIZE = 100;
	private static final int MAXIMAL_SIZE = 254;

	public static final double INCH_IN_CM = 2.54;
	public static final int INCHES_PER_FEET = 12;

	private long centimeters;

	public long getCentimeters() {
		return centimeters;
	}

	public long getInches() {
		return Math.round(centimeters / INCH_IN_CM);
	}

	public static Size valueOf(final String value) throws NumberFormatException {
		if (value == null || value.isEmpty()) {
			throw new NumberFormatException("What? You have no size at all? I quit!");
		}

		String input = value.trim().toLowerCase().replace("-", "");

		Size size = new Size();

		// try metric first
		if (input.endsWith("cm") || input.endsWith("centimeter") || input.endsWith("zentimeter")) {
			size.centimeters = humanSize(NumberUtils.integer(input));
			return size;
		}

		// if given in meters
		if (input.endsWith("m") || input.endsWith("meter")) {
			size.centimeters = Math.abs(NumberUtils.integer(input.replaceAll("[,\\.]", "")));
			while (size.centimeters < 100) {
				size.centimeters *= 10;
			}
			size.centimeters = humanSize(size.centimeters);
			return size;
		}

		// there are only 17 men ever larger than 2.50m, the equivalent of 100", so
		// three digits always mean metric system

		long head = NumberUtils.integer(input.replaceAll("[,\\.]", ""));
		if (head >= MINIMAL_SIZE) {
			// centimeters
			size.centimeters = humanSize(head);
		} else if (head > 10) {
			// inches
			size.centimeters = humanSize(Math.round(INCH_IN_CM * head));
		} else if (head > 0) {
			// at least feet
			String[] numerics = input.split("[^\\d]+");
			switch (numerics.length) {
			case 1:
				size.centimeters = humanSize(Math.round(head * INCH_IN_CM * INCHES_PER_FEET));
				break;
			case 2:
				size.centimeters = Math.round(Math.floor(head * INCH_IN_CM * INCHES_PER_FEET))
						+ Math.round(NumberUtils.integer(numerics[1]) * INCH_IN_CM);
				break;
			default:
				throw new NumberFormatException(String
						.format("Please give your size in centimeters or feet and inches, but not as \"%s\".", value));
			}
		}

		size.centimeters = humanSize(size.centimeters);
		return size;
	}

	private static long humanSize(long centimeters) throws NumberFormatException {
		if (centimeters < MINIMAL_SIZE) {
			throw new NumberFormatException(String.format(
					"Sorry, we cannot estimate a body mass index for dwarfs and children, you must be at least %s cm.",
					MINIMAL_SIZE));
		}

		if (centimeters >= MAXIMAL_SIZE) {
			throw new NumberFormatException(String.format(
					"Sorry, we cannot estimate a body mass index for giants like you, you must be shorter than %s cm.",
					MAXIMAL_SIZE));
		}

		return centimeters;
	}
}
