import java.util.Scanner;

public class LibraryApplication {
    private  static  BookDAO bookDAO=new BookImplementation(JDBConnection.getConnection());
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
        System.out.println("""
                Welcome to our New Library🏷️
                You Can choose from the following
                1-add a Book
                2-Update a Book
                3-Delete a Book
                4-Get a book
                5-Display all Books
                6-Exit the application
                """);
        choice = sc.nextInt();

        sc.nextLine();
        switch (choice) {
            case 1:
                System.out.println("Please enter a book title");
                String title=sc.nextLine();
                System.out.println("Please enter author name");
                String author=sc.nextLine();
                System.out.println("Enter a book price");
                double price= sc.nextDouble();
                Book book=new Book(title,author,price);
                bookDAO.addBook(book);
                System.out.println("Book added successfully");

                break;
            case 2:
                System.out.println("Enter a book ID to update");
                int booId= sc.nextInt();
                sc.nextLine();
                Book book1=bookDAO.getBookById(booId);
                if(book1==null){
                    System.out.println("No book in the Library");
                }else {
                    System.out.println("Enter new book title(or Press Enter to skip)");
                    title = sc.nextLine();
                    System.out.println("Enter new book author name(or press enter to skip)");
                    author = sc.nextLine();
                    System.out.println("Enter new book price (or Press Enter to Skip)");
                    price = sc.nextDouble();
                    sc.nextLine();
                    book1.setTitle(title.isEmpty()? book1.getTitle():title);
                    book1.setAuthor(author.isEmpty()?book1.getAuthor():author);
                    book1.setPrice(price==0? book1.getPrice() :price);
                    bookDAO.updateBook(book1);
                    System.out.println("Book updated Successfully");
                }

                break;
            case 3:
                System.out.println("Please enter book id to delete");
                booId = sc.nextInt();
                sc.nextLine();
                Book book2= bookDAO.deleteBook(booId);
                if(book2 == null){
                    System.out.println("No book found ");
                } else bookDAO.deleteBook(booId);
                System.out.println("Book deleted successfully ");

                break;
            case 4:

                break;

            case 5:
                System.out.println("Exiting the app ...");
                break;
            default:
                System.out.println("Wrong input ");

        }

    } while(choice!=5);

}



    }



