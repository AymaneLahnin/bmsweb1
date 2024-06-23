package org.pi.bmsweb.services;

import org.pi.bmsweb.entities.Book;
import org.pi.bmsweb.entities.Status;
import org.pi.bmsweb.entities.User;
import org.pi.bmsweb.repositories.BookRepository;
import org.pi.bmsweb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Service
    public class BookService {

        @Autowired
        private BookRepository bookRepository;

        @Autowired
        private UserRepository userRepository;

        public List<Book> findAll() {
            return bookRepository.findAll();
        }

        public Book findById(Long id) {
            return bookRepository.findById(id).orElse(null);
        }

        public Book save(Book book) {
            return bookRepository.save(book);
        }

        public void deleteById(Long id) {
            bookRepository.deleteById(id);
        }

        public Book borrowBook(String title,String name) {
            Book book = bookRepository.findByTitle(title);
            User user = userRepository.findByName(name);

            if (book != null && book.getNumCopies()>0 && user != null) {
                book.setBorrowedBy(user);
                book.setStatus(Status.Borrowed);
                book.setNumCopies(book.getNumCopies()-1);
                return save(book);
            }
            // Handle errors (e.g., book not found, book already borrowed, user not found)
            return null;
        }

        public Book returnBook(Long bookId) {
            Book book = findById(bookId);
            if (book != null && book.isBorrowed()) {
                book.setBorrowedBy(null);
                book.setBorrowed(false);
                return save(book);
            }
            // Handle errors (e.g., book not found, book not borrowed)
            return null;
        }
    }
}
