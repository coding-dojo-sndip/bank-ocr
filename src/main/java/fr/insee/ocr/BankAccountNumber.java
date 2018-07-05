package fr.insee.ocr;

public class BankAccountNumber {

	private String number;

	private BankAccountNumber(String number) {
		this.number = number;
	}
	
	public static BankAccountNumber of(String number) {
		return new BankAccountNumber(number);
	}
	
	public Status status() {
		if(this.isIllegal()) return Status.ILL;
		if(this.isError()) return Status.ERR;
		return Status.OK;
	}
	
	private boolean isIllegal() {
		return number.contains("?");
	}
	
	private boolean isError() {
		return !this.isIllegal() && this.checksum() % 11 > 0;
	}
	
	private int checksum() {
		int checksum = 0;
		for (int index = 0; index < 9; index ++) {
			int digit = number.charAt(index);
			checksum += digit * (digit - index);
		}
		return checksum;
	}

	public String getNumber() {
		return number;
	}

	@Override
	public int hashCode() {
		return number.hashCode();
	}

	@Override
	public boolean equals(Object object) {
		if(object instanceof BankAccountNumber) {
			BankAccountNumber other = (BankAccountNumber) object;
			return this.number.equals(other.number);
		}
		return false;
	}
	
	
}
