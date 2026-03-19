package com.moviestreamingapp.server.dao;

import com.moviestreamingapp.server.entities.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Long> {
}
