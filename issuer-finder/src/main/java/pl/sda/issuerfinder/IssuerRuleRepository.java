package pl.sda.issuerfinder;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface IssuerRuleRepository extends MongoRepository<IssuerRuleEntity, String> {
}
