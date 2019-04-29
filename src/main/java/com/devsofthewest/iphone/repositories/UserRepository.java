package com.devsofthewest.iphone.repositories;

import java.util.List;

import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository;

import com.devsofthewest.iphone.model.User;

public interface UserRepository extends DatastoreRepository<User, String> {
}
