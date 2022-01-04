import React from "react";
import PropTypes from "prop-types";

const PostDescriptionText = ({ text }) => {
  return <div className="post-description-text">{text}</div>;
};

PostDescriptionText.propTypes = {
  text: PropTypes.string
};

export default PostDescriptionText;
