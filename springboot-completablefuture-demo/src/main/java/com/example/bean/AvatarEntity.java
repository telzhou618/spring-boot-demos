package com.example.bean;

import lombok.Data;

/**
 * @author jameszhou
 */
@Data
public class AvatarEntity extends Entity {

    private String imgurl;
    private Integer width;
    private Integer height;
}
