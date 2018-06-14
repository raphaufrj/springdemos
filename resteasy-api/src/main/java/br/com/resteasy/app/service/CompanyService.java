package br.com.resteasy.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import br.com.resteasy.app.entity.Company;
import br.com.resteasy.app.repositories.CompanyRepository;

@Service
public class CompanyService extends BaseService{

	@Autowired
    private MongoTemplate mongoTemplate;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	private static final String COLLECTION_NAME = "companies";
	
	public List<Company> getCompanies(){
		
		PageRequest request = getPageRequest(new Sort(Sort.Direction.ASC, "fantasia")); 
		Page<Company> companies = companyRepository.findAll(request);
		return companies.getContent();
	}


	public Page<Company> findPaginated(int page, int size) {
		PageRequest request = getPageRequest(page, size, new Sort(Sort.Direction.ASC, "fantasia")); 
		Page<Company> companies = companyRepository.findAll(request);
		return companies;
	}

	public Company getCompany(String id) {
		Query query = Query.query(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query, Company.class, getCollectionName());
	}

	public void addCompany(Company company) {
		if (company.isNew()) { company.setId(null); }
		mongoTemplate.save(company, getCollectionName());
		
	}

	public void updateCompany(String id, Company company) {
		company.setId(id);
		mongoTemplate.save(company, getCollectionName());

	}

	public void deleteCompany(String id) {
		Query query = Query.query(Criteria.where("_id").is(id));
		mongoTemplate.remove(query, Company.class, getCollectionName());
	}

	@Override
	public String getCollectionName() {
		return COLLECTION_NAME;
	}
}
