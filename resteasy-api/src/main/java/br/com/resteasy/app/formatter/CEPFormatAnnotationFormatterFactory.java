package br.com.resteasy.app.formatter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.AnnotationFormatterFactory;
import org.springframework.format.Parser;
import org.springframework.format.Printer;

public class CEPFormatAnnotationFormatterFactory implements AnnotationFormatterFactory<CEPFormat> {

	@Override
	public Set<Class<?>> getFieldTypes() {
		return new HashSet<>(Arrays.asList(Integer.class));
	}

	@Override
	public Printer<?> getPrinter(CEPFormat annotation, Class<?> fieldType) {
		return getCEPFormat(annotation, fieldType);
	}

	@Override
	public Parser<?> getParser(CEPFormat annotation, Class<?> fieldType) {
		return getCEPFormat(annotation, fieldType);
	}
	
	private CEPFormatter getCEPFormat (CEPFormat annotation, Class<?> fieldType) {
		CEPFormatter formatter = new CEPFormatter();
        return formatter;
    }
	

}
