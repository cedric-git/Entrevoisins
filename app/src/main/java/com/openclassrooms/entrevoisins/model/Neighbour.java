package com.openclassrooms.entrevoisins.model;

import java.util.Objects;

/**
 * Model object representing a Neighbour
 */
public class Neighbour {

    /** Identifier */
    private Integer id;

    /** Full name */
    private String name;

    /** Avatar */
    private String avatarUrl;

    /** Adress */
    private String address;

    /** Phone */
    private String phone;

    /** WebSite */
    private String webSite;

    /** About Me */
    private String aboutMe;

    /** Favorite or not */
    private boolean isFavorite;

    /**
     * Constructor
     * @param id
     * @param name
     * @param avatarUrl
     * @param address
     * @param phone
     * @param webSite
     * @param aboutMe
     * @param isFavorite
     */
    public Neighbour(Integer id, String name, String avatarUrl, String address, String phone, String webSite, String aboutMe, boolean isFavorite) {
        this.id = id;
        this.name = name;
        this.avatarUrl = avatarUrl;
        this.address = address;
        this.phone = phone;
        this.webSite = webSite;
        this.aboutMe = aboutMe;
        this.isFavorite = isFavorite;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getAddress() { return address; }

    public String getPhone() { return phone;}

    public String getMail() { return webSite; }

    public String getDescription() { return aboutMe; }

    public boolean isFavorite() { return isFavorite; }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    //-----------------------------a completer ----------------------------------------//
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Neighbour neighbour = (Neighbour) o;
        return Objects.equals(id, neighbour.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
