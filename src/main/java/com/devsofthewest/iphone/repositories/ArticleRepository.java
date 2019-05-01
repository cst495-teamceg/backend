package com.devsofthewest.iphone.repositories;

import java.util.List;

import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository;

import com.devsofthewest.iphone.model.Article;

public interface ArticleRepository extends DatastoreRepository<Article, Long> {
}
