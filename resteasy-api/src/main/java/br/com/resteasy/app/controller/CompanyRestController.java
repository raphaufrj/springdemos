package br.com.resteasy.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.resteasy.app.entity.Company;
import br.com.resteasy.app.service.CompanyService;
import br.com.resteasy.app.web.events.PaginatedResultsRetrievedEvent;
import br.com.resteasy.app.web.exception.ResourceNotFoundException;

@RestController
public class CompanyRestController extends BaseController {

	@Autowired
	private CompanyService companyService;

	@Autowired
	private ApplicationEventPublisher eventPublisher;

	@RequestMapping(value = "/company", params = { "page", "size" }, method = RequestMethod.GET)
	public Page<Company> getAllCompanies(@RequestParam("page") int page, @RequestParam("size") int size,
			UriComponentsBuilder uriBuilder, HttpServletResponse response) {

		Page<Company> resultPage = companyService.findPaginated(page, size);

		 if( page > resultPage.getTotalPages() ) {
			 throw new ResourceNotFoundException();
		 }

		eventPublisher.publishEvent(new PaginatedResultsRetrievedEvent<Company>(Company.class, uriBuilder, response,
				page, resultPage.getTotalPages(), size));

		return resultPage;
	}

	@RequestMapping("/company/{id}")
	public Company getCompany(@PathVariable String id) {

		return companyService.getCompany(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/company")
	public void addCompany(@RequestBody Company company) {
		companyService.addCompany(company);

	}

	@RequestMapping(method = RequestMethod.PUT, value = "/company/{id}")
	public void updateCompany(@RequestBody Company company, @PathVariable String id) {
		companyService.updateCompany(id, company);

	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/company/{id}")
	public void deleteCompany(@PathVariable String id) {
		companyService.deleteCompany(id);
	}
}
