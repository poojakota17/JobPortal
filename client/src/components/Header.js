import React, { Component } from "react";
class Header extends Component {
  render() {
    return (
      <div>
        <nav
          class="navbar navbar-light border-bottom border-primary"
          style={{ padding: "20px" }}
        >
           
          <div class="container-fluid">
            <a class="main-logo" href="/candidate">
             <h5>J <i class="fas fa-globe-europe"></i> B &nbsp;P O R T A L</h5>
            </a>
            <a class="navbar-brand" href="/candidate/findJob">
            <i class="fa fa-search" aria-hidden="true"></i>{" "}Search Jobs
            </a>
            <a class="navbar-brand" href="/candidate/resume_details">
            <i class="far fa-file"></i> {" "}Resume
            </a>
            <a class="navbar-brand" href="/candidate/appliedjobs">
            <i class="fas fa-clipboard-check"></i>{" "} Applied Jobs
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

export default Header;
