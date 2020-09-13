package com.antra.easy_notes.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity //mark the class as a persistent Java class
@Table(name="notes") //what table this entity maps to
@EntityListeners(AuditingEntityListener.class) //we want @CreatedAt and @LastModifiedDate to be populated automatically
@JsonIgnoreProperties(value = {"createAt", "updateAt"}, allowGetters = true) //makes them transient
@Setter
@Getter
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /*Note:
    * There are 3 types @NotNull, @NotEmpty and @NotBlank
    *
    * @NotNull checks the value is not null
    * @NotEmpty makes sure value is not null and length > 0
    * @NotBlank checks the value is not null and not empty(length > 0 && not all spaces)
    * */

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP) //used with java.util.Date and java.util.Calendar classes. It converts the date and time values from Java Object to compatible database type and vice versa.
    @CreatedDate //fill the field with the created date
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate //fill the field with the last modified date
    private Date updatedAt;
}
