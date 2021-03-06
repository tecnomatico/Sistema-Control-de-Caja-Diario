/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.controlcaja.util;

/**
 *
 * @author joel
 */

import java.math.BigDecimal;
    import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Esta clase provee la funcionalidad de convertir un numero representado en
 * digitos a una representacion en letras. Mejorado para leer centavos
 * 
 * @author Camilo Nova
 */
public abstract class NumberToLetterConverter {

    private static final String[] UNIDADES = { "", "UN ", "DOS ", "TRES ",
            "CUATRO ", "CINCO ", "SEIS ", "SIETE ", "OCHO ", "NUEVE ", "DIEZ ",
            "ONCE ", "DOCE ", "TRECE ", "CATORCE ", "QUINCE ", "DIECISEIS",
            "DIECISIETE", "DIECIOCHO", "DIECINUEVE", "VEINTE" };

    private static final String[] DECENAS = { "VENTI", "TREINTA ", "CUARENTA ",
            "CINCUENTA ", "SESENTA ", "SETENTA ", "OCHENTA ", "NOVENTA ",
            "CIEN " };

    private static final String[] CENTENAS = { "CIENTO ", "DOSCIENTOS ",
            "TRESCIENTOS ", "CUATROCIENTOS ", "QUINIENTOS ", "SEISCIENTOS ",
            "SETECIENTOS ", "OCHOCIENTOS ", "NOVECIENTOS " };

    /**
     * Convierte a letras un numero de la forma $123,456.32
     * 
     * @param number
     *            Numero en representacion texto
     * @throws NumberFormatException
     *             Si valor del numero no es valido (fuera de rango o )
     * @return Numero en letras
     */
    public static String convertNumberToLetter(String number)
            throws NumberFormatException {
        return convertNumberToLetter(Double.parseDouble(number));
    }

    /**
     * Convierte un numero en representacion numerica a uno en representacion de
     * texto. El numero es valido si esta entre 0 y 999'999.999
     * 
     * @param number
     *            Numero a convertir
     * @return Numero convertido a texto
     * @throws NumberFormatException
     *             Si el numero esta fuera del rango
     */
    public static String convertNumberToLetter(double doubleNumber)
            throws NumberFormatException {

        StringBuilder converted = new StringBuilder();

        String patternThreeDecimalPoints = "#.###";

        DecimalFormat format = new DecimalFormat(patternThreeDecimalPoints);
        format.setRoundingMode(RoundingMode.DOWN);

        // formateamos el numero, para ajustarlo a el formato de tres puntos
        // decimales
        String formatedDouble = format.format(doubleNumber);
        doubleNumber = Double.parseDouble(formatedDouble);

        // Validamos que sea un numero legal
        if (doubleNumber > 999999999)
            throw new NumberFormatException(
                    "El numero es mayor de 999'999.999, "
                            + "no es posible convertirlo");

        if (doubleNumber < 0)
            throw new NumberFormatException("El numero debe ser positivo");

        String splitNumber[] = String.valueOf(doubleNumber).replace('.', '#')
                .split("#");

        // Descompone el trio de millones
        int millon = Integer.parseInt(String.valueOf(getDigitAt(splitNumber[0],
                8))
                + String.valueOf(getDigitAt(splitNumber[0], 7))
                + String.valueOf(getDigitAt(splitNumber[0], 6)));
        if (millon == 1)
            converted.append("UN MILLON ");
        else if (millon > 1)
            converted.append(convertNumber(String.valueOf(millon))
                    + "MILLONES ");

        // Descompone el trio de miles
        int miles = Integer.parseInt(String.valueOf(getDigitAt(splitNumber[0],
                5))
                + String.valueOf(getDigitAt(splitNumber[0], 4))
                + String.valueOf(getDigitAt(splitNumber[0], 3)));
        if (miles == 1)
            converted.append("MIL ");
        else if (miles > 1)
            converted.append(convertNumber(String.valueOf(miles)) + "MIL ");

        // Descompone el ultimo trio de unidades
        int cientos = Integer.parseInt(String.valueOf(getDigitAt(
                splitNumber[0], 2))
                + String.valueOf(getDigitAt(splitNumber[0], 1))
                + String.valueOf(getDigitAt(splitNumber[0], 0)));
        if (cientos == 1)
            converted.append("UN");

        if (millon + miles + cientos == 0)
            converted.append("CERO");
        if (cientos > 1)
            converted.append(convertNumber(String.valueOf(cientos)));

        // ---modificar para que sea pesos----------------
        converted.append("");

        // Descompone los centavos
        int centavos = Integer.parseInt(String.valueOf(getDigitAt(
                splitNumber[1], 2))
                + String.valueOf(getDigitAt(splitNumber[1], 1))
                + String.valueOf(getDigitAt(splitNumber[1], 0)));
        if (centavos == 1)
            converted.append(" CON UN CENTAVO");
        else if (centavos > 1)
            converted.append(" CON " + convertNumber(String.valueOf(centavos))
                    + "CENTAVOS");

        return converted.toString();
    }

