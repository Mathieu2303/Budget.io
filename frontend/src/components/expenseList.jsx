import { useEffect, useState } from "react";
import axios from "axios";
import './list.css'

function ExpenseList(){
    const [users, setUsers] = useState([]);
    const [loading, setLoading] = useState(true);


    useEffect(() => {
        fetchUsers();
        }, []); 


    const fetchUsers = async () => {
            try {
                const response = await axios.get("http://localhost:8080/api/users");
                console.log("Fetched users:", response.data); 
                setUsers(response.data);
                setLoading(false);
            } catch (error) {
                console.error("Error fetching users:", error);
                setLoading(false);
            }
        };
    

    const handleDelete = async(id) => {
        try{
            await axios.delete(`http://localhost:8080/api/users/delete/${id}`);
            fetchUsers();
        }
        catch(error){
            console.error("could not delete user", error);
            alert("failed to delete user");
        }
    };

        if(loading){
            return <p>loading users....</p>
        }

        return(
            <div className="user-list">
                <h2>Registered Users</h2>
                <table>
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Total Balance</th>
                        </tr>
                    </thead>
                    <tbody>
                        {users.map((user) => (
                            <tr key={user.id}>
                            <td>{user.name}</td>
                            <td>${user.balance}</td>
                             <button onClick={() => handleDelete(user.id)}>Delete</button>
                            </tr>
                        ))}
                    </tbody>

                </table>
            </div>
        )
    
}

export default ExpenseList;