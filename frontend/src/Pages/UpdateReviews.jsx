import React, { useState, useEffect } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import axios from 'axios';
import './UpdateReviews.css'; // Import CSS file
import StarRating from './StarRating'; // Import StarRating component

const UpdateReviews = () => {
  const [reviewBody, setReviewBody] = useState('');
  const [rating, setRating] = useState(0); // Initial rating state
  const [review, setReview] = useState('');
  const { paperId } = useParams();
  const userId = localStorage.getItem('authorId');
  const [message, setMessage] = useState('');

  const token = localStorage.getItem('token');
  const navigate = useNavigate();

  const getReview = async () => {
    try {
      const response = await axios.get(`http://localhost:8080/reviews/getreview/${paperId}/${userId}`, {
        headers: {
          Authorization: 'Bearer ' + token
        }
      });
      setReview(response.data.content); // Extract review content
      setRating(response.data.starRating); // Extract star rating (assuming this is a property in the response)
    } catch (error) {
      console.error(error.response.data);
    }
  };

  useEffect(() => {
    getReview();
  }, []); // Empty dependency array to ensure it's called once on component mount

  const handleSubmit = async (endpoint) => {
    try {
      const response = await axios.post(endpoint, { reviewBody, rating }, {
        headers: {
          Authorization: 'Bearer ' + token
        }
      });
      setMessage(response.data);
    } catch (error) {
      console.error('Error:', error.response.data);
      setMessage(error.response.data); // Display specific error message from the server
    }
  };

  const handleDelete = async (endpoint) => {
    try {
      const response = await axios.delete(endpoint, {
        headers: {
          Authorization: 'Bearer ' + token
        }
      });
      setMessage(response.data);
      navigate('/dashboard');
    } catch (error) {
      console.error('Error:', error.response.data);
      setMessage(error.response.data); // Display specific error message from the server
    }
  };

  const handleRatingChange = (newRating) => {
    setRating(newRating);
  };

  return (
    <div className="container">
      <h2>Update review</h2>
      <h3>Review:</h3>
      <p>{review}</p>
      <label>
        Review Body:
        <textarea value={reviewBody} onChange={(e) => setReviewBody(e.target.value)} />
      </label>
      <br />
      <label>
        Rating:
        <StarRating rating={rating} onRateChange={handleRatingChange} />
      </label>
      <br />
      <button onClick={() => handleSubmit(`http://localhost:8080/reviews/update/${paperId}/${userId}`)}>Update Review</button>
      <button onClick={() => handleDelete(`http://localhost:8080/reviews/delete/${paperId}/${userId}`)}>Delete Review</button>
      <p>{message}</p>
    </div>
  );
};

export default UpdateReviews;
