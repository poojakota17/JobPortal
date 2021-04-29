import React, { Component } from "react";
import { Switch, Route } from "react-router-dom";
import ProfileLandingPage from './ProfileLandingPage';
import ResumePage from './ProfileUpdate/ResumePage';
import Header from '../Header';
import AppliedJobs from './AppliedJobs';
import SearchJobs from './SearchJobs';
class CandidateHomePage extends Component{
    constructor(props) {
        super(props);
        this.state = {

        };
    }
    componentDidMount() {

    }
    render() {
        return (
            <div>
                <div >
                    <Header/>
                </div>
                <Switch>
                    <Route path="/candidate" exact component={ProfileLandingPage} />
                    <Route exact path="/candidate/resume_details" component={ResumePage} />
                    <Route exact path="/candidate/findJob" component={SearchJobs} />
                    <Route exact path="/candidate/appliedjobs" component={AppliedJobs} />
                </Switch>
            </div>
        );
    }
}
export default CandidateHomePage;
