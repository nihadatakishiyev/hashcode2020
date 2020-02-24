public class Book {
    private Integer id;
    private Integer score;
    private boolean isUsed = false;
    public Book(){

    }
    public Book(Integer id, Integer score, Boolean isUsed) {
        this.id = id;
        this.score = score;
        this.isUsed = isUsed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean isUsed) {
        this.isUsed = isUsed;
    }
}
