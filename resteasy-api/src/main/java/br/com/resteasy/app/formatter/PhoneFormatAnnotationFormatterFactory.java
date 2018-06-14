package br.com.resteasy.app.formatter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.AnnotationFormatterFactory;
import org.springframework.format.Parser;
import org.springframework.format.Printer;

public class PhoneFormatAnnotationFormatterFactory implements AnnotationFormatterFactory<PhoneFormat> {

	@Override
	public Set<Class<?>> getFieldTypes() {
		return new HashSet<>(Arrays.asList(Integer.class));
	}

	@Override
	public Printer<?> getPrinter(PhoneFormat annotation, Class<?> fieldType) {
		return getPhoneFormatter(annotation, fieldType);
	}

	@Override
	public Parser<?> getParser(PhoneFormat annotation, Class<?> fieldType) {
		return getPhoneFormatter(annotation, fieldType);
	}
	
	private PhoneFormatter getPhoneFormatter (PhoneFormat annotation, Class<?> fieldType) {
		PhoneFormatter formatter = new PhoneFormatter();
        return formatter;
    }

}
