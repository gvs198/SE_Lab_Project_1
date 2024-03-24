import logo from './logo.svg';
import './App.css';
import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Home from './Pages/Home';
import Login from './Pages/Login';
import Register from './Pages/Register';
import Dashboard from './Pages/Dashboard';
import Reviews from './Pages/Reviews';
import Reviewed from './Pages/Reviewed';
import Navbar from './Pages/Components/Navbar';
import UpdateReviews from './Pages/UpdateReviews';


function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />
        {/* Routes with Navbar */}
        <Route path="/dashboard" element={<WithNavbar><Dashboard /></WithNavbar>} />
        <Route path="/reviews/:paperId" element={<WithNavbar><Reviews /></WithNavbar>} />
        <Route path="/reviewed" element={<WithNavbar><Reviewed /></WithNavbar>} />
        <Route path="/update/:paperId" element={<WithNavbar><UpdateReviews /></WithNavbar>} />

      </Routes>
    </Router>
  );
}

// Higher-order component to wrap pages with Navbar
const WithNavbar = ({ children }) => {
  return (
    <div>
      <Navbar />
      {children}
    </div>
  );
};

export default App;
