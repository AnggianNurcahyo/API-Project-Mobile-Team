package com.darryncampbell.dwgettingstartedjava.Class;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class User {

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("npk")
    @Expose
    private String npk;

    @SerializedName("username")
    @Expose
    private String username;

    @SerializedName("password")
    @Expose
    private String password;

    @SerializedName("rfid_tag")
    @Expose
    private String rfid_tag;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("usergroup")
    @Expose
    private String usergroup;

    @SerializedName("department_id")
    @Expose
    private Integer department_id;

    @SerializedName("op_skill")
    @Expose
    private Integer op_skill;

    @SerializedName("last_login")
    @Expose
    private Date last_login;

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("created_at")
    @Expose
    private Date created_at;

    @SerializedName("updated_at")
    @Expose
    private Date updated_at;

    public User(Integer id, String npk, String username, String password, String rfid_tag, String name, String usergroup, Integer department_id, Integer op_skill, Date last_login, String status, Date created_at, Date updated_at) {
        this.id = id;
        this.npk = npk;
        this.username = username;
        this.password = password;
        this.rfid_tag = rfid_tag;
        this.name = name;
        this.usergroup = usergroup;
        this.department_id = department_id;
        this.op_skill = op_skill;
        this.last_login = last_login;
        this.status = status;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNpk() {
        return npk;
    }

    public void setNpk(String npk) {
        this.npk = npk;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRfid_tag() {
        return rfid_tag;
    }

    public void setRfid_tag(String rfid_tag) {
        this.rfid_tag = rfid_tag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsergroup() {
        return usergroup;
    }

    public void setUsergroup(String usergroup) {
        this.usergroup = usergroup;
    }

    public Integer getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Integer department_id) {
        this.department_id = department_id;
    }

    public Integer getOp_skill() {
        return op_skill;
    }

    public void setOp_skill(Integer op_skill) {
        this.op_skill = op_skill;
    }

    public Date getLast_login() {
        return last_login;
    }

    public void setLast_login(Date last_login) {
        this.last_login = last_login;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }
}
