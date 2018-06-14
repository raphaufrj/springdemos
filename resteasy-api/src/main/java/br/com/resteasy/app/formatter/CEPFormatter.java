package br.com.resteasy.app.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

public class CEPFormatter implements Formatter<Integer> {

	@Override
	public Integer parse(String text, Locale locale) throws ParseException {

		if (text != null && !text.equals("")) {
			String s = text.replaceAll("\\.", "").replaceAll("\\-", "").replaceAll("/", "");
			return (Integer.parseInt(s));

		}

		return null;
	}

	@Override
	public String print(Integer cep, Locale locale) {
		String strCEP = (cep != null) ? String.valueOf(cep).replaceFirst("(\\d{5})(\\d{3})(\\d{3})(\\d{4})(\\d{2})", "$1-$2")
				: "";
		return strCEP;
	}
}
