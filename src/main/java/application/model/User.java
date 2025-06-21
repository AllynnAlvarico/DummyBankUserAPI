package application.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "users")
public record User(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id,
        String userId,
        String username,
        String password,
        @CreationTimestamp LocalDateTime createdAt
) {

    public User {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(userId, "userId must not be null");
        Objects.requireNonNull(username, "username must not be null");
        Objects.requireNonNull(password, "password must not be null");
        Objects.requireNonNull(createdAt, "createdAt must not be null");
    }

    public static class Builder {

        private long id;
        private String userId;
        private String username;
        private String password;
        private LocalDateTime createdAt;


        public Builder  Id(long id) {
            this.id = id;
            return this;
        }

        public Builder  userId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder  username(String username) {
            this.username = username;
            return this;
        }

        public Builder  password(String password) {
            this.password = password;
            return this;
        }

        public Builder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public User build(){
            return new User(this.id, this.userId, this.username, this.password, this.createdAt);
        }
        public Builder from(User existingUser) {
            return new Builder()
                    .Id(existingUser.id())
                    .userId(existingUser.userId())
                    .username(existingUser.username())
                    .password(existingUser.password())
                    .createdAt(existingUser.createdAt());
        }
    }


}
