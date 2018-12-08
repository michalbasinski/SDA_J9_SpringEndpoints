package pl.sda.issuerfinder.model;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface IssuerRuleRepository extends MongoRepository<IssuerRuleEntity, String> {
}
