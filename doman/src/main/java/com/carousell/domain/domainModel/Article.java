package com.carousell.domain.domainModel;

import com.carousell.domain.comm.ResponseMarker;

public class Article {

    private String description;
    private int time_created;
    private int rank;
    private String banner_url;
    private String id;
    private String title;
    private String formateDate;

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTime_created() {
        return this.time_created;
    }

    public void setTime_created(int time_created) {
        this.time_created = time_created;
    }

    public int getRank() {
        return this.rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getBanner_url() {
        return this.banner_url;
    }

    public void setBanner_url(String banner_url) {
        this.banner_url = banner_url;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFormateDate() {
        return formateDate;
    }

    public void setFormateDate(String formateDate) {
        this.formateDate = formateDate;
    }
}
