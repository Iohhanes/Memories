// import { useKeycloak } from "@react-keycloak/web";
import React from "react";
import PostListContainer from "./posts/post-list/post-list.container.jsx";

const MemoriesApp = () => {
  // const { keycloak } = useKeycloak();
  return (
    <div className="App">
      <PostListContainer />
    </div>
  );
};

export default MemoriesApp;
