import './App.css';

import './components/header.css';
import './components/form.css';
import './components/mainComp.css';
import React from "react";
import MainComponent from "./components/main-container";
import HeaderWelcome from "./components/headerWelcome";
function App() {
    return (
        <div>
            <div>
                <HeaderWelcome />
                <MainComponent />
            </div>
            
        </div>
    );
}

export default App;