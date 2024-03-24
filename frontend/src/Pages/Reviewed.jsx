import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './Reviewed.css';
import Reviews from './Reviews';

const Reviewed = () => {
  const [papers, setPapers] = useState([]);
  const authorId = localStorage.getItem('authorId');
  const token = localStorage.getItem('token');
  const [reviews, setReviews] = useState({});

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get(`http://localhost:8080/papers/reviewedpapers/${authorId}`,{
          headers: {
              Authorization : 'Bearer ' + token
          }
      });
        setPapers(response.data);
      } catch (error) {
        console.error('Error fetching data:', error);
      }
    };

    fetchData();
  }, [authorId, token]);

  const getReview = async (paperId) => {
    console.log(paperId)
    try {
      const response = await axios.get(`http://localhost:8080/reviews/getreview/${parseInt(paperId)}/${authorId}`,{
        headers: {
            Authorization : 'Bearer ' + token
        }
    });
      setReviews(prevReviews => ({ ...prevReviews, [paperId]: response.data }));
    } catch (error) {
      console.error(error);
    }
  };

  useEffect(() => {
    papers.forEach(paper => {
      getReview(paper.reviewedPaper.paperid);
    });
  }, [papers]);

  return (
    <div>
      <h1>Reviewed Papers</h1>
      <table>
        <thead>
          <tr>
            <th>Title</th>
            <th>Authors</th>
            <th>Review</th>
            <th>Abstract Link</th>
            <th>Deadline</th>
          </tr>
        </thead>
        <tbody>
          {papers.map(paper => (
            <tr key={paper.paperid}>
              <td><a href={`/update/${paper.reviewedPaper.paperid}`}>{paper.reviewedPaper.title}</a></td>
              <td>{paper.reviewedPaper.authors}</td>
              <td>{reviews[paper.reviewedPaper.paperid]}</td>


              <td><a href={paper.reviewedPaper.abstractLink}>{paper.reviewedPaper.abstractLink}</a></td>
              <td>{paper.reviewedPaper.deadLine}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default Reviewed;
