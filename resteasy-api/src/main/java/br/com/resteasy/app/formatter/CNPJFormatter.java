package br.com.resteasy.app.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

public class CNPJFormatter implements Formatter<Long> {

	@Override
	public Long parse(String text, Locale locale) throws ParseException {

		if (text != null && !text.equals("")) {
			String s = text.replaceAll("\\.", "").replaceAll("\\-", "").replaceAll("/", "");
			return (Long.parseLong(s));

		}

		return 0L;
	}

	@Override
	public String print(Long cnpj, Locale locale) {
		String strCNPJ = (cnpj != null) ? String.valueOf(cnpj).replaceFirst("(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})", "$1.$2.$3/$4-$5")
				: "";
		return strCNPJ;
	}

}