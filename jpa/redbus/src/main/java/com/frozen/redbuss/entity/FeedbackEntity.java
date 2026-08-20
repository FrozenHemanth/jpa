package com.frozen.redbuss.entity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Getter
@Setter
@Entity
@Table(name = "FeedbackEntity")
public class FeedbackEntity {

   private Integer rating;
   @Column(name = "comment")
   private String comment;

}
