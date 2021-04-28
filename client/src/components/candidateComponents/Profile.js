import React, { Component } from "react";
class Profile extends Component {
  render() {
    return (
      <div className="container">
        <div
          class="card shadow p-3 mb-5 bg-white rounded"
          style={{ width: "18rem", margin: "50px" }}
        >
          <div class="card-body" style={{ margin: "70px 0 20px 0" }}>
            <h5 class="card-title">Jane Doe</h5>
            <p class="card-text">FullStack Developer</p>
          </div>
          <ul class="list-group list-group-flush">
            <li class="list-group-item">
              <i class="far fa-user"></i> Profile
            </li>
            <li class="list-group-item">
              <i class="far fa-file-alt"></i> My Resume
            </li>
            <li class="list-group-item">
              <i class="fas fa-briefcase"></i> Applied Jobs
            </li>
            <li class="list-group-item">
              <i class="far fa-bell"></i> Job Alerts
            </li>
            <li class="list-group-item">
              <i class="fas fa-sign-out-alt"></i> Log Out
            </li>
          </ul>
        </div>
      </div>
    );
  }
}

export default Profile;
