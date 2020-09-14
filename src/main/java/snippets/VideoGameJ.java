package snippets;

public class VideoGameJ {
    private String name;
    private String publisher;
    private int reviewScore;

    public VideoGameJ(String name, String publisher, int reviewScore) {
        this.name = name;
        this.publisher = publisher;
        this.reviewScore = reviewScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VideoGameJ that = (VideoGameJ) o;
        if (reviewScore != that.reviewScore)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null)
            return false;
        return publisher != null ? publisher.equals(that.publisher) : that.publisher == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (publisher != null ? publisher.hashCode() : 0);
        result = 31 * result + reviewScore;
        return result;
    }

    @Override
    public String toString() {
        return "VideoGame{name='" + name + '\'' + ", publisher='" + publisher + '\'' +
                ", reviewScore=" + reviewScore + '}';
    }
}






