
import React, { Component } from "react";

class AddRecruiter extends Component {
  render() {
    return (
      <div className="container">
        <div class="row">
          <div class="col-sm-12">
            <div
              class="card shadow p-3 mb-5 bg-white rounded w-275"
              style={{ margin: "50px 0 0 0" }}
            >

              <div class="card-body">
                <h5 class="card-title" style={{ padding: "0 0 10px 0" }}>
                  A D D &nbsp;&nbsp;A &nbsp;&nbsp; R E C R U I T E R
                                </h5>
                <hr></hr>
                <form class="row">
                  <div class="col-6">
                    <label class="form-label">First Name</label>
                    <input
                      type="text"
                      class="form-control form-control-lg shadow-sm p-3 mb-5 bg-body rounded"
                    />
                  </div>
                  <div class="col-md-6">
                    <label class="form-label">Last Name</label>
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
                  <div class="col-md-12">
                    <label class="form-label">Phone</label>
                    <input
                      type="text"
                      class="form-control form-control-lg shadow-sm p-3 mb-5 bg-body rounded"
                    />
                  </div>
                  <div class="col-12">
                    <button type="submit" class="btn btn-primary">
                      Save Recruiter Info
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

export default AddRecruiter;
