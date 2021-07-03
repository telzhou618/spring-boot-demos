package com.example.proessor.bean;

import lombok.Data;

/**
 * @author jameszhou
 */
@Data
public class Entity {

    private String entityId;

    /**
     * @see com.example.enums.EntityTypeEnum
     */
    private Integer entityType;
}
