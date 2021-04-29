import React, { Component } from "react";
import { Switch, Route } from "react-router-dom";
import Header from '../Header';
import BrowseCandidates from './BrowseCandidates';
import ManageJobs from './ManageJobs';
import PostJobs from './PostJobs';
import CompanyProfile from './CompanyProfile';
import CompanyHeader from "./CompanyHeader";
import AddRecruiter from "./AddRecruiter";
import ViewApplications from './ViewApplications';
class CompanyHomePage extends Component{
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
                    <CompanyHeader/>
                </div>
                <Switch>
                    <Route path="/company" exact component={CompanyProfile} />
                    <Route exact path="/company/postJob" component={PostJobs} />
                    <Route exact path="/company/manageJobs" component={ManageJobs} />
                    <Route exact path="/company/browsecandidates" component={BrowseCandidates} />
                    <Route path="/company/viewapplications/:id"  component={ViewApplications} />
                    <Route exact path="/company/addrecruiter" component={AddRecruiter} />
                </Switch>
            </div>
        );
    }
}
export default CompanyHomePage;
