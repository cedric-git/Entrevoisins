package com.openclassrooms.entrevoisins.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Objects;

/**
 * Model object representing a Neighbour
 */
public class Neighbour implements Parcelable {

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
    private boolean favoriteStatus;// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Added

    /**
     * Constructor
     * @param id
     * @param name
     * @param avatarUrl
     * @param address
     * @param phone
     * @param webSite
     * @param aboutMe
     * @param FavoriteStatus // <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Added
     */
    public Neighbour(Integer id, String name, String avatarUrl, String address, String phone, String webSite, String aboutMe, boolean FavoriteStatus) {
        this.id = id;
        this.name = name;
        this.avatarUrl = avatarUrl;
        this.address = address;
        this.phone = phone;
        this.webSite = webSite;
        this.aboutMe = aboutMe;
        // <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Added
        this.favoriteStatus = FavoriteStatus;
        // <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Added
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() { return name; }
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

    // <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Added
    public boolean getFavoriteStatus() { return favoriteStatus; }
    public void setFavoriteStatus(boolean favoriteStatus) { this.favoriteStatus = favoriteStatus; }
    // <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Added


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Neighbour neighbour = (Neighbour) o;
        return Objects.equals(id, neighbour.id);
    }

    // <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Added

    // Parcel data

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static final Parcelable.Creator<Neighbour> CREATOR = new Parcelable.Creator<Neighbour>() {
        public Neighbour createFromParcel(Parcel in) {
            return new Neighbour(in);
        }
        public Neighbour[] newArray(int size) {
            return new Neighbour[size];
        }
    };

    private Neighbour(Parcel in) {
        id = in.readInt();
        name = in.readString();
        favoriteStatus = in.readByte() != 0;
        avatarUrl = in.readString();
        webSite = in.readString();

    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeByte((byte) (favoriteStatus ? 1 : 0));
        parcel.writeString(avatarUrl);
        parcel.writeString(webSite);
    }
    // <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Added

}
