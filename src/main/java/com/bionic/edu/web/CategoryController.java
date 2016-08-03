package com.bionic.edu.web;

import java.util.List;
import javax.inject.Inject;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bionic.edu.proc.category.Category;

import com.bionic.edu.proc.category.CategoryDao;

@Controller
@RequestMapping("/categories")
public class CategoryController {
	List<Category> list = null;
	@Inject
	CategoryDao service;

	@RequestMapping(value = "/newCategory", method = RequestMethod.GET)
	public String newCategory(ModelMap model) {
		model.addAttribute("category", new Category());
		return "newCategory";
	}

	@RequestMapping(value = "/listC", method = RequestMethod.GET)
	public String showCategories(ModelMap model) {
		list = service.showListCategories();
		model.addAttribute("category", new Category());
		model.addAttribute("categoryList", list);
		return "newCategory";
	}

	@RequestMapping(value = "/addCategory", method = RequestMethod.POST)
	public String addLink(@Valid @ModelAttribute("category") Category category, BindingResult bindingResult,
			ModelMap model) {
		if (bindingResult.hasErrors()) {
			return "newCategory";
		}
		service.saveCategory(category);
		list = service.showListCategories();
		model.addAttribute("categoryList", list);
		return "newCategory";
	}

}
