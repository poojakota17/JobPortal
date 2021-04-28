import React, { Component } from "react";
class ProfileLandingPage extends Component {
  render() {
    return (
      <div className="container">
        <div class="row">
          <div class="col-sm-4">
            <div
              class="card shadow p-3 mb-5 bg-white rounded"
              style={{ width: "18rem", margin: "50px" }}
            >
              <div class="card-body" style={{ margin: "70px 0 20px 0" }}>
                <h5 class="card-title">Jane Doe</h5>
                <p class="card-text">FullStack Developer</p>
              </div>
              <ul class="list-group list-group-flush">
                <a
                  href="#"
                  class="list-group-item list-group-item-action list-group-item-primary"
                >
                  <i class="far fa-user"></i> Profile
                </a>
                <a
                  href="/resume_details"
                  class="list-group-item list-group-item-action"
                >
                  <i class="far fa-file-alt"></i> My Resume
                </a>
                <a href="#" class="list-group-item list-group-item-action">
                  <i class="fas fa-briefcase"></i> Applied Jobs
                </a>
                <a href="#" class="list-group-item list-group-item-action">
                  <i class="far fa-bell"></i> Job Alerts
                </a>
                <a href="#" class="list-group-item list-group-item-action">
                  <i class="fas fa-sign-out-alt"></i> Log Out
                </a>
              </ul>
            </div>
          </div>
          <div class="col-sm-8">
            <div
              class="card shadow p-3 mb-5 bg-white rounded w-275"
              style={{ margin: "50px 0 0 0" }}
            >
              <div class="card-body">
                <h5 class="card-title" style={{ padding: "0 0 10px 0" }}>
                  BASIC INFORMATION
                </h5>
                <hr></hr>
                <form class="row">
                  <div class="col-6">
                    <label class="form-label">FirstName</label>
                    <input
                      type="text"
                      class="form-control form-control-lg shadow-sm p-3 mb-5 bg-body rounded"
                    />
                  </div>
                  <div class="col-md-6">
                    <label class="form-label">LastName</label>
                    <input
                      type="text"
                      class="form-control form-control-lg shadow-sm p-3 mb-5 bg-body rounded"
                    />
                  </div>
                  <div class="col-md-12">
                    <label class="form-label">Email</label>
                    <input
                      type="email"
                      class="form-control form-control-lg shadow-sm p-3 mb-5 bg-body rounded"
                    />
                  </div>
                  <h5
                    class="col-12 card-title"
                    style={{ padding: "0 0 10px 14px" }}
                  >
                    CONTACT INFORMATION
                  </h5>
                  <hr></hr>
                  <div class="col-md-6">
                    <label class="form-label fw-bold">Phone</label>
                    <input
                      type="text"
                      class="form-control form-control-lg shadow-sm p-3 bg-body rounded"
                    />
                  </div>
                  <div class="col-md-6">
                    <label class="form-label">Country</label>
                    <input
                      type="text"
                      class="form-control form-control-lg shadow-sm p-3 mb-5 bg-body rounded"
                    />
                  </div>
                  <div class="col-md-6">
                    <label class="form-label">Address</label>
                    <input
                      type="text"
                      class="form-control form-control-lg shadow-sm p-3 mb-5 bg-body rounded"
                    />
                  </div>
                  <div class="col-md-6">
                    <label class="form-label">City</label>
                    <input
                      type="text"
                      class="form-control form-control-lg shadow-sm p-3 mb-5 bg-body rounded"
                    />
                  </div>
                  <div class="col-md-6">
                    <label class="form-label">State</label>
                    <input
                      type="text"
                      class="form-control form-control-lg shadow-sm p-3 mb-3 bg-body rounded"
                    />
                  </div>
                  <div class="col-md-6">
                    <label class="form-label">Zip</label>
                    <input
                      type="text"
                      class="form-control form-control-lg shadow-sm p-3 mb-5 bg-body rounded"
                    />
                  </div>

                  <div class="col-12">
                    <button type="submit" class="btn btn-primary">
                      Save Setting
                    </button>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default ProfileLandingPage;
