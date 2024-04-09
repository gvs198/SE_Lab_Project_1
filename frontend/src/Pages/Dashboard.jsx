import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './Dashboard.css';
import Reviews from './Reviews';

const Dashboard = () => {
  const [papers, setPapers] = useState([]);
  const authorId = localStorage.getItem('authorId');
  const token = localStorage.getItem('token');

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get(`http://localhost:8080/papers/assignedpapers/${authorId}`, {
          headers: {
            Authorization: 'Bearer ' + token
          }
        });
        setPapers(response.data);
      } catch (error) {
        console.error('Error fetching data:', error);
      }
    };

    fetchData();
  }, []);

  return (
    <div className="container">
      <h1>Assigned Papers</h1>
      <div className="assigned-papers-cards">
        {papers.map(paper => (
          <div className="assigned-paper-card" key={paper.paperid}>
            <div className="assigned-paper-card-header">
              <h2><a href={`/reviews/${paper.paperid}`}>{paper.title}</a></h2>
              <p>Deadline: {paper.deadLine}</p>
            </div>
            <div className="assigned-paper-card-content">
              <p>Authors: {paper.authors}</p>
              <a href={paper.abstractLink}>Abstract Link</a>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default Dashboard;
