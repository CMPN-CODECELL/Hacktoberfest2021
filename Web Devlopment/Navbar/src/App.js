import React from 'react';
import './App.css';
import Navbar from './components/Navbar/Navbar';
import { BrowserRouter as Router } from "react-router-dom";


function App() {
  return (
    <>
    <Router>
    <div className="App">
      <Navbar />
    </div>
    </Router>
    </>
    
  );
}

export default App;
