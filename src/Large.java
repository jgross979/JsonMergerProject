import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Large {

    @SerializedName("permalink")
    @Expose
    public String permalink;
    @SerializedName("cache")
    @Expose
    public String cache;

    /**
     * No args constructor for use in serialization
     *
     */
    public Large() {
    }

    /**
     *
     * @param cache
     * @param permalink
     */
    public Large(String permalink, String cache) {
        super();
        this.permalink = permalink;
        this.cache = cache;
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

}