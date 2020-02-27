import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Avatar {

    @SerializedName("small")
    @Expose
    public Small small;
    @SerializedName("isCustom")
    @Expose
    public Boolean isCustom;
    @SerializedName("permalink")
    @Expose
    public String permalink;
    @SerializedName("cache")
    @Expose
    public String cache;
    @SerializedName("large")
    @Expose
    public Large large;

    /**
     * No args constructor for use in serialization
     *
     */
    public Avatar() {
    }

    /**
     *
     * @param small
     * @param cache
     * @param large
     * @param isCustom
     * @param permalink
     */
    public Avatar(Small small, Boolean isCustom, String permalink, String cache, Large large) {
        super();
        this.small = small;
        this.isCustom = isCustom;
        this.permalink = permalink;
        this.cache = cache;
        this.large = large;
    }

    public Small getSmall() {
        return small;
    }

    public void setSmall(Small small) {
        this.small = small;
    }

    public Boolean getIsCustom() {
        return isCustom;
    }

    public void setIsCustom(Boolean isCustom) {
        this.isCustom = isCustom;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public String getCache() {
        return cache;
    }

    public void setCache(String cache) {
        this.cache = cache;
    }

    public Large getLarge() {
        return large;
    }

    public void setLarge(Large large) {
        this.large = large;
    }

}