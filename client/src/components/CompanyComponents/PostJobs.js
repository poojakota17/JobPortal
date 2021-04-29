import React, { Component } from "react";

class PostJobs extends Component {
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
                                    P O S T &nbsp;&nbsp;N E W &nbsp;&nbsp; J O B 
                                </h5>
                                <hr></hr>
                                <form class="row">
                  <div class="col-6">
                    <label class="form-label">Job Title</label>
                    <input
                      type="text"
                      class="form-control form-control-lg shadow-sm p-3 mb-5 bg-body rounded"
                    />
                  </div>
                  <div class="col-md-6">
                    <label class="form-label">Role</label>
                    <input
                      type="text"
                      class="form-control form-control-lg shadow-sm p-3 mb-5 bg-body rounded"
                    />
                  </div>
                  <div class="col-md-12">
                    <label class="form-label">Description</label>
                    <input
                      type="text"
                      class="form-control form-control-lg shadow-sm p-3 mb-5 bg-body rounded"
                    />
                  </div>
                  <div class="col-md-6">
                  <div className="form-group">
                            <label> Job Type</label>
                            <select
                              name="category"
                              className="form-control"
                            >
                              <option value="">
                                {" "}
                                Please choose a Job Type{" "}
                              </option>
                             <option value="REGULAR">REGULAR  </option>
                             <option value="PART_TIME">PART_TIME  </option>
                             <option value="CONTRACTOR">  CONTRACTOR</option>
                             <option value="INTERN"> INTERN </option>
                            </select>
                          </div>
                  </div>
                  <div class="col-md-6">
                  <label class="form-label">Expiry Date</label>
                    <input
                      type="date"
                      class="form-control form-control-lg shadow-sm p-3 mb-5 bg-body rounded"
                    />                   
                  </div>
                  <div class="col-md-12">
                  <label class="form-label">Location</label>
                    <input
                      type="text"
                      class="form-control form-control-lg shadow-sm p-3 mb-5 bg-body rounded"
                    />
                  </div>
                  <div class="col-12">
                    <button type="submit" class="btn btn-primary">
                      Post New Job
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

export default PostJobs;
