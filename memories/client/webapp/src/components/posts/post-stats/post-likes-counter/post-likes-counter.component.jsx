import React from "react";
import PropTypes from "prop-types";
import { LikeFilled, LikeTwoTone } from "@ant-design/icons";
import clsx from "clsx";

const PostLikesCounter = ({ filled, count, onLike }) => {
  return (
    <div className="post-likes-counter">
      <div
        className={clsx("post-likes-counter__icon", { "_two-tone": !filled })}
        onClick={onLike}
      >
        {filled ? <LikeFilled /> : <LikeTwoTone />}
      </div>
      <div className="post-likes-counter__value">{count}</div>
    </div>
  );
};

PostLikesCounter.propTypes = {
  filled: PropTypes.bool.isRequired,
  count: PropTypes.number.isRequired,
  onLike: PropTypes.func.isRequired
};

export default PostLikesCounter;
