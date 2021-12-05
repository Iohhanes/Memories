import Keycloak from "keycloak-js";
const keycloakConfig = {
  url: "http://localhost:8180/auth",
  realm: "memories-realm",
  clientId: "memories-client"
};
const keycloak = new Keycloak(keycloakConfig);
export default keycloak;
