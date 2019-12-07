package Community.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Community.model.Categories;
import Community.model.Category;
import Community.service.CategoryService;

@RestController
public class CategoriesController {
	public static final Logger logger = LoggerFactory.getLogger(CategoriesController.class);

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(path = "/api/categories")
	public Categories getAll() {
		List<Category> list=  categoryService.getAll();
		Categories cat = new Categories();
		cat.setCategories(list);
		return cat;
	}
}
