package Community.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Community.model.Category;
import Community.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	// Retrieve operation
	public List<Category> getAll() {
		return categoryRepository.findAll();
	}

}
