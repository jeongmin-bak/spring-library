package com.example.library.repository;

import com.example.library.dto.LoanJoinDto;
import com.example.library.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.library.dto.LoanJoinDto;
import java.util.Optional;
import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
    @Query("select new com.example.library.dto.LoanJoinDto(m.username, m.phoneNumber, b.title, b.author, l.loanDate) from Loan as l, Member as m, Book as b where l.loanId = :userId and l.loanId = b.bookId order by l.loanDate")
    List<LoanJoinDto> loanJoin(@Param("userId") Long userId);
    Optional<Loan> findLoanByUserId(Long userId);
    Optional<Loan> findLoanByBookIdAndUserId(Long bookId, Long userId);
    //List<Loan> findByUserIdOrderByLoanDateAsc();
    Optional<Loan> findLoanByBookId(Long bookId);

    List<Loan> findAllByUserId(Long userId);
}