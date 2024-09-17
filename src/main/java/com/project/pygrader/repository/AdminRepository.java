package com.project.pygrader.repository;

import com.project.pygrader.entity.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AdminRepository extends MongoRepository<Admin, String> {
}
