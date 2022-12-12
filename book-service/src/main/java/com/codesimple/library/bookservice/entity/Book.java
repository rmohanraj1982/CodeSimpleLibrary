package com.codesimple.library.bookservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "BOOKS")
public class Book 
{
    @Id
    @Column(name = "book_id", length = 10)
    public String bookId;
    
    @Column(name = "book_name", length = 100)
    public String bookName;
    
    @Column(name = "author", length = 50)
    public String author;
    
    @Column(name = "available_copies")
    public int availableCopies;
    
    @Column(name = "total_copies")
    public int totalCopies;
}
