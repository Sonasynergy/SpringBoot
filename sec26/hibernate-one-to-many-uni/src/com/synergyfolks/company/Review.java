package com.synergyfolks.company;

import javax.persistence.*;

@Entity
@Table(name="review")
public class Review {

    @Id
//    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="comment")
    private String comment;

//    @JoinColumn(name="course_id")
//    private Course courses;

    public Review() {

    }

    public Review(int id,String comment) {
        this.id=id;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

//    public Course getCourses() {
//        return courses;
//    }
//
//    public void setCourses(Course courses) {
//        this.courses = courses;
//    }

    @Override
    public String toString() {
        return "Review [id=" + id + ", comment=" + comment + "]";
    }

}
