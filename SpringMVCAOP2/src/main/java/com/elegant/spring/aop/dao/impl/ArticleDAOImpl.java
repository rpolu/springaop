package com.elegant.spring.aop.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.elegant.spring.aop.dao.ArticleDAO;
import com.elegant.spring.aop.entity.Article;

@Repository
public class ArticleDAOImpl implements ArticleDAO {

	@Autowired
	SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void addArticle(Article article) {
		getSession().save(article);
	}

	@Override
	public void updateArtcile(Article article) {
		getSession().update(article);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Article> articleList() {
		return getSession().createQuery("from Article").list();
	}

	@Override
	public void deleteArticle(Article article) {
		getSession().delete(article);
	}

	@Override
	public Article getAtricleById(int id) {
		return (Article) getSession().get(Article.class, new Integer(id));
	}

}
