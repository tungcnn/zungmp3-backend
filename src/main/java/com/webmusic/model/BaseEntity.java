package com.webmusic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import java.time.ZonedDateTime;

@Data
public abstract class BaseEntity {
//    @JsonIgnore
//    @CreatedBy
//    private String createdBy;
//    @JsonIgnore
//    @CreatedDate
//    private ZonedDateTime createdDate;
//    @JsonIgnore
//    @LastModifiedBy
//    private String updatedBy;
//    @JsonIgnore
//    @LastModifiedDate
//    private ZonedDateTime updatedDate;
}
