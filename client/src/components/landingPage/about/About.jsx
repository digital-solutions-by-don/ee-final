import React from 'react';
import { Col, Container, Row } from 'react-bootstrap';
import Scrollchor from 'react-scrollchor';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faAngleDoubleUp } from '@fortawesome/free-solid-svg-icons';
import { Section } from '../../customStyles/Section';

function About () {
  return (
    <Section
      className='bg-light text-dark'
      id='about'
    >
      <Container className='text-center'>
        <Row>
          <Col
            lg={10}
            className='mx-auto'
          >
            <h2>Why Choose Us</h2>
            <p className='lead font-weight-bold'>
              With many years of experience in the electrical industry, we take
              pride in our professionalism, punctuality, and customer service.
            </p>
            <p className='lead'>
              Our primary measure of success is customer satisfaction. We define
              customers as employees, partners and clients. Our intent is to
              earn and maintain the respect and trust of everyone we come in
              contact with when representing Emergency Electric, Inc.
            </p>
            <p className='lead mb-5'>
              We believe in a personal touch to making ourselves known in the
              market. Referral and repeat business is important to us. We want
              every customer to be 100% satisfied with our service and work. We
              are confident that we meet this goal and that is why we offer a
              100% customer satisfaction guarantee.
            </p>
            <Scrollchor
              to='#services'
              className='btn btn-warning btn-lg mr-2'
            >
              What We Offer
            </Scrollchor>
            <Scrollchor
              to='#page-top'
              className='btn btn-warning btn-lg'
            >
              <FontAwesomeIcon icon={faAngleDoubleUp} />
            </Scrollchor>
          </Col>
        </Row>
      </Container>
    </Section>
  );
}

export default About;