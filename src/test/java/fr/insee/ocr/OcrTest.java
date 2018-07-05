package fr.insee.ocr;

import static org.assertj.core.api.Assertions.*;

import java.io.IOException;

import org.junit.Test;

public class OcrTest {

	
	@Test
	public void test_digits_1() throws IOException {
		String digits = Ocr.parseOne("src/test/resources/digits-1.txt");
		assertThat(digits).isEqualTo("123456789");
	}
	
	@Test
	public void test_digits_2() throws IOException {
		String digits = Ocr.parseOne("src/test/resources/digits-2.txt");
		assertThat(digits).isEqualTo("012345678");
	}
}
