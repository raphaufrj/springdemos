package br.com.resteasy.app.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.resteasy.app.entity.Company;
import br.com.resteasy.app.entity.Pager;
import br.com.resteasy.app.service.CompanyService;
import br.com.resteasy.app.validators.CompanyValidator;

/**
 * 
 * @author eds
 *
 */

@Controller
public class CompanyController extends BaseController {
	
	@Autowired
	private CompanyService companyService;

	@Autowired
	private CompanyValidator companyValidator;
	
    private static final int BUTTONS_TO_SHOW = 5;
    private static final int INITIAL_PAGE = 0;
    private static final int INITIAL_PAGE_SIZE = 5;
    private static final int[] PAGE_SIZES = {5, 10, 20};


    @RequestMapping(value={"/companyEdit","/companyEdit/{id}"}, method = RequestMethod.GET)
    public String companyEditForm(Model model, @PathVariable(required = false, name = "id") String id) {
        if (null != id) {
            model.addAttribute("company", companyService.getCompany(id));
        } else {
            model.addAttribute("company", new Company());
        }
        return "companyEdit";
    }

    @RequestMapping(value="/companyEdit", method = RequestMethod.POST)
    public String companyEdit(Model model, @Valid Company company, BindingResult result) {
    	companyValidator.validate(company, result);
		if(result.hasErrors()){
			return "companyEdit";
		}
    	
    	if (company.isNew())
    		companyService.addCompany(company);
    	else
    		companyService.updateCompany(company.getId(), company);
    	
        return "redirect:/app/companiesList";
    }

    @RequestMapping(value="/companyDelete/{id}", method = RequestMethod.GET)
    public String notesDelete(Model model, @PathVariable(required = true, name = "id") String id) {
    	companyService.deleteCompany(id);
        
    	return "redirect:/app/companiesList";
    }
    
    @RequestMapping(value="/companiesList", method = RequestMethod.GET)
    public String showCompaniesPage(Model model, @RequestParam("pageSize") Optional<Integer> pageSize,
                                        @RequestParam("page") Optional<Integer> page) {

        int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
        int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;

        Page<Company> companies = companyService.findPaginated(evalPage, evalPageSize);
        Pager pager = new Pager(companies.getTotalPages(), companies.getNumber(), BUTTONS_TO_SHOW);

        model.addAttribute("companies", companies);
        model.addAttribute("selectedPageSize", evalPageSize);
        model.addAttribute("pageSizes", PAGE_SIZES);
        model.addAttribute("pager", pager);
        
        return "companiesList";
    }
    
}
