package com.tzm.springcloud.authserver.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Role extends BaseModel {
    private String code;
    private String name;
    private String description;
}
