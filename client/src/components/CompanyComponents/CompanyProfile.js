import React, { Component } from "react";
import Scroll from 'react-scroll';
import Carousel from "react-bootstrap/Carousel";

var Link = Scroll.Link;
var DirectLink = Scroll.DirectLink;
var Element = Scroll.Element;
var Events = Scroll.Events;
var scroll = Scroll.animateScroll;
var scrollSpy = Scroll.scrollSpy;

class CompanyProfile extends Component {
    constructor(props) {
        super(props);
        this.state={
                images:["../images/banker_icon.jpg","../images/banker_icon.jpg","../images/banker_icon.jpg"]
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
                                <h5 class="card-title">Company Name</h5>
                                <p class="card-text">INDUSTRY</p>
                            </div>
                            <ul class="list-group list-group-flush">

                                <Link className="showDivision" activeClass="active" to="firstInsideContainer" spy={true} smooth={true} duration={250} containerId="containerElement" >
                                    <i class="fa fa-info" aria-hidden="true"></i>&nbsp;&nbsp;Basic Information
                                </Link>

                                <Link className="showDivision" activeClass="active" to="secondInsideContainer" spy={true} smooth={true} duration={250} containerId="containerElement" >
                                    <i class="fa fa-sticky-note-o" aria-hidden="true"></i>&nbsp;&nbsp; About
                                </Link>

                                <Link className="showDivision" activeClass="active" to="thirdInsideContainer" spy={true} smooth={true} duration={250} containerId="containerElement" >
                                    <i class="fa fa-picture-o" aria-hidden="true"></i> &nbsp;&nbsp;Company Images
                                </Link>

                                <Link className="showDivision" activeClass="active" to="fourthInsideContainer" spy={true} smooth={true} duration={250} containerId="containerElement" >
                                    <i class="fa fa-phone-square" aria-hidden="true"></i> &nbsp;&nbsp; Contact
                                </Link>

                                <Link className="showDivision" activeClass="active" to="fifthInsideContainer" spy={true} smooth={true} duration={250} containerId="containerElement" >
                                    <i class="fa fa-laptop" aria-hidden="true"></i> &nbsp;&nbsp;Website
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
                                            B A S I C  &nbsp;&nbsp;I N F O R M A T I O N 
                </h5>
                                        <hr></hr>
                                        <form class="row">
                                            <div class="col-md-12">
                                                <label class="form-label">Company Name</label>
                                                <input
                                                    type="text"
                                                    class="form-control form-control-lg shadow-sm p-3 mb-5 bg-body rounded"
                                                />
                                            </div>
                                            <div class="col-md-12">
                                                <label class="form-label">Industry</label>
                                                <input
                                                    type="email"
                                                    class="form-control form-control-lg shadow-sm p-3 mb-5 bg-body rounded"
                                                />
                                            </div>                                           
                                        </form>
                                    </div>
                                </Element>

                                <Element name="secondInsideContainer" style={{
                                    marginBottom: '10px'
                                }}>
                                    <div class="card-body">
                                        <h5 class="card-title" style={{ padding: "0 0 10px 0" }}>
                                            A B O U T 
                </h5>
                                        <hr></hr>
                                        <form class="row">
                                        <div class="col-md-12">
                                                <label class="form-label">About Us</label>
                                                <input
                                                    as="textarea" rows={3} 
                                                    class="form-control form-control-lg shadow-sm p-3 mb-5 bg-body rounded"
                                                />
                                            </div>
                                        </form>
                                    </div>
                                </Element>
                                <Element name="thirdInsideContainer" style={{
                                    marginBottom: '30px'
                                }}>
                                    <div class="card-body">
                                        <h5 class="card-title" style={{ padding: "0 0 10px 0" }}>
                                            C O M P A N Y&nbsp;&nbsp;I M A G E S
                                        </h5>
                                        <hr></hr>
                                        <div className="carouselWidthHeight">
                                        <Carousel>
                                            {this.state.images.map((pic, index) => (
                                                <Carousel.Item key={index}>
                                                    <img
                                                        className="profileImage"
                                                        src={pic}
                                                        alt=""
                                                    />
                                                </Carousel.Item>
                                            ))}
                                        </Carousel>
                                        </div>
                                    </div>
                                </Element>
                                <Element name="fourthInsideContainer" style={{
                                    marginBottom: '30px'
                                }}>
                                    <div class="card-body">
                                        <h5 class="card-title" style={{ padding: "0 0 10px 0" }}>
                                            C O N T A C T &nbsp;&nbsp;I N F O R M A T I O N
                                        </h5>
                                        <hr></hr>
                                        <form class="row">
                                            <div class="col-md-12">
                                                <label class="form-label">Email</label>
                                                <input
                                                    type="email"
                                                    class="form-control form-control-lg shadow-sm p-3 mb-5 bg-body rounded"
                                                />
                                            </div>
                                        </form>
                                    </div>
                                </Element>
                                <Element name="fifthInsideContainer" style={{
                                    marginBottom: '30px'
                                }}>
                                    <div class="card-body">
                                        <h5 class="card-title" style={{ padding: "0 0 10px 0" }}>
                                            C O M P A N Y &nbsp;&nbsp;W E B S I T E
                                        </h5>
                                        <hr></hr>
                                        <form class="row">
                                            <div class="col-md-12">
                                                <label class="form-label">Website</label>
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

export default CompanyProfile;
