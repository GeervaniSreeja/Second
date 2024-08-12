class Book 
{
    String title;
    String author;
    String ISBN;
}

public class BookCollection
 {
    private static final int MAX_SIZE = 100; // Maximum capacity of the collection
    private Book[] books;
    private int size;

    public BookCollection() 
    {
        books = new Book[MAX_SIZE];
        size = 0;
    }

    // Method to add a book to the collection
    void addBook(String title, String author, String ISBN)
    {
        if (size < MAX_SIZE) 
        {
            Book book = new Book();
            book.title = title;
            book.author = author;
            book.ISBN = ISBN;
            books[size] = book;
            size++;
            System.out.println("Book added successfully.");
        }
        else 
        {
            System.out.println("Cannot add book, collection is full.");
        }
    }

    // Method to remove a book from the collection
    void removeBook(String titleToRemove)
   {
        boolean bookFound = false;
        for (int i = 0; i < size; i++) 
       {
            if (books[i].title.equals(titleToRemove)) 
          {
                bookFound = true;
                for (int j = i; j < size - 1; j++) 
                {
                    books[j] = books[j + 1];
                }
                size--;
                System.out.println("Book removed successfully.");
                break;
            }
        }
        if (!bookFound) 
        {
            System.out.println("Book with title " + titleToRemove + " not found.");
        }
    }

    // Method to display all books in the collection
    void displayBooks()
     {
        if (size == 0) 
        {
            System.out.println("No books in the collection.");
        }
        else 
        {
            System.out.println("Books in the collection:");
            for (int i = 0; i < size; i++)
            {
                System.out.println("Title: " + books[i].title + ", Author: " + books[i].author + ", ISBN: " + books[i].ISBN);
            }
        }
    }

    public static void main(String[] args)
   {
        BookCollection collection = new BookCollection();

        // Adding books to the collection
        collection.addBook("Java Programming", "John Doe", "1234567890");
        collection.addBook("Python for Beginners", "Jane Smith", "0987654321");

        // Displaying books in the collection
        collection.displayBooks();

        // Removing a book from the collection
        collection.removeBook("Java Programming");

        // Displaying books in the collection after removal
        collection.displayBooks();
    }
}