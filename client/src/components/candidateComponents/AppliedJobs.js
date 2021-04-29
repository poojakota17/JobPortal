import React, { Component } from "react";
import Alert from 'react-bootstrap/Alert';
class AppliedJobs extends Component {

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
                                    A P P L I E D  &nbsp;&nbsp;J O B S
                                </h5>
                                <hr></hr>
                                <Alert variant="secondary">
                                    <Alert.Heading>JOBID1</Alert.Heading>
                                    <span><h5>Job Title:  &nbsp;&nbsp; Job Role: </h5></span>
                                    <hr />
                                    <p>STATUS: </p>
                                </Alert>
                                <Alert variant="secondary">
                                    <Alert.Heading>JOBID2</Alert.Heading>
                                    <span><h5>Job Title:  &nbsp;&nbsp; Job Role: &nbsp;&nbsp; Job Description: </h5></span>
                                    <hr />
                                    <p>STATUS: </p>
                                </Alert>
                                <Alert variant="secondary">
                                    <Alert.Heading>JOBID3</Alert.Heading>
                                    <span><h5>Job Title:  &nbsp;&nbsp; Job Role: &nbsp;&nbsp; Job Description: </h5></span>
                                    <hr />
                                    <p>STATUS: </p>
                                </Alert>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default AppliedJobs;
