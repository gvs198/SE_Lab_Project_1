import React, { useState} from 'react';
import { useParams } from 'react-router-dom';
import axios from 'axios';
import './Reviews.css'; // Import CSS file

const Reviews = () => {
  const [reviewBody, setReviewBody] = useState('');
  const {paperId} = useParams();
  const userId = localStorage.getItem('authorId');
  const [message, setMessage] = useState('');
  const token = localStorage.getItem('token')

  const handleSubmit = async (endpoint) => {
    try {
      const response = await axios.post(endpoint, reviewBody,{
        headers: {
            Authorization : 'Bearer ' + token
        }
    });
      setMessage(response.data);
    } catch (error) {
      console.error('Error:', error.response.data);
      setMessage(error.response.data); // Display specific error message from the server
    }
  };

  return (
    <div className="container"> {/* Apply container class */}
      <h2>Submit review</h2>
      <label>
        Review Body:
        <textarea value={reviewBody} onChange={(e) => setReviewBody(e.target.value)} />
      </label>
      <br />
      <button onClick={() => handleSubmit(`http://localhost:8080/reviews/submitreview/${paperId}/${userId}`)}>Submit Review</button>
     
      <br />
      {/* <button onClick={() => handleSubmit(`http://localhost:8080/reviews/delete/${paperId}/${userId}`)}>Delete Review</button> */}
      <p>{message}</p>
    </div>
  );
};
export default Reviews;