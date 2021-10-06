package fr.dva.model.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidISBNValidator implements ConstraintValidator<ValidISBN, Object[]> {

	private static final String ISBN_PATTERN = "\\d{3}-\\d-\\d{4}-\\d{4}-\\d";
	private static final String ISBN_PATTERN_WITHOUT_HYPHEN = "\\d{13}";

	@Override
	public boolean isValid(Object[] values, ConstraintValidatorContext constraintValidatorContext) {
		boolean result = true;
		if (values[0] != null) {
			result = (((String) values[0]).matches(ISBN_PATTERN) || ((String) values[0]).matches(ISBN_PATTERN_WITHOUT_HYPHEN)) && validateISBN((String) values[0]);
		}
		return result;
	}

	private boolean validateISBN(final String ISBN) {
		// default optimistic result
		boolean result = true;
		// remove hyphen
		String ISBNNumbersOnly = ISBN.replaceAll("-", "");
		if (ISBNNumbersOnly.length() == 13) {
			String[] ISBNParts = ISBNNumbersOnly.split("");
			int sum = 0;
			for (int pos = 0; pos < 12; pos++) {
				sum += pos % 2 == 0 ? Integer.parseInt(ISBNParts[pos]) : Integer.parseInt(ISBNParts[pos]) * 3;
			}
			int key = 10 - (sum % 10);
			result = key == Integer.parseInt(ISBNParts[12]);
		} else {
			result = false;
		}
		return result;
	}
}
