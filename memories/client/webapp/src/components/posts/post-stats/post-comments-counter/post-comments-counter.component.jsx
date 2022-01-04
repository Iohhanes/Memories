import React from "react";
import PropTypes from "prop-types";

const PostCommentsCounter = ({ count }) => {
  return <div className="post-comments-counter">{`${count} comments`}</div>;
};

PostCommentsCounter.propTypes = {
  count: PropTypes.number.isRequired
};

export default PostCommentsCounter;
