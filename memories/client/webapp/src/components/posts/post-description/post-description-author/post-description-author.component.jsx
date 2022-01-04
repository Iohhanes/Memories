import React from "react";
import PropTypes from "prop-types";

const PostDescriptionAuthor = ({ profile, nickname }) => {
  return (
    <div className="post-description-author">
      <div className="post-description-author__profile">
        <img src={profile} />
      </div>
      <div className="post-description-author__nickname">{nickname}</div>
    </div>
  );
};

PostDescriptionAuthor.propTypes = {
  profile: PropTypes.string,
  nickname: PropTypes.string.isRequired
};

export default PostDescriptionAuthor;
