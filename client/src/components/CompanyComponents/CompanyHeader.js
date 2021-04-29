import React, { Component } from "react";
class CompanyHeader extends Component {
  render() {
    return (
      <div >
        <nav
          class="navbar navbar-light border-bottom border-primary"
          style={{ padding: "20px" }}
        >
           
          <div class="container-fluid">
            <a class="main-logo" href="/company">
             <h5>J <i class="fas fa-globe-europe"></i> B &nbsp;P O R T A L</h5>
            </a>
            <a class="navbar-brand" href="/company/postJob">
            <i class="far fa-file"></i> {" "}Post A Job
            </a>
            <a class="navbar-brand" href="/company/manageJobs">
            <i class="fas fa-clipboard-check"></i> {" "}Manage Applications
            </a>
            <a class="navbar-brand" href="/company/browsecandidates">
            <i class="fa fa-search" aria-hidden="true"></i>{" "}Browse Candidates
            </a>
            <a class="navbar-brand" href="/company/addrecruiter">
            <i class="fa fa-user" aria-hidden="true"></i>{" "}Add Recruiter
            </a>
            <a class="navbar-brand" href="/">
            <i class="fa fa-sign-out" aria-hidden="true"></i>{" "}Logout
            </a>
          </div>
        </nav>
      </div>
    );
  }
}

export default CompanyHeader;
