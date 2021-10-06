package fr.dva;

import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.validation.ConstraintValidatorContext;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import fr.dva.model.validation.ValidISBN;
import fr.dva.model.validation.ValidISBNValidator;

@ExtendWith(MockitoExtension.class)
public class ISBNValidatorTest {

	@Mock
	private ValidISBN isbn;

	@Mock
	private ConstraintValidatorContext constraintValidatorContext;

	@BeforeEach
	public void setup() {
	}

	@Test
	public void testValidISBNCode() {
		ValidISBNValidator validator = new ValidISBNValidator();
		validator.initialize(isbn);
		Object[] toBeValidated = new Object[] { "9780132350884" };
		assertTrue(validator.isValid(toBeValidated, constraintValidatorContext));
	}

}
