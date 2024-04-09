import React from 'react';
import './Reviewed.css'; // Import CSS for styling stars (if needed)

const DisplayStarRating = ({ rating }) => {
  // Ensure rating is a valid number (handle potential errors)
  const safeRating = Math.max(Math.min(rating, 5), 0); // Clamp rating between 0 and 5

  const starCount = 5; // Number of stars to display
  const filledStars = Math.floor(safeRating); // Calculate filled stars based on clamped rating
  const emptyStars = starCount - filledStars; // Calculate empty stars

  return (
    <div className="star-rating">
      {Array(filledStars)
        .fill()
        .map((_, index) => (
          <i key={index} className="fas fa-star"></i>
        ))}
      {Array(emptyStars)
        .fill()
        .map((_, index) => (
          <i key={index + filledStars} className="far fa-star"></i>
        ))}
    </div>
  );
};

export default DisplayStarRating;
