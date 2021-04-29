import React, { Component } from "react";
import Jumbotron from 'react-bootstrap/Jumbotron';
import Alert from 'react-bootstrap/Alert';
import Button from 'react-bootstrap/Button'
class ViewApplications extends Component {
    constructor(props) {
        super(props);
        this.state = {
            id: this.props.match.params.id

        };
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
                                    Applications For Job Id : {" "}{this.state.id}
                                </h5>
                                <hr></hr>
                                <Alert variant="secondary">
                                    <Alert.Heading>Application 1</Alert.Heading>
                                    <span><h5>Candidate:  &nbsp;&nbsp; Applied Date:</h5></span>
                                    <hr />
                                    <span><Button variant="success" size="sm">
                                        Shortlist
                                    </Button>{" "}
                                    <Button variant="danger" size="sm">
                                       Reject
                                        </Button>
                                    </span>
                                </Alert>
                                <Alert variant="secondary">
                                    <Alert.Heading>Application 2</Alert.Heading>
                                    <span><h5>Candidate:  &nbsp;&nbsp; Applied Date:</h5></span>
                                    <hr />
                                    <span><Button variant="success" size="sm">
                                        Shortlist
                                    </Button>{" "}
                                    <Button variant="danger" size="sm">
                                       Reject
                                        </Button>
                                    </span>
                                </Alert>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default ViewApplications;
