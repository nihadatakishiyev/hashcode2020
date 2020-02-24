import java.io.*;
import java.util.*;

public class Main {
    public static Integer book_count;
    public static Integer library_count;
    public static Integer days;
    public static List<Book> scores = new ArrayList<>();
    public static List<Library> libraries = new ArrayList<>();

    public static class CustomComparator implements Comparator<Library> {
        @Override
        public int compare(Library o1, Library o2) {
            return o1.getTotalScore().compareTo(o2.getTotalScore());
        }
    }
    public static class CustomComparator2 implements Comparator<Library> {
        @Override
        public int compare(Library o1, Library o2) {
            return o1.getSignUp().compareTo(o2.getSignUp());
        }
    }
    public static class CustomComparator3 implements Comparator<Library> {
        @Override
        public int compare(Library o1, Library o2) {
            return o1.getPerDay().compareTo(o2.getPerDay());
        }
    }
    public static void main(String[] args) {
        try {
            File myObj = new File("./src/in.txt");
            BufferedWriter br = new BufferedWriter(new FileWriter(new File("./src/out.txt")));
            Scanner myReader = new Scanner(myObj);
            book_count = myReader.nextInt();
            int[] usedBooks = new int[book_count];
            int cnt = 0;
            library_count = myReader.nextInt();
            days = myReader.nextInt();
            for (int i = 0; i < book_count; i++) {
                Book book =  new Book();
                book.setId(i);
                book.setScore(myReader.nextInt());
                scores.add(book);
            }
            for (int i = 0; i < library_count; i++) {
                Library library = new Library();
                library.setID(i);
                int bookcount= myReader.nextInt();
                library.setBookCount(bookcount);
                library.setSignUp(myReader.nextInt());
                library.setPerDay(myReader.nextInt());
                List<Book> a = new ArrayList<>();
                for (int j = 0; j < library.getBookCount(); j++) {
                    int tm2 = myReader.nextInt();
                    Book temp = new Book();
                    temp.setScore(scores.get(tm2).getScore());
                    temp.setId(tm2);
                    a.add(temp);
                }
                Collections.sort(a, new Comparator<Book>() {
                    @Override
                    public int compare(Book o1, Book o2) {
                        return o1.getScore().compareTo(o2.getScore());
                    }
                }.reversed());
                library.setBooks(a);
                library.setTotalScore(scores,days);
                libraries.add(library);
            }
            List<Library> libraries2 = libraries;
            Collections.sort(libraries2, new CustomComparator().reversed());
//            Collections.sort(libraries2, new CustomComparator2());
//            Collections.sort(libraries2, new CustomComparator3());
//            System.out.println(library);
            br.write(library_count + "\n");
            for (int i = 0; i < library_count; i++) {
                Library temp = libraries2.get(i);
                if (temp.getSignUp()<days){
                    List<Book> aa = temp.getBooks();
                    int n = 0;
                    int m=0;
                    List<Integer> ls = new ArrayList<>();
                    for (int j = 0; j <temp.getBookCount(); j++) {

//                        System.out.print(aa.get(j)+ " ");
                        if (usedBooks[aa.get(j).getId()]==0 ){
                            if (m < temp.getMaxBookCount()) {
                                usedBooks[aa.get(j).getId()] = 1;
                                ls.add(aa.get(j).getId());
                                m++;
                            }
                        }
                        else {
                            n++;
                        }
                        if (j == temp.getBookCount()-1) {
                            if (temp.getBookCount()-n>0) {
                                br.write(temp.getID() + " ");
                                br.write((Math.min((temp.getBookCount() - n), temp.getMaxBookCount())) + " \n");
                                for (int k = 0; k <Math.min((temp.getBookCount() - n), temp.getMaxBookCount()) ; k++) {
                                    br.write(ls.get(k)+ " ");
                                }
                            }else{
                                cnt++;
                            }
                        }
                    }

                    if(temp.getMaxBookCount()-n > 0)
                        br.write('\n');
                }
            }
            System.out.println(cnt);

            myReader.close();
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
