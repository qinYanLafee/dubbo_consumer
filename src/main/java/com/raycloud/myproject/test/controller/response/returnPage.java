package com.raycloud.myproject.test.controller.response;

import com.raycloud.myproject.test.entity.User;

import java.util.List;

/**
 * Created by 001117020015 on 2017/2/28.
 */
public class returnPage {
    private List<User>  listUser;
    private int         pageNum;
    private int         totlePage;

    public List<User> getListUser() {
        return listUser;
    }

    public void setListUser(List<User> listUser) {
        this.listUser = listUser;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getTotlePage() {
        return totlePage;
    }

    public void setTotlePage(int totlePage) {
        this.totlePage = totlePage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        returnPage that = (returnPage) o;

        if (pageNum != that.pageNum) return false;
        if (totlePage != that.totlePage) return false;
        if (listUser != null ? !listUser.equals(that.listUser) : that.listUser != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = listUser != null ? listUser.hashCode() : 0;
        result = 31 * result + pageNum;
        result = 31 * result + totlePage;
        return result;
    }

    @Override
    public String toString() {
        return "returnPage{" +
                "listUser=" + listUser +
                ", pageNum=" + pageNum +
                ", totlePage=" + totlePage +
                '}';
    }

    public returnPage() {
    }
}
