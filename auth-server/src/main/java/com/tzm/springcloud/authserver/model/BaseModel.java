package com.tzm.springcloud.authserver.model;

import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

@Data
public class BaseModel implements Serializable {
    public final static String DEFAULT_USERNAME = "system";
    private Long id;
    private String createdBy = DEFAULT_USERNAME;
    private String updatedBy = DEFAULT_USERNAME;
    private Instant createdTime = Instant.now();
    private Instant updatedTime = Instant.now();
}
