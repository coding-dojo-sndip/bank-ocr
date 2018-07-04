package fr.insee.ocr;

import static org.assertj.core.api.Assertions.*;
import org.junit.Test;

public class OcrTest {

	
	@Test
	public void test_digits() {
		String digits = Ocr.parse("digits.txt");
		assertThat(digits).isEqualTo("0123456789");
	}
}
