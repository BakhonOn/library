package com.example.library.models;

import com.example.library.models.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Table(name = "issuance_record")
@NoArgsConstructor
public class IssuanceRecord extends BaseEntity {
    @NotNull
    @Column(name = "book_id")
    private Long bookId;

    @NotNull
    @Column(name = "reader_id")
    private Long readerId;

    @CreatedDate
    @Column(name = "issue_date", updatable = false, nullable = false)
    private LocalDateTime issueDate;

    @NotNull
    @LastModifiedDate
    @Column(name = "return_date")
    private LocalDateTime returnDate;

    @NotNull
    @Column(name = "status")
    private String status;  // StatusType это enum

    public IssuanceRecord(Long bookId, Long readerId, String status) {
        this.bookId = bookId;
        this.readerId = readerId;
        this.status = status;
    }

}
