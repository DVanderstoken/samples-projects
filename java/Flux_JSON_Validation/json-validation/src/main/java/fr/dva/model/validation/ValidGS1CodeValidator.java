package fr.dva.model.validation;

import java.util.Arrays;
import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidGS1CodeValidator implements ConstraintValidator<ValidGS1, Object[]> {

	@Override
	public boolean isValid(Object[] values, ConstraintValidatorContext constraintValidatorContext) {
		boolean result = true;
		if (values[0] != null) {
			result =  validateGS1Code((String) values[0]);
		}
		return result;
	}

	private boolean validateGS1Code(final String GS1Code) {
		// default optimistic result
		boolean result = true;
		
		String codeType = GS1.getCodeTypeFromLength(GS1Code.length());
		
		if (codeType != null) {
			String code = String.format("%018d",  Long.valueOf(GS1Code));
			String[] codeParts = code.split("");
			int sum = 0;
			for (int pos = 0; pos < 17; pos++) {
				sum += pos % 2 == 0 ? (Integer.parseInt(codeParts[pos])) * 3 : (Integer.parseInt(codeParts[pos]));
			}
			int key = Math.abs((Math.round(sum / 10)+1) * 10 - sum);
			result = key == Integer.parseInt(codeParts[17]);
		} else {
			result = false;
		}
		
		return result;
	}
	
	public enum GS1 {
		GTIN_8(8),
		GTIN_12(12),
		GTIN_13(13),
		GTIN_14(14),
		GSIN(17),
		SSCC(18);
		
		private int length;

		private GS1(int length) {
			this.length = length;
		}

		public int getLength() {
			return length;
		}
		
		public static String getCodeTypeFromLength(final int length) {
			String codeType = null; 
			Optional<GS1> opt =  Arrays.stream(GS1.values()).filter(g -> g.length == length).findFirst();
			if (opt.isPresent()) {
				codeType = opt.get().toString();
			}
			return codeType;
		}
		
	}
}
