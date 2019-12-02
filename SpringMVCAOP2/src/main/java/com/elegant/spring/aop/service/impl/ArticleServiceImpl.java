package com.elegant.spring.aop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.elegant.spring.aop.dao.ArticleDAO;
import com.elegant.spring.aop.entity.Article;
import com.elegant.spring.aop.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleDAO articleDAO;

	public void setArticleDAO(ArticleDAO articleDAO) {
		this.articleDAO = articleDAO;
	}

	@Override
	@Transactional
	public void addArticle(Article article) {
		this.articleDAO.addArticle(article);
	}

	@Override
	@Transactional
	public void updateArtcile(Article article) {
		this.articleDAO.updateArtcile(article);
	}

	@Override
	@Transactional
	public List<Article> articleList() {
		System.out.println("from ArticleServiceImpl calling");
		return this.articleDAO.articleList();
	}

	@Override
	@Transactional
	public void deleteArticle(Article article) {
		this.articleDAO.deleteArticle(article);
	}

	@Override
	@Transactional
	public Article getAtricleById(int id) {
		return articleDAO.getAtricleById(id);
	}
}
