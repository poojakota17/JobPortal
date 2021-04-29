import React, { Component } from "react";
import Scroll from 'react-scroll';
import Carousel from "react-bootstrap/Carousel";
import Image from 'react-bootstrap/Image';
import ListGroup from 'react-bootstrap/ListGroup'

var Link = Scroll.Link;
var DirectLink = Scroll.DirectLink;
var Element = Scroll.Element;
var Events = Scroll.Events;
var scroll = Scroll.animateScroll;
var scrollSpy = Scroll.scrollSpy;

class ResumePage extends Component {
  constructor(props) {
    super(props);
    this.state = {
      images: ["../images/banker_icon.jpg", "../images/banker_icon.jpg", "../images/banker_icon.jpg"],
      educationList: [{
        id: 1,
        University: "MG",
        startDate: "12/12/2021",
        endDate: "01/01/2020",
        degree: "Undergrad",
        major: "software"
      },
      {
        id: 2,
        University: "cusat",
        startDate: "12/12/2021",
        endDate: "01/01/2020",
        degree: "Undergrad",
        major: "cs"
      }],
      workHistory: [{
        id: 1,
        name: "CTS",
        city: "KOCHI",
        state: "KERALA",
        jobResponsibilities: "FULL STACK DEVELOPER",
        startDate: "01/02/2020",
        endDate: "02/02/2020"
      },
      {
        id: 2,
        name: "Tcs",
        city: "Trivandrum",
        state: "KERALA",
        jobResponsibilities: "FULL STACK DEVELOPER",
        startDate: "01/02/2020",
        endDate: "02/02/2020"
      }],
      skills: [{
        id: 1,
        skill: "JAVA"
      },
      {
        id: 2,
        skill: "REACT"
      }]
    }
    this.scrollToTop = this.scrollToTop.bind(this);
  }

  componentDidMount() {

    Events.scrollEvent.register('begin', function () {
      console.log("begin", arguments);
    });

    Events.scrollEvent.register('end', function () {
      console.log("end", arguments);
    });

    scrollSpy.update();

  }

