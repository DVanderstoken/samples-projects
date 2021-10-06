package fr.dva;

import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.validation.ConstraintValidatorContext;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import fr.dva.model.validation.ValidGS1;
import fr.dva.model.validation.ValidGS1CodeValidator;

@ExtendWith(MockitoExtension.class)
public class GS1CodeValidatorTest {

	@Mock
	private ValidGS1 validGS1;

	@Mock
	private ConstraintValidatorContext constraintValidatorContext;

	@Test
	public void testValidGTIN8Code() {
		ValidGS1CodeValidator validGS1CodeValidator = new ValidGS1CodeValidator();
		validGS1CodeValidator.initialize(validGS1);
		Object[] toBeValidated = new Object[] { "50375301" };
		assertTrue(validGS1CodeValidator.isValid(toBeValidated, constraintValidatorContext));
	}

	@Test
	public void testValidGTIN13Code() {
		ValidGS1CodeValidator validGS1CodeValidator = new ValidGS1CodeValidator();
		validGS1CodeValidator.initialize(validGS1);
		Object[] toBeValidated = new Object[] { "3268840001008" };
		assertTrue(validGS1CodeValidator.isValid(toBeValidated, constraintValidatorContext));
	}

}
