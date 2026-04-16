package ru.job4j.bmb.model;

import jakarta.persistence.*;

import java.util.Objects;

/**
 * @author Maksim Merkulov
 * @version 1.0
 */
@Entity
@Table(name = "mb_mood")
public class Mood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    private boolean good;

    public Mood() {
    }

    public Mood(Long id, String text, boolean good) {
        this.id = id;
        this.text = text;
        this.good = good;
    }

    public boolean isGood() {
        return good;
    }

    public void setGood(boolean good) {
        this.good = good;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Mood mood = (Mood) o;
        return Objects.equals(id, mood.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
