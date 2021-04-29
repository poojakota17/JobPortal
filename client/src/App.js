import "./App.css";
import React, { Component } from "react";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import CandidateHomePage from './components/candidateComponents/CandidateHomePage';
import CompanyHomePage from './components/CompanyComponents/CompanyHomePage';
class App extends Component {
  render() {
    return (
      <Router>
        <Switch>
          <Route path="/candidate"  component={CandidateHomePage} />
          <Route path="/company" component={CompanyHomePage} />
        </Switch>
    </Router>
    );
  }
}
export default App;
