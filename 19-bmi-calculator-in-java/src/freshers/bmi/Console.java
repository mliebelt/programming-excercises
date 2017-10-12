package freshers.bmi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Console extends Reader {
	private static BufferedReader reader = new BufferedReader((new InputStreamReader(System.in)));

	public static String readLine(final String prompt) {
		if (prompt != null) {
			System.out.print(prompt);
		}
		try {
			return reader.readLine();
		} catch (IOException ioex) {
			return null;
		}
	}

	@Override
	public void close() throws IOException {
      reader.close();		
	}

	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {
		return reader.read(cbuf, off, len);
	}
}
