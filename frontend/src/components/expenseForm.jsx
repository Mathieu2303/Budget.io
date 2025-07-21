import { useState } from "react";
import axios from "axios";
import "./form.css"; 

function UserForm() {
    const [name, setName] = useState("");
    const [balance, setTotalBalance] = useState("");

    const handleSubmit = async (e) => {
        e.preventDefault();

        if (name && balance) {
            const newUser = {
                name,
                balance: parseFloat(balance)
            };

            try {
                const response = await axios.post(
                    "http://localhost:8080/api/users/create",
                    newUser
                );
                console.log("User created:", response.data);
                alert(`User created with ID: ${response.data.id}`);

                // Clear form after submission
                setName("");
                setTotalBalance("");
            } catch (error) {
                console.error("Error creating user:", error);
                alert("Error creating user. Check console for details.");
            }
        } else {
            alert("Please fill out all fields.");
        }
    };

    return (
        <form onSubmit={handleSubmit} className="user-form">
            <h2>Register User</h2>

            <label htmlFor="user-name">Name:</label>
            <input
                type="text"
                id="user-name"
                value={name}
                onChange={(e) => setName(e.target.value)}
                required
            />
            <br />

            <label htmlFor="total_balance">Total Balance:</label>
            <input
                type="number"
                id="total_balance"
                value={balance}
                onChange={(e) => setTotalBalance(e.target.value)}
                required
            />
            <br />

            <button type="submit">Add User</button>
        </form>
    );
}

export default UserForm;
