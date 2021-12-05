import { useKeycloak } from "@react-keycloak/web";
import React from "react";
import MemButton from "./common/mem-button.component";

const MemoriesApp = () => {
  const { keycloak } = useKeycloak();
  return (
    <div className="App">
      <MemButton onClick={() => keycloak.login()}>Login</MemButton>
    </div>
  );
};

export default MemoriesApp;
