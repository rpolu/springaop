package com.elegant.spring.aop.dao;

import java.util.List;

import com.elegant.spring.aop.entity.Article;

public interface ArticleDAO {

	public void addArticle(Article article);

	public void updateArtcile(Article article);

	public List<Article> articleList();

	public void deleteArticle(Article article);

	public Article getAtricleById(int id);
}
