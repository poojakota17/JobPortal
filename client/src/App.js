import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";
import React, { Component } from "react";
import { BrowserRouter as Router, Route } from "react-router-dom";
import Header from "./components/Header";
import ProfileLandingPage from "./components/candidateComponents/ProfileLandingPage";
import ResumePage from "./components/candidateComponents/ProfileUpdate/ResumePage";
import KeySkills from "./components/candidateComponents/ProfileUpdate/KeySkills";

class App extends Component {
  render() {
    return (
      <Router>
        <Header />
        <Route exact path="/candidate_profile" component={ProfileLandingPage} />
        <Route exact path="/resume_details" component={ResumePage} />
        <Route exact path="/skills" component={KeySkills} />
      </Router>
    );
  }
}
export default App;
