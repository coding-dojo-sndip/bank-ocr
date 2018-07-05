package fr.insee.ocr;

import static org.assertj.core.api.Assertions.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

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
	
	@Test
	public void test_digits_3() throws IOException {
		List<String> digits = Ocr.parseAll("src/test/resources/digits-3.txt");
		assertThat(digits).hasSize(2);
		assertThat(digits).hasSameElementsAs(Arrays.asList("123456789", "012345678"));
	}
}
