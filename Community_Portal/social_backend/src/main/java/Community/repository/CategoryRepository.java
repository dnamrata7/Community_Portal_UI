package Community.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import Community.model.Category;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {


}