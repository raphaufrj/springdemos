package br.com.resteasy.app.utils;


import java.text.Normalizer;

import java.util.Arrays;


public class StringUtils {


    /**
     *
     * @param String s
     * @param int n
     * @param char c
     * @return String
     */
    public static String padRight(String s, int n, char c) {
        if (s == null) {
            s = "";
        }
        int add = n - s.length();
        if (add <= 0) {
            return s;
        }
        StringBuffer str = new StringBuffer(s);
        char[] ch = new char[add];
        Arrays.fill(ch, c);
        str.append(ch);
        return str.toString();
    }

    public static String padRight(Integer i, int n, char c) {
        if (i == null) {
            i = 0;
        }
        return padRight(i.toString(), n, c);
    }

    public static String padRight(Long i, int n, char c) {
        if (i == null) {
            i = new Long(0);
        }
        return padRight(i.toString(), n, c);
    }

    public static String padLeft(String s, int n, char c) {
        if (s == null) {
            s = "";
        }
        int add = n - s.length();
        if (add <= 0) {
            return s;
        }
        StringBuffer str = new StringBuffer(s);
        char[] ch = new char[add];
        Arrays.fill(ch, c);
        str.insert(0, ch);
        return str.toString();
    }

    public static String padLeft(Integer i, int n, char c) {
        if (i == null) {
            i = 0;
        }
        return padLeft(i.toString(), n, c);
    }

    public static String padLeft(Long l, int n, char c) {
        if (l == null) {
            l = new Long(0);
        }
        return padLeft(l.toString(), n, c);
    }

    public static String removerAcento(String acentuada) {
        CharSequence cs = new StringBuilder(acentuada);

        String retorno =
            Normalizer.normalize(cs, Normalizer.Form.NFKD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
        return retorno;
    }

    public static String zeroEsquerda(Integer valor, int tamanho) {
        return zeroEsquerda(valor.toString(), tamanho);
    }

    public static String zeroEsquerda(String valor, int tamanho) {
        String retorno;
        retorno = valor;
        while (retorno.length() < tamanho) {
            retorno = "0" + retorno;
        }
        return retorno;
    }

    public static boolean strIsNumber(String texto) {
        String[] split = texto.split("");
        boolean isNumber = true;
        int i = 1;
        while (isNumber && i < split.length) {
            isNumber = Character.isDigit(split[i].charAt(0));
            i++;
        }
        return isNumber;
    }
    
    public static Long extractStrInNumber(String texto) {
    	String strRetorno = "";
        String[] split = texto.split("");
        boolean isNumber = true;
        int i = 1;
        while (i < split.length) {
            isNumber = Character.isDigit(split[i].charAt(0));
            if (isNumber) {
            	strRetorno += split[i];
            }
            i++;
        }
        return Long.parseLong(strRetorno);
    }


    public static String replicate(char texto, int tamanho) {
        String retorno = "";
        for (int i = 0; i < tamanho; i++) {
            retorno += texto;
        }
        return retorno;
    }

    public static String space(int tamanho) {
        return replicate(' ', tamanho);
    }

}

