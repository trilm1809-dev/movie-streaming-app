package com.moviestreamingapp.server.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "videos")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(length = 4000)
    private String description;

    private Integer year;
    private String rating;
    private Integer duration;

    @Column(table = "src")
    @JsonIgnore
    private String srcUuid;

    @Column(nullable = false)
    private Boolean published;

    @Column(name = "poster")
    @JsonIgnore
    private String posterUuid;

    @ElementCollection(fetch = FetchType.EAGER)
    @Column(table = "category")
    @CollectionTable(name = "video_category", joinColumns = @JoinColumn(name = "video_id"))
    private List<String> categories = new ArrayList<>();

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Instant createAt;

    @UpdateTimestamp
    @Column(nullable = false)
    private Instant updateAt;



    @Transient
    @JsonProperty("isInWatchList")
    private Boolean isInWatchList;

    @JsonProperty
    public String getSrc(){
        if(srcUuid != null && !srcUuid.isEmpty()){
            String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().toString();
            return baseUrl + "/api/files/video" + srcUuid;
        }
        return null;
    }


    @JsonProperty
    public String getPoster(){
        if(posterUuid != null && !posterUuid.isEmpty()){
            String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().toString();
            return baseUrl + "/api/files/images" + posterUuid;
        }
        return null;
    }
}
