package br.com.resteasy.app.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.resteasy.app.entity.Company;

@Component
public class CompanyValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Company.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Company company = (Company) target;
		Long cnpj = company.getCnpj();

		 //User userByEmail = userRepository.findUserByEmail(email);
//		if (cnpj != null) {
//			errors.rejectValue("cnpj", "error.exists", new Object[] { cnpj }, "CNPJ " + cnpj + " already in use");
//			errors.reject("CNPJ " + cnpj + " already in use");
//		}
	}

}
