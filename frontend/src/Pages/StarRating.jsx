import React from 'react';

const StarRating = ({ rating, onRateChange }) => {
  const stars = Array(5).fill(0).map((star, index) => {
    const starRating = index + 1;
    const starStyle = {
      cursor: 'pointer',
      color: rating >= starRating ? 'gold' : '#ccc', // Adjust colors as needed
      fontSize: '24px', // Adjust font size as needed
    };
    return (
      <span key={index} style={starStyle} onClick={() => onRateChange(starRating)}>
        &#9733; {/* Replace with your desired star symbol */}
      </span>
    );
  });

  return <div className="star-rating">{stars}</div>;
};

export default StarRating;
