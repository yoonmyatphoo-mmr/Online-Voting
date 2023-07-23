package com.ymp.onlinevoltingsystem.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author Yoon Myat Phoo
 * @created 7/20/2023
 * @project online-voting-system
 * @package com.ymp.onlinevotingsystem.model
 */

@Data
@Entity
public class User {

    @Id //@Id annotation specifies the primary key of the entity.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String email;
    private String password;

    @Transient
    private String confirmPassword;
    private Long roleId;

}
