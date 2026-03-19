package com.moviestreamingapp.server.dao;

import com.moviestreamingapp.server.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
