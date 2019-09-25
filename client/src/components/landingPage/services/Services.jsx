import React from 'react';
import { Col, Container, Image, Row } from 'react-bootstrap';
import commercial from '../../../images/osama-saeed-1433239-unsplash.jpg';
import residential from '../../../images/erik-mclean-1117932-unsplash.jpg';
import industrial from '../../../images/robin-sommer-559996-unsplash.jpg';
import Scrollchor from 'react-scrollchor';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faAngleDoubleUp } from '@fortawesome/free-solid-svg-icons';
import { Section } from '../../customStyles/Section';

function Services () {
  return (
    <Section
      className='bg-warning text-secondary text-center'
      id='services'
    >
      <Container>
        <h3 className='mb-1'>Services</h3>
        <h2 className='mb-5'>We Specialize In</h2>
        <Row className='mb-5'>
          <Col
            lg={4}
            md={12}
            className='mb-5 mb-lg-0'
          >
            <Image
              src={residential}
              thumbnail={true}
              className='mb-2'
              alt='Houses'
            />
            <h4>Residential</h4>
            <p className='lead'>
              Emergency Electric, Inc can assist with any type of residential
              renovation, whether you are building an
              extension to your home or installing recessed lights in your
              condo.
            </p>
          </Col>
          <Col
            lg={4}
            md={12}
            className='mb-5 mb-lg-0'
          >
            <Image
              src={commercial}
              thumbnail={true}
              className='mb-2'
              alt='High Rise Buildings'
            />
            <h4>Commercial</h4>
            <p className='lead'>
              Emergency Electric, Inc offers a variety of commercial services,
              by our commercial electrical contractors.
            </p>
          </Col>
          <Col
            lg={4}
            md={12}
            className='mb-5 mb-lg-0'
          >
            <Image
              src={industrial}
              thumbnail={true}
              className='mb-2'
              alt='Industrial Workplace'
            />
            <h4>Industrial</h4>
            <p className='lead'>
              Emergency Electric, Inc offers a variety of industrial services by
              our industrial electrical contractors.
            </p>
          </Col>
        </Row>
        <Scrollchor
          to='#testimonials'
          className='btn btn-outline-light btn-lg mr-2'
        >
          What Others Say
        </Scrollchor>
        <Scrollchor
          to='#page-top'
          className='btn btn-outline-light btn-lg'
        >
          <FontAwesomeIcon icon={faAngleDoubleUp} />
        </Scrollchor>
      </Container>
    </Section>
  );
}

export default Services;