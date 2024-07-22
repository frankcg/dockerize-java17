package com.bidea.factory.bookhouse.repository;

import com.bidea.factory.bookhouse.bean.Book;
import com.bidea.factory.bookhouse.model.BookRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookHouseRepository extends JpaRepository<Book, Long> {
}
