import React, { useMemo } from "react";
import PropTypes from "prop-types";
import PostDescriptionAuthor from "./post-description-author.component.jsx";
import {
  createSelectPostAuthorProfile,
  createSelectPostAuthorNickname
} from "../../../../store/posts/posts.selectors";
import { useSelector } from "react-redux";

const PostDescriptionAuthorContainer = ({ id }) => {
  const selectAuthorProfile = useMemo(
    () => createSelectPostAuthorProfile(id),
    [id]
  );
  const selectAuthorNickname = useMemo(
    () => createSelectPostAuthorNickname(id),
    [id]
  );

  const profile = useSelector(selectAuthorProfile);
  const nickname = useSelector(selectAuthorNickname);

  return <PostDescriptionAuthor profile={profile} nickname={nickname} />;
};

PostDescriptionAuthorContainer.propTypes = {
  id: PropTypes.string.isRequired
};

export default React.memo(PostDescriptionAuthorContainer);
