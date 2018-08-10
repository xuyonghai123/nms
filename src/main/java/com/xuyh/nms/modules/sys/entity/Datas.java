package com.xuyh.nms.modules.sys.entity;

import java.util.Date;
import java.util.Objects;

public class Datas {
    private Integer id;
    private Date date;
    private String name;
    private String address;
    private String zip;

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Datas datas = (Datas) o;
        return Objects.equals(id, datas.id) &&
                Objects.equals(date, datas.date) &&
                Objects.equals(name, datas.name) &&
                Objects.equals(address, datas.address) &&
                Objects.equals(zip, datas.zip);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, date, name, address, zip);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
