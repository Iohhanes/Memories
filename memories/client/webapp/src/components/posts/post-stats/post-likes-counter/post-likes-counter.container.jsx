import React, { useMemo, useState } from "react";
import PropTypes from "prop-types";
import {
  createSelectIsPostLiked,
  createSelectPostCountOfLikes
} from "../../../../store/posts/posts.selectors";
import { useSelector } from "react-redux";
import PostLikesCounter from "./post-likes-counter.component.jsx";

const PostLikesCounterContainer = ({ id }) => {
  const selectIsPostLiked = useMemo(() => createSelectIsPostLiked(id), [id]);
  const selectPostCountOfLikes = useMemo(
    () => createSelectPostCountOfLikes(id),
    [id]
  );

  const isPostLiked = useSelector(selectIsPostLiked);
  const countOfLikes = useSelector(selectPostCountOfLikes);

  const [filled, setFilled] = useState(isPostLiked);
  const [count, setCount] = useState(countOfLikes);

  const handleLike = () => {
    setFilled(!filled);
    setCount(filled ? count - 1 : count + 1);
  };

  return <PostLikesCounter filled={filled} count={count} onLike={handleLike} />;
};

PostLikesCounterContainer.propTypes = {
  id: PropTypes.string.isRequired
};

export default React.memo(PostLikesCounterContainer);
