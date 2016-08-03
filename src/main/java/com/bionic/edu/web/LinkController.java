package com.bionic.edu.web;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.bionic.edu.proc.category.Category;
import com.bionic.edu.proc.category.CategoryService;
import com.bionic.edu.proc.link.Link;
import com.bionic.edu.proc.link.LinkService;

@Controller
@RequestMapping("/links")
public class LinkController  {
	List<Link> listOfLinks = null;
	List<Category> listOfCategories = null;
	@Inject
	LinkService linkService;
	@Inject
	CategoryService categoryService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String showList(ModelMap model) {
		listOfLinks = linkService.showAll();
		listOfCategories = categoryService.showListCategories();
		model.addAttribute("categoryList", listOfCategories);
		model.addAttribute("linkList", listOfLinks);
		return "listOfLinks";
	}

	@RequestMapping(value = "/newLink", method = RequestMethod.GET)
	public String newLink(ModelMap model) {
		model.addAttribute("link", new Link());
		listOfCategories = categoryService.showListCategories();
		model.addAttribute("categoryList", listOfCategories);
		return "newLink";
	}

	@RequestMapping(value = "/{linkId}", method = RequestMethod.GET)
	public String editLink(@PathVariable String linkId, ModelMap model) {
		int id = Integer.valueOf(linkId);
		Link link = linkService.findById(id);
		List<Category> currentCategories = link.getCategories();
		model.addAttribute("currentCategories", currentCategories);
		listOfCategories = categoryService.showListCategories();
		model.addAttribute("categoryList", listOfCategories);
		//model.addAttribute("categoryList", link.getCategories());
		model.addAttribute("link", link);
		return "newLink";
	}
	
	@RequestMapping(value = "/delete{linkId}", method = RequestMethod.GET)
	public String removeLink(@PathVariable String linkId, ModelMap model) {
		int id = Integer.valueOf(linkId);
		Link link = linkService.findById(id);
		linkService.removeLink(id);
		listOfLinks = linkService.showAll();
		model.addAttribute("linkList", listOfLinks);
		model.addAttribute("categoryList", link.getCategories());
		return "listOfLinks";
	}

	@RequestMapping(value = "/addLink", method = RequestMethod.POST)
	public String addLink(@Valid @ModelAttribute("link") Link link, BindingResult bindingResult, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) {
		if (bindingResult.hasErrors()) {
			listOfCategories = categoryService.showListCategories();
			model.addAttribute("categoryList", listOfCategories);
			return "newLink";
		}
		String[] ar = request.getParameterValues("categoryChoice");
		ArrayList<Category> listToSave = new ArrayList<>();
		for(int i  = 0;i < ar.length; i++ ){
			listToSave.add(categoryService.findByCategoryName(ar[i]));
		}
		link.setCategories(listToSave);
		linkService.saveLink(link);
		listOfLinks = linkService.showAll();
		model.addAttribute("linkList", listOfLinks);
		listOfCategories = categoryService.showListCategories();
		model.addAttribute("categoryList", listOfCategories);
		return "listOfLinks";
	}

	@RequestMapping(value = "/findByDesc", method = RequestMethod.POST)
	public String findByWord(@Valid @ModelAttribute("link") Link link, BindingResult bindingResult, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) {
		String findByWord = request.getParameter("findByWord");
		listOfLinks = linkService.findByDesc(findByWord);
		listOfCategories = categoryService.showListCategories();
		model.addAttribute("categoryList", listOfCategories);
		model.addAttribute("linkList", listOfLinks);
		return "listOfLinks";
	}

	@RequestMapping(value = "/findByLanguage", method = RequestMethod.POST)
	public String findByLanguage(@Valid @ModelAttribute("link") Link link, BindingResult bindingResult, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) {
		String findByLang = request.getParameter("language");
		listOfCategories = categoryService.showListCategories();
		model.addAttribute("categoryList", listOfCategories);
		listOfLinks = linkService.findByLang(findByLang);
		model.addAttribute("linkList", listOfLinks);
		return "listOfLinks";
	}

	@RequestMapping(value = "/findByIsFinished", method = RequestMethod.POST)
	public String findByIsFinished(@Valid @ModelAttribute("link") Link link, BindingResult bindingResult,
			ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		String findByStatus = request.getParameter("isFinished");
		listOfCategories = categoryService.showListCategories();
		model.addAttribute("categoryList", listOfCategories);
		listOfLinks = linkService.findByIsFinished(findByStatus);
		model.addAttribute("linkList", listOfLinks);
		return "listOfLinks";
	}

	@RequestMapping(value = "/orderBy", method = RequestMethod.POST)
	public String orderByCreatedUp(@Valid @ModelAttribute("link") Link link, BindingResult bindingResult,
			ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		String dir = request.getParameter("orderDirect");
		String field = request.getParameter("orderBySmth");
		listOfCategories = categoryService.showListCategories();
		model.addAttribute("categoryList", listOfCategories);
		listOfLinks = linkService.orderBy(dir, field);
		model.addAttribute("linkList", listOfLinks);
		return "listOfLinks";
	}

	@RequestMapping(value = "/findByCategory", method = RequestMethod.POST)
	public String showByCategory(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("categoryChoice");
		Category ob = categoryService.findByCategoryName(name);
		listOfLinks = linkService.findByCategoryName(ob);
		model.addAttribute("linkList", listOfLinks);
		listOfCategories = categoryService.showListCategories();
		model.addAttribute("categoryList", listOfCategories);
		return "listOfLinks";
	}
	
	@RequestMapping(value = "/orderByDate", method = RequestMethod.POST)
	public String orderByDate(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		String from = request.getParameter("SnapHost_Calendar");
		String to = request.getParameter("SnapHost_Calendar2");
		listOfLinks = linkService.findByDateBetween(java.sql.Date.valueOf(from), 
				java.sql.Date.valueOf(to));
		model.addAttribute("linkList", listOfLinks);
		return "listOfLinks";
	}

}
