import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Author {

    @SerializedName("username")
    @Expose
    public String username;
    @SerializedName("about")
    @Expose
    public String about;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("disable3rdPartyTrackers")
    @Expose
    public Boolean disable3rdPartyTrackers;
    @SerializedName("isPowerContributor")
    @Expose
    public Boolean isPowerContributor;
    @SerializedName("joinedAt")
    @Expose
    public String joinedAt;
    @SerializedName("profileUrl")
    @Expose
    public String profileUrl;
    @SerializedName("url")
    @Expose
    public String url;
    @SerializedName("location")
    @Expose
    public String location;
    @SerializedName("isPrivate")
    @Expose
    public Boolean isPrivate;
    @SerializedName("signedUrl")
    @Expose
    public String signedUrl;
    @SerializedName("isPrimary")
    @Expose
    public Boolean isPrimary;
    @SerializedName("isAnonymous")
    @Expose
    public Boolean isAnonymous;
    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("avatar")
    @Expose
    public Avatar avatar;

    /**
     * No args constructor for use in serialization
     *
     */
    public Author() {
    }

    /**
     *
     * @param profileUrl
     * @param disable3rdPartyTrackers
     * @param joinedAt
     * @param about
     * @param isPrivate
     * @param avatar
     * @param url
     * @param isAnonymous
     * @param isPowerContributor
     * @param isPrimary
     * @param name
     * @param location
     * @param id
     * @param signedUrl
     * @param username
     */
    public Author(String username, String about, String name, Boolean disable3rdPartyTrackers, Boolean isPowerContributor, String joinedAt, String profileUrl, String url, String location, Boolean isPrivate, String signedUrl, Boolean isPrimary, Boolean isAnonymous, String id, Avatar avatar) {
        super();
        this.username = username;
        this.about = about;
        this.name = name;
        this.disable3rdPartyTrackers = disable3rdPartyTrackers;
        this.isPowerContributor = isPowerContributor;
        this.joinedAt = joinedAt;
        this.profileUrl = profileUrl;
        this.url = url;
        this.location = location;
        this.isPrivate = isPrivate;
        this.signedUrl = signedUrl;
        this.isPrimary = isPrimary;
        this.isAnonymous = isAnonymous;
        this.id = id;
        this.avatar = avatar;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getDisable3rdPartyTrackers() {
        return disable3rdPartyTrackers;
    }

    public void setDisable3rdPartyTrackers(Boolean disable3rdPartyTrackers) {
        this.disable3rdPartyTrackers = disable3rdPartyTrackers;
    }

    public Boolean getIsPowerContributor() {
        return isPowerContributor;
    }

    public void setIsPowerContributor(Boolean isPowerContributor) {
        this.isPowerContributor = isPowerContributor;
    }

    public String getJoinedAt() {
        return joinedAt;
    }

    public void setJoinedAt(String joinedAt) {
        this.joinedAt = joinedAt;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Boolean getIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(Boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    public String getSignedUrl() {
        return signedUrl;
    }

    public void setSignedUrl(String signedUrl) {
        this.signedUrl = signedUrl;
    }

    public Boolean getIsPrimary() {
        return isPrimary;
    }

    public void setIsPrimary(Boolean isPrimary) {
        this.isPrimary = isPrimary;
    }

    public Boolean getIsAnonymous() {
        return isAnonymous;
    }

    public void setIsAnonymous(Boolean isAnonymous) {
        this.isAnonymous = isAnonymous;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Avatar getAvatar() {
        return avatar;
    }

    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }

}