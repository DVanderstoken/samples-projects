## Reverse a String

### Ennoncé
Ecrire une méthode qui retourne une chaine de caractères inversée.

### Corrigé

```Java
    public String revertString(final String s) {
		int stringLength = s.length();
		char[] revertedCharArray = new char[stringLength];
		for (int pos = 0; pos < stringLength; pos++) {
			revertedCharArray[stringLength - pos - 1] = s.charAt(pos);
		}
		return String.valueOf(revertedCharArray);
	}
```

## Validation d'une date (Java 8+)

### Ennoncé :
```Java
    public boolean isValidDate(String date, String pattern) {
        // Compléter le corps de la méthode.
        // On supposera que le pattern est un pattern de date valide

    }
```
### Corrigé

```Java
    public boolean isValidDate(String date, String pattern) {
		// default pessimistic result
        boolean result = false;
        if (null != date && null != pattern) {
            try {
                LocalDate.parse((CharSequence) date, DateTimeFormatter.ofPattern(pattern).withResolverStyle(ResolverStyle.STRICT));
                result = true;
            } catch (final DateTimeParseException error) {
                // nothing to do here
            }
        } else {
        	throw new NullPointerException("Date parameter and / or pattern parameter must not be null");
        }
        return result;
	}
```     
L'appel `isValidDate("20211211", "uuuuMMdd")` retourne `true`

L'appel `isValidDate("20210229", "uuuuMMdd")` retourne `false`