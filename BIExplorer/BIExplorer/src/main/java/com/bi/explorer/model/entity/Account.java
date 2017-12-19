package com.bi.explorer.model.entity;

import com.speed.frame.model.entity.AbstractReadWriteEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class Account extends AbstractReadWriteEntity {
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public int getId() {
        return super.getId();
    }

	String name;

    String password;

    List<Role> roles;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = {
                    @JoinColumn(name = "uid", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "rid", referencedColumnName = "id")
            })
    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public static List<Authority> getAuthorities(Account account){
        List<Authority> aus = new ArrayList<Authority>();
        for (Role r : account.getRoles()){
            aus.addAll(r.getAuthorities());
        }
        return aus;
    }

    public static List<Integer> getRoleIds(Account account){
        List<Integer> rids = new ArrayList<Integer>();
        for (Role r : account.getRoles()){
            rids.add(r.getId());
        }
        return rids;
    }

}
