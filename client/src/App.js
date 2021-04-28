import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";
import React, { Component } from "react";
import { BrowserRouter as Router, Route } from "react-router-dom";
import Profile from "./components/candidateComponents/Profile";
import Header from "./components/Header";

class App extends Component {
  render() {
    return (
      <Router>
        <Header />
        <Route exact path="/candidate_profile" component={Profile} />
      </Router>
    );
  }
}
export default App;
