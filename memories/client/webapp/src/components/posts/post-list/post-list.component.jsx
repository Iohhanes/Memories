import React, { useEffect } from "react";
import PropTypes from "prop-types";
import Post from "../post.component.jsx";
import InfiniteScroll from "react-infinite-scroll-component";
import { SyncOutlined } from "@ant-design/icons";
import { useWindowSize } from "react-use";

const SCROLLABLE_POSTS_BLOCK_ID = "scrollablePostsDiv";

const PostList = ({ ids, onLoadMore }) => {
  const windowSize = useWindowSize();

  useEffect(() => {
    onLoadMore();
  }, [onLoadMore]);

  return (
    <div
      id={SCROLLABLE_POSTS_BLOCK_ID}
      className="post-list"
      style={{ height: `${windowSize.height}px` }}
    >
      <InfiniteScroll
        dataLength={ids.length}
        next={onLoadMore}
        hasMore={true}
        loader={<SyncOutlined spin className="post-list__loader" />}
        scrollableTarget={SCROLLABLE_POSTS_BLOCK_ID}
      >
        {ids && ids.map(id => <Post key={id} id={id} />)}
      </InfiniteScroll>
    </div>
  );
};

PostList.propTypes = {
  ids: PropTypes.arrayOf(PropTypes.string).isRequired,
  onLoadMore: PropTypes.func.isRequired
};

export default PostList;
