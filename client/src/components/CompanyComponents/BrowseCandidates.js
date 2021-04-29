import React, { Component } from "react";

class BrowseCandidates extends Component {
    render() {
        return (
            <div className="container">
                <div class="row">
                <div class="col-sm-12">
                    <br />
                    <br />
                    <form class="d-flex">
                        <input
                            class="form-control me-2"
                            type="search"
                            placeholder="Search"
                            aria-label="Search"
                            style={{ margin: "0 10px 0 0" }}
                        />
                        <button class="btn btn-outline-primary" type="submit">
                            Search
                        </button>
                    </form>
                    </div>
                </div>
            </div>
        );
    }
}

export default BrowseCandidates;
