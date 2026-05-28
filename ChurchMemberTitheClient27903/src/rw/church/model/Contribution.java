/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.church.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author nshut
 */
public class Contribution implements Serializable {

    public static final long serialVersionUID = 1L;

    private int id;
    private String contributionType;
    private double amount;
    private Date contributionDate;
    private Member member;
    private Service churchService;

    public Contribution() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContributionType() {
        return contributionType;
    }

    public void setContributionType(String contributionType) {
        this.contributionType = contributionType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getContributionDate() {
        return contributionDate;
    }

    public void setContributionDate(Date contributionDate) {
        this.contributionDate = contributionDate;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Service getChurchService() {
        return churchService;
    }

    public void setChurchService(Service churchService) {
        this.churchService = churchService;
    }
}
