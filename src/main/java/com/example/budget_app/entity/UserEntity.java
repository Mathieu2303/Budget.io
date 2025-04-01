package com.example.budget_app.entity;
import jakarta.persistence.*;

@Entity
@Table(name ="user_info")

public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long id;
    @Column(name="user_name")
    private String name;
    @Column(name="user_total_balance")
    private Double totalBalance;


    public UserEntity() {
        this.totalBalance = 0.0; // Ensures balance is never null
    }

    public UserEntity(Long id, String name) {
        this.id = id;
        this.name = name;
        this.totalBalance = 0.0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(Double totalBalance) {
        this.totalBalance = totalBalance;
    }

    public void deleteUserBalance(Long id) {}

}
