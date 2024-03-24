import React from 'react';
import { Link } from 'react-router-dom';
import './Navbar.css'; 

const Navbar = () => {
  return (
    <div className="navbar">
      <ul>
        <li>
          <Link to="/dashboard">Assigned</Link>
        </li>
        <li>
          <Link to="/reviewed">Reviewed</Link>
        </li>
      </ul>
    </div>
  );
};

export default Navbar;
