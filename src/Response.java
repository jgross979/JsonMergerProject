import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response {

    @SerializedName("editableUntil")
    @Expose
    public String editableUntil;
    @SerializedName("dislikes")
    @Expose
    public Integer dislikes;
    @SerializedName("numReports")
    @Expose
    public Integer numReports;
    @SerializedName("likes")
    @Expose
    public Integer likes;
    @SerializedName("message")
    @Expose
    public String message;
    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("createdAt")
    @Expose
    public String createdAt;
    @SerializedName("author")
    @Expose
    public Author author;
    @SerializedName("media")
    @Expose
    public List<Object> media = null;
    @SerializedName("isSpam")
    @Expose
    public Boolean isSpam;
    @SerializedName("isDeletedByAuthor")
    @Expose
    public Boolean isDeletedByAuthor;
    @SerializedName("isDeleted")
    @Expose
    public Boolean isDeleted;
    @SerializedName("parent")
    @Expose
    public Double parent;
    @SerializedName("isApproved")
    @Expose
    public Boolean isApproved;
    @SerializedName("isFlagged")
    @Expose
    public Boolean isFlagged;
    @SerializedName("raw_message")
    @Expose
    public String rawMessage;
    @SerializedName("isHighlighted")
    @Expose
    public Boolean isHighlighted;
    @SerializedName("canVote")
    @Expose
    public Boolean canVote;
    @SerializedName("thread")
    @Expose
    public String thread;
    @SerializedName("forum")
    @Expose
    public String forum;
    @SerializedName("points")
    @Expose
    public Integer points;
    @SerializedName("moderationLabels")
    @Expose
    public List<String> moderationLabels = null;
    @SerializedName("isEdited")
    @Expose
    public Boolean isEdited;
    @SerializedName("sb")
    @Expose
    public Boolean sb;

    /**
     * No args constructor for use in serialization
     *
     */
    public Response() {
    }

    /**
     *
     * @param isHighlighted
     * @param parent
     * @param author
     * @param dislikes
     * @param isEdited
     * @param media
     * @param thread
     * @param message
     * @param rawMessage
     * @param isFlagged
     * @param points
     * @param sb
     * @param forum
     * @param createdAt
     * @param isDeletedByAuthor
     * @param moderationLabels
     * @param isDeleted
     * @param numReports
     * @param id
     * @param isSpam
     * @param isApproved
     * @param editableUntil
     * @param likes
     * @param canVote
     */
    public Response(String editableUntil, Integer dislikes, Integer numReports, Integer likes, String message, String id, String createdAt, Author author, List<Object> media, Boolean isSpam, Boolean isDeletedByAuthor, Boolean isDeleted, Double parent, Boolean isApproved, Boolean isFlagged, String rawMessage, Boolean isHighlighted, Boolean canVote, String thread, String forum, Integer points, List<String> moderationLabels, Boolean isEdited, Boolean sb) {
        super();
        this.editableUntil = editableUntil;
        this.dislikes = dislikes;
        this.numReports = numReports;
        this.likes = likes;
        this.message = message;
        this.id = id;
        this.createdAt = createdAt;
        this.author = author;
        this.media = media;
        this.isSpam = isSpam;
        this.isDeletedByAuthor = isDeletedByAuthor;
        this.isDeleted = isDeleted;
        this.parent = parent;
        this.isApproved = isApproved;
        this.isFlagged = isFlagged;
        this.rawMessage = rawMessage;
        this.isHighlighted = isHighlighted;
        this.canVote = canVote;
        this.thread = thread;
        this.forum = forum;
        this.points = points;
        this.moderationLabels = moderationLabels;
        this.isEdited = isEdited;
        this.sb = sb;
    }

    public String getEditableUntil() {
        return editableUntil;
    }

    public void setEditableUntil(String editableUntil) {
        this.editableUntil = editableUntil;
    }

    public Integer getDislikes() {
        return dislikes;
    }

    public void setDislikes(Integer dislikes) {
        this.dislikes = dislikes;
    }

    public Integer getNumReports() {
        return numReports;
    }

    public void setNumReports(Integer numReports) {
        this.numReports = numReports;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Object> getMedia() {
        return media;
    }

    public void setMedia(List<Object> media) {
        this.media = media;
    }

    public Boolean getIsSpam() {
        return isSpam;
    }

    public void setIsSpam(Boolean isSpam) {
        this.isSpam = isSpam;
    }

    public Boolean getIsDeletedByAuthor() {
        return isDeletedByAuthor;
    }

    public void setIsDeletedByAuthor(Boolean isDeletedByAuthor) {
        this.isDeletedByAuthor = isDeletedByAuthor;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Double getParent() {
        return parent;
    }

    public void setParent(Double parent) {
        this.parent = parent;
    }

    public Boolean getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(Boolean isApproved) {
        this.isApproved = isApproved;
    }

    public Boolean getIsFlagged() {
        return isFlagged;
    }

    public void setIsFlagged(Boolean isFlagged) {
        this.isFlagged = isFlagged;
    }

    public String getRawMessage() {
        return rawMessage;
    }

    public void setRawMessage(String rawMessage) {
        this.rawMessage = rawMessage;
    }

    public Boolean getIsHighlighted() {
        return isHighlighted;
    }

    public void setIsHighlighted(Boolean isHighlighted) {
        this.isHighlighted = isHighlighted;
    }

    public Boolean getCanVote() {
        return canVote;
    }

    public void setCanVote(Boolean canVote) {
        this.canVote = canVote;
    }

    public String getThread() {
        return thread;
    }

    public void setThread(String thread) {
        this.thread = thread;
    }

    public String getForum() {
        return forum;
    }

    public void setForum(String forum) {
        this.forum = forum;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public List<String> getModerationLabels() {
        return moderationLabels;
    }

    public void setModerationLabels(List<String> moderationLabels) {
        this.moderationLabels = moderationLabels;
    }

    public Boolean getIsEdited() {
        return isEdited;
    }

    public void setIsEdited(Boolean isEdited) {
        this.isEdited = isEdited;
    }

    public Boolean getSb() {
        return sb;
    }

    public void setSb(Boolean sb) {
        this.sb = sb;
    }

}