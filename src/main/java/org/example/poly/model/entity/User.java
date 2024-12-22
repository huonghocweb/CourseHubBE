package org.example.poly.model.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Integer userId;

    @Column(name="user_name")
    private String userName;

    @Column(name="full_name")
    private String fullName;

    @Column(name="password")
    private String password;

    @Column(name="gender")
    private Boolean gender;

    @Column(name="address")
    private String address;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name="image_url")
    private String imageUrl;

    @Column(name="birthday")
    private LocalDate birthday;

    @Column(name="email")
    private String email;

    @Column(name="status")
    private Boolean status;

    @ManyToMany
    @JoinTable(
            name =  "user_role",
            inverseJoinColumns = @JoinColumn(name= "user_id"),
            joinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;


    @JsonIgnore
    @OneToMany(mappedBy="user")
    private List<ReviewCourse> reviewCourses;


    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Answers> answers;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<QuizAttempt> quizAttempts;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Enrollment> enrollments;

}
