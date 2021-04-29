import React, { Component } from "react";
import Jumbotron from 'react-bootstrap/Jumbotron';
import Alert from 'react-bootstrap/Alert';
import Button from 'react-bootstrap/Button'
class ManageJobs extends Component {
    viewApplications(id){
        this.props.history.push(`/company/viewapplications/${id}`);
    }
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
                                    M A N A G E &nbsp;&nbsp;A P P L I C A T I O N S
                                </h5>
                                <hr></hr>
                                <Alert variant="secondary">
                                    <Alert.Heading>JOBID1</Alert.Heading>
                                    <span><h5>Job Title:  &nbsp;&nbsp; Job Role: </h5></span>
                                    <hr />
                                    <Button variant="secondary" size="sm" onClick={() => this.viewApplications("JOB1D1")}>
                                       View Applications for this position
                                    </Button>
                                </Alert>
                                <Alert variant="secondary">
                                    <Alert.Heading>JOBID2</Alert.Heading>
                                    <span><h5>Job Title:  &nbsp;&nbsp; Job Role: &nbsp;&nbsp; Job Description: </h5></span>
                                    <hr />
                                    <Button variant="secondary" size="sm" onClick={() => this.viewApplications("JOB1D1")}>
                                       View Applications for this position
                                    </Button>
                                </Alert>
                                <Alert variant="secondary">
                                    <Alert.Heading>JOBID3</Alert.Heading>
                                    <span><h5>Job Title:  &nbsp;&nbsp; Job Role: &nbsp;&nbsp; Job Description: </h5></span>
                                    <hr />
                                    <Button variant="secondary" size="sm" onClick={() => this.viewApplications("JOB1D1")}>
                                       View Applications for this position
                                    </Button>
                                </Alert>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default ManageJobs;
