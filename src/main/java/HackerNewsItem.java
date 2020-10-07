public class HackerNewsItem {

    int position;
    String title;
    String url;
    String author;
    int Score;

    //Constructor5
    public HackerNewsItem(int position, String title, String url, String author, int score){
        this.position = position;
        this.title = title;
        this.url = url;
        this.author = author;
        this.Score = score;
    }


    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HackerNewsItem that = (HackerNewsItem) o;

        if (position != that.position) return false;
        if (Score != that.Score) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        return author != null ? author.equals(that.author) : that.author == null;
    }

    @Override
    public int hashCode() {
        int result = position;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + Score;
        return result;
    }
    @Override
    public String toString() {
        return "HackerNewsItem{" +
                "position=" + position +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", author='" + author + '\'' +
                ", Score=" + Score +
                '}';
    }


}
