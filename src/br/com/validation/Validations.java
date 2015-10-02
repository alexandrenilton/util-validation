package br.com.validation;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Está classe está contida com métodos implementados
 * para efetuar as operações de validações de dados
 * digitados pelo cliente ou algo que simule isso.
 * 
 * @author  Alexandre Belem
 * @version 1.0 beta Initial $
 *
 * @see Calendar
 */
public final class Validations {


    private Validations() {
    	
    }


   
    /**
     * Checa se os objetos passados são iguais, 
     * inclusive <code>null</code>. Se os objetos
     * forem iguais, returna <code>true</code>
     * senão <code>false</code>
     *
     * <pre>
     * Validations.equals(null, null)  == true
     * Validations.equals("Hi", "Hi")  == true
     * Validations.equals("Hi", null)  == false
     * Validations.equals(null, "Hi")  == false
     * Validations.equals("Hi", "Ho")  == false
     * </pre>
     *
     * @param obj1        o primeiro objeto para comparação
     * @param obj2        o segundo objeto para comparação
     * @return boolean  <code>true</code> se e somente se os objetos
     *  forem <code>null</code> ou iguais
     *  @author Alexandre Belem
     */
    public static boolean equals(Object obj1, Object obj2) {
        return    (obj1 != null && obj2 != null && obj1.equals(obj2))
               || (obj1 == null && obj2 == null);
    }


    /**
     * Checa e responde se uma data string é espaço em branco,
     * ou vazia ("") ou <code>null</code>.
     * <pre>
     * Validation.isBlank(null)    == true
     * Validation.isBlank("")      == true
     * Validation.isBlank(" ")     == true
     * Validation.isBlank(" abc")  == false
     * Validation.isBlank("abc ")  == false
     * Validation.isBlank(" abc ") == false
     * </pre>
     *
     * @param str   a string que irá ser comparada, podendo ser <code>null</code>
     * @return <code>true</code> Se a string contém espaço vazio ou é vazia 
     *  ou <code>null</code>if the string is whitespace.
     
     * @see #isEmpty(String)
     * @author Alexandre Belem
     */
    public static boolean isBlank(String str) {
        int length;
        if ((str == null) || ((length = str.length()) == 0)) {
            return true;
        }
        for (int i = length - 1; i >= 0; i--) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }


    /**
     * Checa e retorna para uma string dada 
     * se ela não e vazia, ou não <code>null</code> ou 
     * não contem espaço em branco.
     *
     * <pre>
     * Validation.isNotBlank(null)    == false
     * Validation.isNotBlank("")      == false
     * Validation.isNotBlank(" ")     == false
     * Validation.isNotBlank(" abc")  == true
     * Validation.isNotBlank("abc ")  == true
     * Validation.isNotBlank(" abc ") == true
     * </pre>
     *
     * @param str   a string para compração, podendo ser <code>null</code>
     * @return <code>true</code> se a string não é vazia e não 
     *    <code>null</code> e não contém espaço em branco somente.
     *
     * @see #isEmpty(String)
     * @auhtor Alexandre Belem
     */
    public static boolean isNotBlank(String str) {
        int length;
        if ((str == null) || ((length = str.length()) == 0)) {
            return false;
        }
        for (int i = length - 1; i >= 0; i--) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }


    /**
     * Checka e retorna se uma dada string é
     * vazia ou <code>null</code>.
     *
     * <pre>
     * Validation.isEmpty(null)  == true
     * Validation.isEmpty("")    == true
     * Validation.isEmpty(" ")   == false
     * Validation.isEmpty("Hi ") == false
     * </pre>
     *
     * @param str   a string para comparação, podendo ser <code>null</code>
     * @return <code>true</code> se a string é vazia ou <code>null</code>
     *
     * @see #isBlank(String)
     * @author Alexandre Belem
     */
    public static boolean isEmpty(String str) {
        return (str == null) || (str.length() == 0);
    }


