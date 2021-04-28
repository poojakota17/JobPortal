import React, { Component } from "react";

class Header extends Component {
  render() {
    return (
      <div>
        <nav
          class="navbar navbar-light border-bottom border-primary"
          style={{ padding: "20px" }}
        >
          <div class="container-fluid">
            <a class="navbar-brand">
              <i class="fas fa-globe-europe"></i> JobPortal
            </a>
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
        </nav>
      </div>
    );
  }
}

export default Header;
