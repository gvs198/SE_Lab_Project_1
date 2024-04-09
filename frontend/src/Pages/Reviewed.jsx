import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './Reviewed.css';

const Reviewed = () => {
  const [papers, setPapers] = useState([]);
  const authorId = localStorage.getItem('authorId');
  const token = localStorage.getItem('token');
  const [reviews, setReviews] = useState({}); // Object to store review data by paper ID
  const [ratings, setRatings] = useState({}); // Object to store ratings by paper ID

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get(`http://localhost:8080/papers/reviewedpapers/${authorId}`, {
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
  }, [authorId, token]);

  const getReview = async (paperId) => {
    try {
      const response = await axios.get(`http://localhost:8080/reviews/getreview/${parseInt(paperId)}/${authorId}`, {
        headers: {
          Authorization: 'Bearer ' + token
        }
      });
      setReviews(prevReviews => ({ ...prevReviews, [paperId]: response.data }));
    } catch (error) {
      console.error(error);
    }
  };

  const getRating = async (paperId) => {
    try {
      const response = await axios.get(`http://localhost:8080/reviews/getrating/${paperId}/${authorId}`, {
        headers: {
          Authorization: 'Bearer ' + token
        }
      });
      setRatings(prevRatings => ({ ...prevRatings, [paperId]: response.data }));
    } catch (error) {
      console.error(error);
    }
  };

  useEffect(() => {
    papers.forEach(paper => {
      getReview(paper.reviewedPaper.paperid);
      getRating(paper.reviewedPaper.paperid);
    });
  }, [papers]);

  return (
    <div className="reviewed-container">
      <h1>Reviewed Papers</h1>
      <div className="reviewed-cards">
        {papers.map(paper => (
          <div className="reviewed-card" key={paper.paperid}>
            <div className="reviewed-card-header">
              <h2><a href={`/update/${paper.reviewedPaper.paperid}`}>{paper.reviewedPaper.title}</a></h2>
              <p>Authors: {paper.reviewedPaper.authors}</p>
              <p>Deadline: {paper.reviewedPaper.deadLine}</p>
            </div>
            <div className="reviewed-card-content">
              {/* Display Rating fetched by getRating */}
              <p>Rating: {ratings[paper.reviewedPaper.paperid]}</p>
              {/* Display Content fetched by getReview (use optional chaining) */}
              <p>{reviews[paper.reviewedPaper.paperid]}</p> {/* Access content with optional chaining */}
              <a href={paper.reviewedPaper.abstractLink}>Abstract Link</a>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default Reviewed;