    /**
     * Checa e retorna se uma determidada string data 
     *  é não vazia ou não <code>null</code>
     *
     * <pre>
     * Validation.isNotEmpty(null)  == false
     * Validation.isNotEmpty("")    == false
     * Validation.isNotEmpty(" ")   == true
     * Validation.isNotEmpty("Hi")  == true
     * Validation.isNotEmpty("Hi ") == true
     * </pre>
     *
     * @param str   a string para comparação, podendo ser <code>null</code>
     * @return <code>true</code> se a string é não vazia ou não <code>null</code>
     *
     * @see #isBlank(String)
     * @author Alexandre Belem
     */
    public static boolean isNotEmpty(String str) {
        return (str != null) && (str.length() > 0);
    }


    /**
     * Checa e retorna se uma dada string tem no minimo um tamanho
     *  especificado.
     * 
     * String que são <code>null</code> ou contém espaços em branco, tem
     *  tamanho 0.
     *
     * <pre>
     * Validation.hasMinimumLength(null,  2) == false
     * Validation.hasMinimumLength("",    2) == false
     * Validation.hasMinimumLength(" ",   2) == false
     * Validation.hasMinimumLength("   ", 2) == false
     * Validation.hasMinimumLength("Oi ", 2) == true
     * Validation.hasMinimumLength("Eae", 2) == true
     * </pre>
     *
     * @param str   a string para checagem
     * @param min   o tamanho minimo
     * @return <code>true</code> se o tamanho é maior ou igual ao 
     *  minimo informado.
     * @author Alexandre Belem
     */
    public static boolean hasMinimumLength(String str, int min) {
        int length = str == null ? 0 : str.trim().length();
        return min <= length;
    }


    /**
     * Checa e retorna se uma dada string possui mais de 
     * um tamanho especificado.
     * String <code>null</code> ou com espaços em branco 
     * possui tamanho 0.
     *
     * <pre>
     * Validation.hasMaximumLength(null,  2) == true
     * Validation.hasMaximumLength("",    2) == true
     * Validation.hasMaximumLength(" ",   2) == true
     * Validation.hasMaximumLength("   ", 2) == true
     * Validation.hasMaximumLength("Hi ", 2) == true
     * Validation.hasMaximumLength("Ewa", 2) == false
     * </pre>
     *
     * @param str   a string para comparação
     * @param max   o tamanho máximo
     * @return <code>true</code> se o tamanho for menor ou igual ao 
     * minumo informado.
     * @author Alexandre Belem
     */
    public static boolean hasMaximumLength(String str, int max) {
        int length = str == null ? 0 : str.trim().length();
        return length <= max;
    }


