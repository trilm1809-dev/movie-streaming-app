package com.moviestreamingapp.server.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.moviestreamingapp.server.enums.Role;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@ToString
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(nullable = false)
    private boolean active = true;

    @Column(nullable = false)
    private boolean emailVerified = false;

    @Column
    private String verificationToken;

    @Column
    private Instant verificationExpiry;

    @Column
    private String passwordResetToken;

    @Column
    private Instant passwordResetExpiry;

    @Column
    @CreationTimestamp
    private Instant createAt;

    @Column()
    @UpdateTimestamp
    private Instant updateAt;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "user_watchlist"
            , joinColumns = @JoinColumn(name = "user_id")
            ,inverseJoinColumns = @JoinColumn(name = "video_id")

    )
    private Set<Video> watchlist = new HashSet<>();

    public void addToWatchlist(Video video) {
        this.watchlist.add(video);
    }

    public void removeFromWatchlist(Video video) {

    }


}
