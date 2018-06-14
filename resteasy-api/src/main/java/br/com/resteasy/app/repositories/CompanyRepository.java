package br.com.resteasy.app.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.resteasy.app.entity.Company;

public interface CompanyRepository extends MongoRepository<Company, String>{

}
