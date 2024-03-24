import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './Dashboard.css'
import Reviews from './Reviews';

const Dashboard = () => {
  const [papers, setPapers] = useState([]);
  const authorId = localStorage.getItem('authorId')
  const token = localStorage.getItem('token')

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get(`http://localhost:8080/papers/assignedpapers/${authorId}`,
        {
            headers: {
                Authorization : 'Bearer ' + token
            }
        });
        console.log(papers);
        setPapers(response.data); 
      } catch (error) {
        console.error('Error fetching data:', error);
      }
    };

    fetchData();
  }, []);

  return (
    <div>
      <h1>Assigned Papers</h1>
      <table>
        <thead>
          <tr>
            <th>Title</th>
            <th>Authors</th>
            <th>Abstract Link</th>
            <th>Deadline</th>
          </tr>
        </thead>
        <tbody>
          {papers.map(paper => (
            <tr key={paper.paperid}>
              <td><a href={`/reviews/${paper.paperid}`}>{paper.title}</a></td>
              <td>{paper.authors}</td>
              <td><a href={paper.abstractLink}>{paper.abstractLink}</a></td>
              <td>{paper.deadLine}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default Dashboard;
