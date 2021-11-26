import { useKeycloak } from "@react-keycloak/web";
import React from "react";

const MemoriesApp = () => {
  const { keycloak } = useKeycloak();
  return (
    <div className="App">
      <button onClick={() => keycloak.login()}>Login</button>
    </div>
  );
};

export default MemoriesApp;
