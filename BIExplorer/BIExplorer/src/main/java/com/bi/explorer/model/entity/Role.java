package com.bi.explorer.model.entity;

import com.speed.frame.model.entity.AbstractReadWriteEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
public class Role extends AbstractReadWriteEntity {
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public int getId() {
        return super.getId();
    }

	String name;

    List<Authority> authorities;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "role_authority",
            joinColumns = {
                    @JoinColumn(name = "rid", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "aid", referencedColumnName = "id")
            })
    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
