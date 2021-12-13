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
        boolean result = true;
        if (date != null) {
            try {
                LocalDate.parse((CharSequence) date, DateTimeFormatter.ofPattern(pattern).withResolverStyle(ResolverStyle.STRICT));
            } catch (final DateTimeParseException dtpe) {
                result = false;
            }
        }
        return result;
```     
L'appel `isValidDate("20211211", "uuuuMMdd")` retourne `true`