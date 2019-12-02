package com.elegant.spring.aop.service;

import java.util.List;

import com.elegant.spring.aop.entity.Article;

public interface ArticleService {

	public void addArticle(Article article);

	public void updateArtcile(Article article);

	public List<Article> articleList();

	public void deleteArticle(Article article);

	public Article getAtricleById(int id);
}
