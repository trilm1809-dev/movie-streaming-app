package com.moviestreamingapp.server.dtos.response;

import com.moviestreamingapp.server.entities.Video;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoResponse {
    private long id;
    private String title;
    private String description;
    private Integer year;
    private String rating;

    private Integer duration;
    private String src;
    private String poster;
    private boolean published;

    private List<String> categories;
    private Instant createAt;
    private Instant updateAt;
    private Boolean isInWatchlist;

    public VideoResponse(
            Long id,
            String title,
            String description,
            Integer year,
            String rating,
            Integer duration,
            String src,
            String poster,
            boolean published,
            List<String> categories,
            Instant createAt,
            Instant updateAt
            ){
            this.id = id;
            this.title = title;
            this.description = description;
            this.year = year;
            this.rating = rating;
            this.duration = duration;
            this.src = src;
            this.poster = poster;
            this.published = published;
            this.categories = categories;
            this.createAt = createAt;
            this.updateAt = updateAt;
            this.isInWatchlist = false;
    }

    public static VideoResponse fromEntity(Video video) {
        VideoResponse response = new VideoResponse(
                video.getId(),
                video.getTitle(),
                video.getDescription(),
                video.getYear(),
                video.getRating(),
                video.getDuration(),
                video.getSrc(),
                video.getPoster(),
                video.getPublished(),
                video.getCategories(),
                video.getCreateAt(),
                video.getUpdateAt()
        );
        if(video.getIsInWatchList() != null) {
            response.setIsInWatchlist(video.getIsInWatchList());}
        return response;
    }
}
