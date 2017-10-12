package freshers.bmi;

public class ConsoleApplication {
	private static final long MAXIMAL_WEIGHT = 700;
	private static final long MINIMUML_WEIGHT = 20;

	public static void main(String[] args) {
		// input
		System.out.println("Body Mass Index | Welcome!\n");
		Size size = enterSize();
		Long weight = enterWeight();

		// logic
		System.out.println(String.format("You are %d cm tall, that are %s, and weigh %d kg.",
				size.getCentimeters(), ImperialSizeFormat.shortFormat(size), weight));
		Double bodyMassIndex = (weight * 10_000.0) / (size.getCentimeters() * size.getCentimeters());

		// output
		output(bodyMassIndex);
	}

	private static void output(Double bodyMassIndex) {
		System.out.println(String.format("\nYour body mass index is %.1f.", bodyMassIndex));

		if (bodyMassIndex < 18.5) {
			System.err.println("You are underweight. Consult your doctor if and how to gain weight.");
		} else if (bodyMassIndex > 25) {
			System.err.println("You are overweight. Please, consult your local practioner.");
		} else {
			System.out.println("That is perfect.");
		}
	}

	private static Long enterWeight() {
		String weightText;
		Long weight;

		for (;;) {
			weightText = Console.readLine("Please enter your weight [kg] : ");
			weight = NumberUtils.integer(weightText);

			if (weight > MAXIMAL_WEIGHT) {
				System.err.println(String.format(
						"I am afraid that is more than we can currently support. You need to weight less than %d kg.",
						MAXIMAL_WEIGHT));
				continue;
			}

			if (weight < MINIMUML_WEIGHT) {
				System.err.println(String.format(
						"I am afraid that is lower than we can currently support. You need to weight more than %d kg.",
						MINIMUML_WEIGHT));
				continue;
			}

			break;
		}

		return weight;
	}

	private static Size enterSize() {
		String sizeText;
		Size size;

		for (;;) {
			try {
				sizeText = Console.readLine("Please enter how tall you are [cm]/[inches] : ");
				size = Size.valueOf(sizeText);
				break;
			} catch (NumberFormatException nfex) {
				System.err.println(nfex.getMessage());
			}
		}

		return size;
	}
}
