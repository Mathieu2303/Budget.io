//import com.example.budget_app.entity.UserEntity;
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "expenses")
//public class ExpenseEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String description;
//    private double amount;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id", nullable = false) // Foreign key reference to UserEntity
//    private UserEntity user;
//
//    // Getters and Setters
//}
