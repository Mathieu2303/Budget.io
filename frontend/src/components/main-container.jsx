import React from "react";
import ExpenseForm from "./expenseForm";
import ExpenseList from "./expenseList";

function MainComponent() {
    return (
        <div className="main-container">
            <ExpenseForm />
            <ExpenseList />
        </div>
    );
}

export default MainComponent;