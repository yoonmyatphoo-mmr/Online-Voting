package com.ymp.onlinevoltingsystem.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Author Yoon Myat Phoo
 * @created 7/20/2023
 * @project online-voting-system
 * @package com.ymp.onlinevotingsystem.model
 */

@Data
@Entity
public class MaleVote {
    @Id //@Id annotation specifies the primary key of the entity.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long user_id;
    private long male;
    private int vote;
}
