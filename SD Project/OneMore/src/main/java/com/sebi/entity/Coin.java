package com.sebi.entity;
import javax.persistence.*;

@Entity
@Table(name = "coins")
public class Coin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String IssueYear;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "owner_id")
    private Person owner;

    @Column
    private String description;

    public Coin() {

    }

    public Coin(String issueYear, Person owner, String description) {
        IssueYear = issueYear;
        this.owner = owner;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIssueYear() {
        return IssueYear;
    }

    public void setIssueYear(String issueYear) {
        IssueYear = issueYear;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}