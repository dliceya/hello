package com.dlice.hello.common.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@ToString
@MappedSuperclass
@EqualsAndHashCode
public class BaseEntity {
    /**
     * Create time.
     */
    @Column(name = "create_time")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * Update time.
     */
    @Column(name = "update_time")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    /**
     * Active mark.
     */
    @Column(name = "is_active", columnDefinition="varchar(1)")
    private Boolean isActive;

    /**
     * Delete mark.
     */
    @Column(name = "is_delete", columnDefinition="varchar(1)")
    private Boolean isDelete;

    @PrePersist
    protected void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        if (createTime == null) {
            createTime = now;
        }

        if (updateTime == null) {
            updateTime = now;
        }

        if (isActive == null) {
            isActive = true;
        }

        if(isDelete == null) {
            isDelete = false;
        }
    }

    @PreUpdate
    protected void preUpdate() {
        updateTime = LocalDateTime.now();
    }

    @PreRemove
    protected void preRemove() {
        updateTime = LocalDateTime.now();
    }
}
