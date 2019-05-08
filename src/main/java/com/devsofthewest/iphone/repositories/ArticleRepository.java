package com.devsofthewest.iphone.repositories;

import java.util.List;
import com.google.appengine.api.datastore.Text;
import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository;

import com.devsofthewest.iphone.model.Article;

public class ArticleRepository extends DatastoreRepository<Article, Long> {
}