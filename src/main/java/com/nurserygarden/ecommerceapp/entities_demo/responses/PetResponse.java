package com.nurserygarden.ecommerceapp.entities_demo.responses;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;

public class PetResponse {
    
    private Long id;
    private String name;

    @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    @JsonProperty("created_at")
    private OffsetDateTime createdAt;

    @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    @JsonProperty("updated_at")
    private OffsetDateTime updatedAt;

    public PetResponse() {}

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