  scrollToTop() {
    scroll.scrollToTop();
  }
  componentWillUnmount() {
    Events.scrollEvent.remove('begin');
    Events.scrollEvent.remove('end');
  }
  render() {
    return (
      <div className="container">
        <div class="row">
          <div class="col-sm-3">
            <div
              class="card shadow p-3 mb-5 bg-white rounded"
              style={{ width: "15rem", marginTop: "50px" }}
            >
              <div class="card-body">
                <Image style={{ width: "150px", height: "150px" }} src="../images/dp.jpg" alt="profile image" roundedCircle />
                <h5 class="card-title">Candidate Name</h5>
              </div>
              <ul class="list-group list-group-flush">

                <Link className="showDivision" activeClass="active" to="firstInsideContainer" spy={true} smooth={true} duration={250} containerId="containerElement" >
                <i class="fa fa-book" aria-hidden="true"></i>&nbsp;&nbsp;Education
                                </Link>

                <Link className="showDivision" activeClass="active" to="secondInsideContainer" spy={true} smooth={true} duration={250} containerId="containerElement" >
                <i class="fa fa-briefcase" aria-hidden="true"></i>&nbsp;&nbsp; Employment History
                                </Link>

                <Link className="showDivision" activeClass="active" to="thirdInsideContainer" spy={true} smooth={true} duration={250} containerId="containerElement" >
                <i class="fa fa-plus-square-o" aria-hidden="true"></i> &nbsp;&nbsp;Skills
                                </Link>

                <Link className="showDivision" activeClass="active" to="fourthInsideContainer" spy={true} smooth={true} duration={250} containerId="containerElement" >
                <i class="fa fa-file-text-o" aria-hidden="true"></i> &nbsp;&nbsp; Attach Resume
                                </Link>
              </ul>
            </div>
          </div>
          <div class="col-sm-9">
            <div
              class="card shadow p-3 mb-5 bg-white rounded w-275"
              style={{ margin: "50px 0 0 0" }}
            >
              <Element name="test7" className="element" id="containerElement" style={{
                position: 'relative',
                height: '500px',
                marginTop: '50px',
                overflowY: 'scroll'
              }}>

                <Element name="firstInsideContainer" style={{
                  marginBottom: '10px'
                }}>
                  <div class="card-body">
                    <h5 class="card-title" style={{ padding: "0 0 10px 0" }}>
                      E D U C A T I O N
                </h5>
                    <hr></hr>

                    {this.state.educationList.map((education) => (

                      <form class="row">
                        <hr />
                        <div class="col-md-12">
                          <label class="form-label">University</label>
                          <input
                            type="text"
                            class="form-control form-control-lg shadow-sm p-3 mb-5 bg-body rounded"
                            value={education.University}
                          />
                        </div>
                        <div class="col-md-6">
                          <label class="form-label">Degree</label>
                          <input
                            type="text"
                            class="form-control form-control-lg shadow-sm p-3 mb-5 bg-body rounded"
                            value={education.degree}
                          />
                        </div>
                        <div class="col-md-6">
                          <label class="form-label">Major</label>
                          <input
                            type="text"
                            class="form-control form-control-lg shadow-sm p-3 mb-5 bg-body rounded"
                            value={education.major}
                          />
                        </div>
                        <div class="col-md-6">
                          <label class="form-label">Start Date</label>
                          <input
                            type="text"
                            class="form-control form-control-lg shadow-sm p-3 mb-5 bg-body rounded"
                            value={education.startDate}
                          />
                        </div>
                        <div class="col-md-6">
                          <label class="form-label">End Date</label>
                          <input
                            type="text"
                            class="form-control form-control-lg shadow-sm p-3 mb-5 bg-body rounded"
                            value={education.endDate}
                          />
                        </div>
                        <hr />
                      </form>
                    ))}

                  </div>
                </Element>

                <Element name="secondInsideContainer" style={{
                  marginBottom: '10px'
                }}>
                  <div class="card-body">
                    <h5 class="card-title" style={{ padding: "0 0 10px 0" }}>
                      E M P L O Y M E N T &nbsp;&nbsp; H I S T O R Y
                </h5>
                    <hr></hr>

                    {this.state.workHistory.map((work) => (

                      <form class="row">
                        <hr />
                        <div class="col-md-12">
                          <label class="form-label">Company Name</label>
                          <input
                            type="text"
                            class="form-control form-control-lg shadow-sm p-3 mb-5 bg-body rounded"
                            value={work.name}
                          />
                        </div>
                        <div class="col-md-12">
                          <label class="form-label">Job Responsiblities</label>
                          <input
                            type="text"
                            class="form-control form-control-lg shadow-sm p-3 mb-5 bg-body rounded"
                            value={work.jobResponsibilities}
                          />
                        </div>
                        <div class="col-md-6">
                          <label class="form-label">City</label>
                          <input
                            type="text"
                            class="form-control form-control-lg shadow-sm p-3 mb-5 bg-body rounded"
                            value={work.city}
                          />
                        </div>
                        <div class="col-md-6">
                          <label class="form-label">State</label>
                          <input
                            type="text"
                            class="form-control form-control-lg shadow-sm p-3 mb-5 bg-body rounded"
                            value={work.state}
                          />
                        </div>
                        <div class="col-md-6">
                          <label class="form-label">Start Date</label>
                          <input
                            type="text"
                            class="form-control form-control-lg shadow-sm p-3 mb-5 bg-body rounded"
                            value={work.startDate}
                          />
                        </div>
                        <div class="col-md-6">
                          <label class="form-label">End Date</label>
                          <input
                            type="text"
                            class="form-control form-control-lg shadow-sm p-3 mb-5 bg-body rounded"
                            value={work.endDate}
                          />
                        </div>
                        <hr />
                      </form>
                    ))}

                  </div>
                </Element>
                <Element name="thirdInsideContainer" style={{
                  marginBottom: '30px'
                }}>
                  <div class="card-body">
                    <h5 class="card-title" style={{ padding: "0 0 10px 0" }}>
                      S K I L L  &nbsp;&nbsp;S E T
                                        </h5>
                    <hr></hr>
                    <form class="row">
                      <div class="col-md-12">
                        <ListGroup>
                          {this.state.skills.map((skill) => (
                            <ListGroup.Item>{skill.skill}</ListGroup.Item>
                          ))}
                        </ListGroup>
                      </div>
                    </form>
                  </div>

                </Element>
                <Element name="fourthInsideContainer" style={{
                  marginBottom: '30px'
                }}>
                  <div class="card-body">
                    <h5 class="card-title" style={{ padding: "0 0 10px 0" }}>
                      U P L O A D &nbsp;&nbsp;R E S U M E
                                        </h5>
                    <hr></hr>
                    <form class="row">
                      <div class="col-md-12">
                        <label class="form-label">Resume</label>
                        <input
                          type="email"
                          class="form-control form-control-lg shadow-sm p-3 mb-5 bg-body rounded"
                        />
                      </div>
                    </form>
                  </div>
                </Element>
                <a onClick={this.scrollToTop}>To the top!</a>
              </Element>
            </div>
          </div>

        </div>


      </div>
    );
  }
}

export default ResumePage;