    /**
     * Checa e retorna se o uma determinada string está nos limites de
     * tamanho informados. Intervalo [min, max].
     * 
     * Strings that are <code>null</code> or contain only blanks have length 0.
     *
     * <pre>
     * ValidationUtils.hasBoundedLength(null,  1, 2) == false
     * ValidationUtils.hasBoundedLength("",    1, 2) == false
     * ValidationUtils.hasBoundedLength(" ",   1, 2) == false
     * ValidationUtils.hasBoundedLength("   ", 1, 2) == false
     * ValidationUtils.hasBoundedLength("Hi ", 1, 2) == true
     * ValidationUtils.hasBoundedLength("Ewa", 1, 2) == false
     * </pre>
     *
     * @param str   the string to check
     * @param min   the minimum length
     * @param max   the maximum length
     * @return <code>true</code> if the length is in the interval,
     *     <code>false</code> otherwise
     * @throws IllegalArgumentException if min > max
     * @author Alexandre Belem
     */
    public static boolean hasBoundedLength(String str, int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException(
                "The minimum length must be less than or equal to the maximum length.");
        }
        int length = str == null ? 0 : str.trim().length();
        return (min <= length) && (length <= max);
    }


    // Validacao de caracteres

    /**
     * Checa e retorna se uma dada string 
     * contem somente letras unicode. 
     * <code>null</code> retorna <code>false</code>,
     * uma string vazia ("") retorna <code>true</code>.
     * Uma string com letras e espaco em branco retorna 
     * <code>false</code>
     *
     * <pre>
     * Validation.isOnlyLetters(null)   == false
     * Validation.isOnlyLetters("")     == true
     * Validation.isOnlyLetters("   ")  == false
     * Validation.isOnlyLetters("abc")  == true
     * Validation.isOnlyLetters("ab c") == false
     * Validation.isOnlyLetters("ab2c") == false
     * Validation.isOnlyLetters("ab-c") == false
     * </pre>
     *
     * @param str   a string para comparacao, podendo ser <code>null</code>
     * @return <code>true</code> se a string contem somente 
     * letras unicode.
     * @author Alexandre Belem
     */
    public static boolean isOnlyLetters(String str) {
        if (str == null) {
            return false;
        }
        for (int i = str.length() - 1; i >= 0; i--) {
            if (!Character.isLetter(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }


    /**
     * Checa e retorna se uma dada string contem
     * somente caracteres unicode e/ou espaco.
     * <code>null</code> retorna false,
     * uma string vazia ("") retorna <code>true</code>.
     *
     * <pre>
     * Validation.isLettersSpace(null)   == false
     * Validation.isLettersSpace("")     == true
     * Validation.isLettersSpace("   ")  == true
     * Validation.isLettersSpace("abc")  == true
     * Validation.isLettersSpace("ab c") == true
     * Validation.isLettersSpace("ab2c") == false
     * Validation.isLettersSpace("ab-c") == false
     * </pre>
     *
     * @param str   a string para comparacao. Podendo ser <code>null</code>
     * @return <code>true</code> Se a string contem somente letras unicode e espaco.
     * @author Alexandre Belem
     */
    public static boolean isLettersSpace(String str) {
        if (str == null) {
            return false;
        }
        for (int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);
            if (!Character.isLetter(c) && (c != ' ')) {
                return false;
            }
        }
        return true;
    }


    /**
     * Checa e retorna se uma dada string contem somente
     * letras unicode ou numeros.
     * <code>null</code> retorna false,
     * e uma string vazia ("") retorna <code>true</code>.
     *
     * <pre>
     * Validation.isLettersNumbers(null) == false
     * Validation.isLettersNumbers("")     == true
     * Validation.isLettersNumbers("   ")  == false
     * Validation.isLettersNumbers("abc")  == true
     * Validation.isLettersNumbers("ab c") == false
     * Validation.isLettersNumbers("ab2c") == true
     * Validation.isLettersNumbers("ab-c") == false
     * Validation.isLettersNumbers("123")  == true
     * Validation.isLettersNumbers("12 3") == false
     * Validation.isLettersNumbers("12-3") == false
     * </pre>
     *
     * @param str   a string para comparacao, podendo ser <code>null</code>
     * @return <code>true</code> se a string contem somente letras unicode 
     * ou numeros.
     * @author Alexandre Belem
     */
    public static boolean isLettersNumbers(String str) {
        if (str == null) {
            return false;
        }
        for (int i = str.length() - 1; i >= 0; i--) {
            if (!Character.isLetterOrDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }


    /**
     * Checka e retorna se uma dada string contém somente
     * caracteres unicode, ou seja, letras ou números ou espaço
     * <code>null</code> retorna <code>false</code>,
     * uma string vazia("") retorna <code>true</code>.
     *
     * <pre>
     * Validations.isAlphanumericSpace(null)   == false
     * Validations.isAlphanumericSpace("")     == true
     * Validations.isAlphanumericSpace("   ")  == true
     * Validations.isAlphanumericSpace("abc")  == true
     * Validations.isAlphanumericSpace("ab c") == true
     * Validations.isAlphanumericSpace("ab2c") == true
     * Validations.isAlphanumericSpace("ab-c") == false
     * Validations.isAlphanumericSpace("123")  == true
     * Validations.isAlphanumericSpace("12 3") == true
     * Validations.isAlphanumericSpace("12-3") == false
     * </pre>
     *
     * @param str   A string para checagem, podendo ser <code>null</code>
     * @return <code>true</code> se a string contém somente letras, digitos ou
     * espaço unicode.
     *
     * @author Alexandre Belem
     */
    public static boolean isAlphanumericSpace(String str) {
        if (str == null) {
            return false;
        }
        for (int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);
            if (!Character.isLetterOrDigit(c) && (c != ' ')) {
                return false;
            }
        }
        return true;
    }


    /*
     * Checks and answers if the given string contains only unicode digits.
     * A decimal point is not a unicode digit and returns <code>false</code>.
     * <code>null</code> returns false,
     * an empty string ("") returns <code>true</code>.
     *
     * <pre>
     * ValidationUtils.isNumeric(null)   == false
     * ValidationUtils.isNumeric("")     == true
     * ValidationUtils.isNumeric("   ")  == false
     * ValidationUtils.isNumeric("abc")  == false
     * ValidationUtils.isNumeric("ab c") == false
     * ValidationUtils.isNumeric("ab2c") == false
     * ValidationUtils.isNumeric("ab-c") == false
     * ValidationUtils.isNumeric("123")  == true
     * ValidationUtils.isNumeric("12 3") == false
     * ValidationUtils.isNumeric("12-3") == false
     * ValidationUtils.isNumeric("12.3") == false
     * </pre>
     *
     * @param str   the string to check, may be <code>null</code>
     * @return <code>true</code> if the string contains only unicode digits,
     *     and is non-<code>null</code>
     *
     * @since 1.2
     */
    public static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        for (int i = str.length() - 1; i >= 0; i--) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }


    /*
     * Checks and answers if the given string contains only unicode digits
     * or space (' '). A decimal point is not a unicode digit and
     * returns <code>false</code>.
     * <code>null</code> returns false,
     * an empty string ("") returns <code>true</code>.
     *
     * <pre>
     * ValidationUtils.isNumericSpace(null)   == false
     * ValidationUtils.isNumericSpace("")     == true
     * ValidationUtils.isNumericSpace("   ")  == true
     * ValidationUtils.isNumericSpace("abc")  == false
     * ValidationUtils.isNumericSpace("ab c") == false
     * ValidationUtils.isNumericSpace("ab2c") == false
     * ValidationUtils.isNumericSpace("ab-c") == false
     * ValidationUtils.isNumericSpace("123")  == true
     * ValidationUtils.isNumericSpace("12 3") == true
     * ValidationUtils.isNumericSpace("12-3") == false
     * ValidationUtils.isNumericSpace("12.3") == false
     * </pre>
     *
     * @param str   the string to check, may be <code>null</code>
     * @return <code>true</code> if the string contains only unicode digits
     *     or space, and is non-<code>null</code>
     *
     * @since 1.2
     */
    public static boolean isNumericSpace(String str) {
        if (str == null) {
            return false;
        }
        for (int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);
            if (!Character.isDigit(c) && (c != ' ')) {
                return false;
            }
        }
        return true;
    }


    // Date Validations *******************************************************

    /*
     * Determines and answers if the day of the given <code>Date</code>
     * is in the past.
     *
     * @param date   the date to check
     * @return <code>true</code> if in the past, <code>false</code> otherwise
     */
    public static boolean isPastDay(Date date) {
        Calendar in = new GregorianCalendar();
        in.setTime(date);
        Calendar today = getRelativeCalendar( 0);
        return in.before(today);
    }


    /*
     * Determines and answers if the given <code>Date</code> is yesterday.
     *
     * @param date   the date to check
     * @return <code>true</code> if yesterday, <code>false</code> otherwise
     */
    public static boolean isYesterday(Date date) {
        Calendar in = new GregorianCalendar();
        in.setTime(date);
        Calendar yesterday = getRelativeCalendar(-1);
        Calendar today     = getRelativeCalendar( 0);
        return !in.before(yesterday)
             && in.before(today);
    }
    
    /**Determina e retorna se uma data <code>Date</code> é 
     * X (days) dias atrás.
     * 
     * @param date
     * @param days
     * @return boolean <code>true</code> se a data é x dias atrás
     * e <code>false</code> caso não.
     * @auhtor Alexandre Belem
     */
    public static boolean isDaysPast(Date date, int days){
    	Calendar in = new GregorianCalendar();
    	in.setTime(date);
    	Calendar daysPast = getRelativeCalendar(-days);
    	Calendar today    = getRelativeCalendar( 0 );
    	
    	return !in.before(daysPast)
    		&&  in.before(today);
    }
    
    /**
     * Determina e retorna se uma dada data <code>Date</code>
     * é hoje.
     *
     * @param date   a data para checagem
     * @return <code>true</code> se  hoje, <code>false</code> caso contrário
     * @author Alexandre Belem
     */
    public static boolean isToday(Date date) {
        GregorianCalendar in = new GregorianCalendar();
        in.setTime(date);
        Calendar today    = getRelativeCalendar( 0);
        Calendar tomorrow = getRelativeCalendar(+1);
        return !in.before(today)
             && in.before(tomorrow);
    }


    /*
     * Determines and answers if the given <code>Date</code> is tomorrow.
     *
     * @param date   the date to check
     * @return <code>true</code> if tomorrow, <code>false</code> otherwise
     */
    public static boolean isTomorrow(Date date) {
        GregorianCalendar in = new GregorianCalendar();
        in.setTime(date);
        Calendar tomorrow = getRelativeCalendar(+1);
        Calendar dayAfter = getRelativeCalendar(+2);
        return !in.before(tomorrow)
             && in.before(dayAfter);
    }


    /*
     * Determines and answers if the day of the given <code>Date</code>
     * is in the future.
     *
     * @param date   the date to check
     * @return <code>true</code> if in the future, <code>false</code> otherwise
     */
    public static boolean isFutureDay(Date date) {
        Calendar in = new GregorianCalendar();
        in.setTime(date);
        Calendar tomorrow = getRelativeCalendar(+1);
        return !in.before(tomorrow);
    }


    /*
     * Computes the day that has the given offset in days to today
     * and returns it as an instance of  <code>Date</code>.
     *
     * @param offsetDays   the offset in day relative to today
     * @return the <code>Date</code> that is the begin of the day
     *     with the specified offset
     */
    public static Date getRelativeDate(int offsetDays) {
        return getRelativeCalendar(offsetDays).getTime();
    }


    /*
     * Computes the day that has the given offset in days to today
     * and returns it as an instance of <code>Calendar</code>.
     *
     * @param offsetDays   the offset in day relative to today
     * @return a <code>Calendar</code> instance that is the begin of the day
     *     with the specified offset
     */
    public static Calendar getRelativeCalendar(int offsetDays) {
        Calendar today = new GregorianCalendar();
        return getRelativeCalendar(today, offsetDays);
    }


    /*
     * Computes the day that has the given offset in days from the specified
     * <em>from</em> date and returns it as an instance of <code>Calendar</code>.
     *
     * @param from         the base date as <code>Calendar</code> instance
     * @param offsetDays   the offset in day relative to today
     * @return a <code>Calendar</code> instance that is the begin of the day
     *     with the specified offset from the given day
     */
    public static Calendar getRelativeCalendar(Calendar from, int offsetDays) {
        Calendar temp =
            new GregorianCalendar(
                from.get(Calendar.YEAR),
                from.get(Calendar.MONTH),
                from.get(Calendar.DATE),
                0,
                0,
                0);
        temp.add(Calendar.DATE, offsetDays);
        return temp;
    }
    
    /**
     * Método para verificar se uma dataEnd fornecida
     * é maior que uma dateInitial.
     * 
     * @param dateInitial
     * @param dateEnd
     * @return boolean 
     * 
     * @uathor Alexandre Belem
     */
    public static boolean isDateEndGreatDateInitial(Date dateInitial, Date dateEnd){
    	
    	if ( dateInitial == null || dateEnd == null ){
    		return false;
    	}
    	
    	if ( dateEnd.compareTo(dateInitial) > 0 ){
    		return true;
    	}else{
    		return false;
    	}
    }
    
    /**
     * Método para comparar duas datas no formato <code>Date</code>.
     * Passa-se ao método uma data inicial e uma data final, o método
     * compara as datas e retorna <code>true</code> caso a dateEinal
     * seja menor que a dateInitial. Se uma das datas fornecidas
     * for <code>null</code> retorna <code>false</code>
     * 
     * Considere: 
     *     date01 (01/10/2007);
     *     date02 (02/11/2007);
     * 
     * <pre>
     * 	Validation.isDataEndLessThanDateInitial(date02, date01) == true
     *  Validation.isDataEndLessThanDateInitial(date01, date02) == false
     * </pre>
     * 
     * @param dateInitial
     * @param dateEnd
     * @return boolean true para verdadeira e false para falso.
     * 
     * @author Alexandre Belem
     */
    public static boolean isDataEndLessThanDateInitial(Date dateInitial, Date dateEnd){
    	if ( dateInitial == null || dateEnd == null ){
    		return false;
    	}
    	
    	if ( dateEnd.compareTo(dateInitial) < 0 ){
    		return true;
    	}else{
    		return false;
    	}
    }
    
    /**
     * Método para verificar se duas datas fornecidas são iguais.
     * Se uma das datas fornecidas
     * for <code>null</code> retorna <code>false</code>
     * 
     * @param dateInitial
     * @param dateEnd
     * @return boolean <code>true</code> para verdadeiro, ou seja datas iguais
     * ou <code>false</code> falso, caso as datas sejam diferentes.
     * 
     * @author Alexandre Belem
     */
    public static boolean isDataInitialEqualDataEnd(Date dateInitial, Date dateEnd){
    	if ( dateInitial == null || dateEnd == null ){
    		return false;
    	}
    	
    	if ( dateEnd.compareTo(dateInitial) == 0 ){
    		return true;
    	}else{
    		return false;
    	}
    }
    
    /**
     * Método para verificar se uma dataEnd fornecida
     * é maior ou igual a uma dateInitial.
     * 
     * @param dateInitial
     * @param dateEnd
     * @return boolean 
     * 
     * @author Alexandre Belem
     */
    public static boolean isDateEndGreatOrEqualDateInitial(Date dateInitial, Date dateEnd){
    	
    	if ( dateInitial == null || dateEnd == null ){
    		return false;
    	}
    	
    	if ( dateEnd.compareTo(dateInitial) > 0 ) {
    		return true;
    	}else if ( dateEnd.compareTo(dateInitial) == 0) {
    		return true;
    	}else{
    		return false;
    	}
    	
    }
    
	/**
	 * Método para validar um intervalo de datas,
	 * dataBegin e dataEnd, todas elas passadas em
	 * String. Deve-se passar a máscara já carregada em
	 * um SimpleDateFormat.
	 * Ex: 
	 * SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	 * isIntervalDateValid("02/02/2007", "03/02/2007", format); 
	 * 
	 * <pre>
	 * 	isIntervalDateValid("01/02/2007", "02/02/2007", format) = true;
	 *  isIntervalDateValid("02/02/2007", "02/02/2007", format) = true;
	 *  isIntervalDateValid("03/02/2007", "02/02/2007", format) = false;
	 *  isIntervalDateValid("03-12-2007", "02/02/2008", format) = false; ( Porque dataInitial está diferente da mascara );
	 * </pre>
	 * @param dataBegin
	 * @param dataEnd
	 * @param dateFormat
	 * @author Alexandre Belem
	 * 
	 */
	public static boolean isIntervalDateValid(String dataBegin, String dataEnd, 
			SimpleDateFormat dateFormat){
		
		Date dateBegin = null;
		Date dateEnd = null;
		try{
			dateBegin = dateFormat.parse(dataBegin);
			dateEnd = dateFormat.parse(dataEnd);
		}catch (ParseException e){
			e.printStackTrace();
			return false;
		}
		
		if ( isDateEndGreatOrEqualDateInitial(dateBegin, dateEnd)){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Método para validar se uma data informada é 
	 * válida.
	 * Esse método utiliza-se do recurso do SimpleDateFormat;
	 * 
	 * <pre>
	 * 	   isValidDate("02/02/2007", sdf) = true;
	 *     isValidDate("02-02-2007", sdf) = false;
     *     isValidDate(null, sdf ) = false;
     *     isValidDate("", sdf) = false;
     *     isValidDate(" ", sdf) = false;
	 * </pre>
	 * @param data
	 * @param format
	 * @return boolean
	 * @author Alexandre Belem
	 * 
	 */
	public static boolean isValidDate(String data, SimpleDateFormat format){
		Date date;
		if ( data == null || data.trim().equals("")){
			return false;
		}
		
		try{
			date = format.parse(data);
		}catch(ParseException e){
			return false;
		}
		return true;
	}

}
