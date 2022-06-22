package ru.mvlikhachev.newsapp.data.api

import ru.mvlikhachev.newsapp.data.db.ArticleDao
import ru.mvlikhachev.newsapp.models.Article
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val newsService: NewsService,
    private val articleDao: ArticleDao
    ) {
    suspend fun getNews(countryCode: String, pageNumber: Int) =
        newsService.getHeadlines(countryCode = countryCode, page = pageNumber)

    suspend fun getSearchNews(query: String, pageNumber: Int) =
        newsService.getEverything(query = query, page = pageNumber)

    fun getFavoriteArticles() = articleDao.getAllArticles()
    suspend fun addToFavotrite(article: Article) = articleDao.insert(article = article)
    suspend fun deleteFromFavotrite(article: Article) = articleDao.delete(article = article)
}