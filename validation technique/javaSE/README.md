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
    /**
	 * @param date,    la date à valider, sous forme de chaîne de caractères
	 * @param pattern, le pattern utilisé pour valider la date, @see
	 *                 java.time.format.DateTimeFormatter.
	 * @return true si la date est valide au regard du pattern de validation
	 * @throws DateTimeParseException si la date est invalide
	 * @throws NullPointerException   si au moins un des deux paramètres est null.
	 */
	public boolean isValidDate(String date, String pattern) throws DateTimeParseException, NullPointerException {
		LocalDate.parse((CharSequence) date, DateTimeFormatter.ofPattern(pattern).withResolverStyle(ResolverStyle.STRICT));
		return true;
	}
```     
L'appel `isValidDate("20211211", "uuuuMMdd")` retourne `true`

L'appel `isValidDate("20210229", "uuuuMMdd")` retourne `false`