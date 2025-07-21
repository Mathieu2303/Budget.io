import './App.css';

import './components/header.css';
import './components/form.css';
import ExpenseForm from './components/expenseForm';
import HeaderWelcome from './components/headerWelcome';
import ExpenseList from './components/expenseList';

function App() {
    return (
        <div>
            <HeaderWelcome />
            <ExpenseForm />
            <ExpenseList />
            
        </div>
    );
}

export default App;