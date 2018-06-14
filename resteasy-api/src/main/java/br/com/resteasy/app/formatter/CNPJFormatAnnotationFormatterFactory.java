package br.com.resteasy.app.formatter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.AnnotationFormatterFactory;
import org.springframework.format.Parser;
import org.springframework.format.Printer;

public class CNPJFormatAnnotationFormatterFactory implements AnnotationFormatterFactory<CNPJFormat> {

	@Override
	public Set<Class<?>> getFieldTypes() {
		return new HashSet<>(Arrays.asList(Long.class));
	}

	@Override
	public Printer<?> getPrinter(CNPJFormat annotation, Class<?> fieldType) {
		return getCNPJFormatter(annotation, fieldType);
	}

	@Override
	public Parser<?> getParser(CNPJFormat annotation, Class<?> fieldType) {
		return getCNPJFormatter(annotation, fieldType);
	}
	
	private CNPJFormatter getCNPJFormatter (CNPJFormat annotation, Class<?> fieldType) {
		CNPJFormatter formatter = new CNPJFormatter();
        return formatter;
    }

}
