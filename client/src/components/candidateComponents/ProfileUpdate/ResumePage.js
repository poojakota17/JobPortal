import React, { Component } from "react";
import KeySkills from "./KeySkills";

class ResumePage extends Component {
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
                <a href="#" class="list-group-item list-group-item-action ">
                  Education
                </a>
                <a href="#" class="list-group-item list-group-item-action">
                  Employment History
                </a>
                <a href="#" class="list-group-item list-group-item-action">
                  Skills
                </a>
                <a href="#" class="list-group-item list-group-item-action">
                  Attach Resume
                </a>
              </ul>
            </div>
          </div>
          <div class="col-sm-8">
            <div class="card" style={{ margin: "50px 0 0 0" }}>
              <div class="card-body">
                <KeySkills />
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default ResumePage;
