package com.elegant.spring.aop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.elegant.spring.aop.entity.Article;
import com.elegant.spring.aop.service.ArticleService;

@Controller
public class ArticleController {

	@Autowired
	private ArticleService articleService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String personIndex(ModelMap model) {
		List<Article> articleList = articleService.articleList();
		model.addAttribute("articleList", articleList);
		return "index";
	}

	@RequestMapping(value = "/articleAdd", method = RequestMethod.POST)
	public String articleAdd(@ModelAttribute("article") Article article) {

		this.articleService.addArticle(article);
		return "redirect:/";
	}

	@RequestMapping(value = "/getArticleUpdate/{id}", method = RequestMethod.GET)
	public ModelAndView getArticleUpdate(@PathVariable("id") int id, ModelMap model) {
		ModelAndView modelAndView = new ModelAndView("update");
		Article article = this.articleService.getAtricleById(id);
		model.addAttribute("article", article);
		return modelAndView;
	}

	@RequestMapping("/articleDelete/{id}")
	public String articleDelete(@PathVariable("id") int id) {
		Article article = new Article();
		article.setId(id);
		this.articleService.deleteArticle(article);
		return "redirect:/";
	}

	@RequestMapping(value = "/articleUpdate", method = RequestMethod.POST)
	public String articleUpdate(@ModelAttribute("article") Article article) {
		this.articleService.updateArtcile(article);
		return "redirect:/";
	}

}