package kz.project.g135.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import kz.project.g135.model.Book;

@Repository
@Transactional
public interface BookRepository extends JpaRepository<Book, Long> {
}
