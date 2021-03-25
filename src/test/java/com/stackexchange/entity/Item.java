package com.stackexchange.entity;


public class Item {
    public Owner owner;
    public boolean is_accepted;
    public int score;
    public int last_activity_date;
    public int creation_date;
    public int answer_id;
    public int question_id;
    public String content_license;
    public int last_edit_date;

    public Item(Owner owner, boolean is_accepted, int score, int last_activity_date, int creation_date, int answer_id, int question_id, String content_license, int last_edit_date) {
        this.owner = owner;
        this.is_accepted = is_accepted;
        this.score = score;
        this.last_activity_date = last_activity_date;
        this.creation_date = creation_date;
        this.answer_id = answer_id;
        this.question_id = question_id;
        this.content_license = content_license;
        this.last_edit_date = last_edit_date;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public boolean isIs_accepted() {
        return is_accepted;
    }

    public void setIs_accepted(boolean is_accepted) {
        this.is_accepted = is_accepted;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLast_activity_date() {
        return last_activity_date;
    }

    public void setLast_activity_date(int last_activity_date) {
        this.last_activity_date = last_activity_date;
    }

    public int getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(int creation_date) {
        this.creation_date = creation_date;
    }

    public int getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(int answer_id) {
        this.answer_id = answer_id;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public String getContent_license() {
        return content_license;
    }

    public void setContent_license(String content_license) {
        this.content_license = content_license;
    }

    public int getLast_edit_date() {
        return last_edit_date;
    }

    public void setLast_edit_date(int last_edit_date) {
        this.last_edit_date = last_edit_date;
    }

    @Override
    public String toString() {
        return "Item{" +
                "owner=" + owner +
                ", is_accepted=" + is_accepted +
                ", score=" + score +
                ", last_activity_date=" + last_activity_date +
                ", creation_date=" + creation_date +
                ", answer_id=" + answer_id +
                ", question_id=" + question_id +
                ", content_license='" + content_license + '\'' +
                ", last_edit_date=" + last_edit_date +
                '}';
    }
}
