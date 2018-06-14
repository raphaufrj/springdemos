package br.com.resteasy.app.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import br.com.resteasy.app.utils.StringUtils;

public class PhoneFormatter implements Formatter<Integer> {
	

	@Override
	public Integer parse(String text, Locale locale) throws ParseException {
		
		Long phoneLong = StringUtils.extractStrInNumber(text);
		return phoneLong.intValue();
	}

	@Override
	public String print(Integer phone, Locale locale) {
		String strPhone = (phone != null) ? String.valueOf( phone ).replaceFirst("(\\d{2})(\\d{4})(\\d{4})", "($1)$2-$3") : "";
		return strPhone;
	}

}
