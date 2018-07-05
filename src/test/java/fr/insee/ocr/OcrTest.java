package fr.insee.ocr;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

public class OcrTest {

	
	@Test
	public void test_read_digits_1() throws IOException {
		BankAccountNumber digits = Ocr.parseOne("src/test/resources/digits-1.txt");
		assertThat(digits.getNumber()).isEqualTo("123456789");
	}
	
	@Test
	public void test_read_digits_2() throws IOException {
		BankAccountNumber digits = Ocr.parseOne("src/test/resources/digits-2.txt");
		assertThat(digits.getNumber()).isEqualTo("012345678");
	}
	
	@Test
	public void test_read_digits_3() throws IOException {
		List<BankAccountNumber> digits = Ocr.parseAll("src/test/resources/digits-3.txt");
		assertThat(digits).hasSize(2);
		assertThat(digits).contains(BankAccountNumber.of("123456789"), BankAccountNumber.of("012345678"));
	}
	
	@Test
	public void test_check_bank_account_number_1() throws IOException {
		assertThat(BankAccountNumber.of("123456789").status()).isEqualTo(Status.ERR);
	}
	
	@Test
	public void test_check_bank_account_number_2() throws IOException {
		assertThat(BankAccountNumber.of("012345678").status()).isEqualTo(Status.ERR);
	}
	
	@Test
	public void test_check_bank_account_number_3() throws IOException {
		assertThat(BankAccountNumber.of("457508023").status()).isEqualTo(Status.OK);
	}
	
	@Test
	public void test_check_err_ill_1() throws IOException {
	}
}
