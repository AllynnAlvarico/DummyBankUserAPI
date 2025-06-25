package application.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User{

//    public User {
//        Objects.requireNonNull(id, "id must not be null");
//        Objects.requireNonNull(userId, "userId must not be null");
//        Objects.requireNonNull(username, "username must not be null");
//        Objects.requireNonNull(password, "password must not be null");
//        Objects.requireNonNull(createdAt, "createdAt must not be null");
//    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "userID")
    private String userId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime created_at;

    public User() {}

    public User(Long id, String userId, String username, String password, LocalDateTime created_at) {
        this.id = id;
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.created_at = created_at;
    }

    public void setId(Long id) { this.id = id; }

    public void setUserId(String userId) { this.userId = userId; }

    public void setUsername(String username) { this.username = username; }

    public void setPassword(String password) { this.password = password; }

    public void setCreatedAt(LocalDateTime created_at) { this.created_at = created_at; }

    public Long getId() { return id; }

    public String getUserId() { return userId; }

    public String getUsername() { return username; }

    public String getPassword() { return password; }

    public LocalDateTime getCreatedAt() { return created_at; }

    public static class Builder {

        private long id;
        private String userId;
        private String username;
        private String password;
        private LocalDateTime created_at;

        public Builder() {}

        public Builder  Id(long id) {this.id = id;return this;}

        public Builder  userId(String userId) {this.userId = userId;return this;}

        public Builder  username(String username) {this.username = username;return this;}

        public Builder  password(String password) {this.password = password;return this;}

        public Builder createdAt(LocalDateTime created_at) {this.created_at = created_at;return this;}

        public User build(){
            return new User(this.id, this.userId, this.username, this.password, this.created_at);
        }

        public Builder from(User existingUser) {
            return new Builder()
                    .Id(existingUser.getId())
                    .userId(existingUser.getUserId())
                    .username(existingUser.getUsername())
                    .password(existingUser.getPassword())
                    .createdAt(existingUser.getCreatedAt());
        }
    }
}
