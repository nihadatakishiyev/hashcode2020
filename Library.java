import java.util.List;

public class Library {
    private Integer ID;
    private List<Book> books;
    private Integer signUp;
    private Integer perDay;
    private Integer bookCount;
    private Integer maxBookCount;
    private Integer totalScore = 0;
    public Library () {

    }
    public Library(List<Book> books, Integer signUp, Integer perDay, Integer id, Integer bookCount, Integer maxBookCount) {
        this.books = books;
        this.signUp = signUp;
        this.perDay = perDay;
        this.ID= id;
        this.bookCount = bookCount;
        this.maxBookCount = maxBookCount;
    }

    public Integer getMaxBookCount() {
        return maxBookCount;
    }

    public void setMaxBookCount(Integer maxBookCount) {
        this.maxBookCount = maxBookCount;
    }

    public Integer getID() {
        return ID;
    }

    public Integer getBookCount() {
        return bookCount;
    }

    public void setBookCount(Integer bookCount) {
        this.bookCount = bookCount;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Integer getSignUp() {
        return signUp;
    }

    public void setSignUp(Integer signUp) {
        this.signUp = signUp;
    }

    public Integer getPerDay() {
        return perDay;
    }

    public void setPerDay(Integer perDay) {
        this.perDay = perDay;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }
    public void setTotalScore(List<Book> scores, Integer day) {
        int daysLeft = Math.max((day-this.signUp), 0);
        int maxBookCount;
        if (daysLeft * this.perDay<0)
             maxBookCount = Integer.MAX_VALUE;
        else maxBookCount = daysLeft * this.perDay;
        setMaxBookCount(Math.min(maxBookCount, this.bookCount));
        for (int i = 0; i <Math.min(maxBookCount, this.bookCount) ; i++) {
            this.totalScore += this.books.get(i).getScore();
        }
    }
}