    /**
     * Convierte los trios de numeros que componen las unidades, las decenas y
     * las centenas del numero.
     * 
     * @param number
     *            Numero a convetir en digitos
     * @return Numero convertido en letras
     */
    private static String convertNumber(String number) {

        if (number.length() > 3)
            throw new NumberFormatException(
                    "La longitud maxima debe ser 3 digitos");

        // Caso especial con el 100
        if (number.equals("100")) {
            return "CIEN";
        }

        StringBuilder output = new StringBuilder();
        if (getDigitAt(number, 2) != 0)
            output.append(CENTENAS[getDigitAt(number, 2) - 1]);

        int k = Integer.parseInt(String.valueOf(getDigitAt(number, 1))
                + String.valueOf(getDigitAt(number, 0)));

        if (k <= 20)
            output.append(UNIDADES[k]);
        else if (k > 30 && getDigitAt(number, 0) != 0)
            output.append(DECENAS[getDigitAt(number, 1) - 2] + "Y "
                    + UNIDADES[getDigitAt(number, 0)]);
        else
            output.append(DECENAS[getDigitAt(number, 1) - 2]
                    + UNIDADES[getDigitAt(number, 0)]);

        return output.toString();
    }

    /**
     * Retorna el digito numerico en la posicion indicada de derecha a izquierda
     * 
     * @param origin
     *            Cadena en la cual se busca el digito
     * @param position
     *            Posicion de derecha a izquierda a retornar
     * @return Digito ubicado en la posicion indicada
     */
    private static int getDigitAt(String origin, int position) {
        if (origin.length() > position && position >= 0)
            return origin.charAt(origin.length() - position - 1) - 48;
        return 0;
    }

    /**
     * 
     * @param pesos cantidad d dinero ingresado
     * @return  la posiscion del punto decimal.
     */
    public static int getIndexPunto(Double pesos){
        int index= 0;
        char punto = '.';
        String pesosString = String.valueOf(pesos);
        for (int i = 0; i < pesosString.length(); i++) {
            if (pesosString.charAt(i) == punto ) {
                index= i+1;
                break;
            }
        }
        return index;
            }
    
    /**
     * 
     * @param pesos cantidad de dinero en el formato xxxxx.xx
     * @return retorna los pesos sin los centavos 
     */
    
    public static int getPesos(Double pesos){
        int centavo=0;
        int index = getIndexPunto(pesos)-1;
        String pesosString = String.valueOf(pesos);
        centavo=  Integer.valueOf(pesosString.substring(0, index)) ;
        return centavo;
    }
    /**
     * 
     * @param pesos cantidad de dinero en el formato xxxxx.xx
     * @return  retorna los centavos que tiene la cantidad ingresada
     */
    
    public static int getCentavos(Double pesos){
        int centavo=0;
        int index = getIndexPunto(pesos);
        String pesosString = String.valueOf(pesos);
        centavo=  Integer.valueOf(pesosString.substring(index)) ;
        return centavo;
    }
    /**
     * 
     * @param pesos  cantidad de dinero en el formato xxxxxx.xx
     * @return  convierte la cantidad de pesos ingresado en numero a string
     */
     public static String getConvertirPesosEnString(Double pesos){
        String pesoConvertido="" ;
        
        String peso =  convertNumberToLetter(getPesos(pesos));
        String centavo =  convertNumberToLetter(getCentavos(pesos));
        
        pesoConvertido= peso+" PESOS CON "+centavo+" CENTAVOS";
        return pesoConvertido;
    }
    /**
     * 
     * @param valor es el numero double  a truncar
     * @param Cantidadcifras cantidad de cifras decimales que tendra el valor
     * @return  un numero de tipo bigDecimal que representa el valor truncado
     */ 
     public static BigDecimal getTruncarDouble(Double valor, int Cantidadcifras){
         String val = String.valueOf(valor);
         BigDecimal big = new BigDecimal(val);
         big = big.setScale(Cantidadcifras, RoundingMode.HALF_UP);
         return big;
     }
     
}
    

