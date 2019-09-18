import React from 'react';
import { Col, Container, Row } from 'react-bootstrap';
import Scrollchor from 'react-scrollchor';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faAngleDoubleUp } from '@fortawesome/free-solid-svg-icons';
import { Section } from '../../customStyles/Section';

function Testimonials () {
  return (
    <Section
      className='bg-light text-dark text-center'
      id='testimonials'
    >
      <Container>
        <h3 className='mb-1'>Testimonials</h3>
        <h2 className='mb-5'>Hear from our customers!</h2>
        <Row className='mb-5'>
          <Col
            md={6}
            className='mb-5 mb-lg-0'
          >
            <blockquote className='blockquote'>
              <p className='mb-0'>
                `They were very efficient, prompt and courteous. They even did a
                little bit extra that they really did not have to do. They were
                quick. I have used them twice now`
              </p>
              <footer className='blockquote-footer'>
                <cite>Arlene W.</cite>
              </footer>
            </blockquote>
          </Col>
          <Col
            md={6}
            className='mb-5 mb-lg-0'
          >
            <blockquote className='blockquote'>
              <p className='mb-0'>
                `They do very good electrical work. They are friendly,
                conscientious about their work, arrive on time, charge fair
                prices and make good recommendations about our electrical
                service. I liked their personal touch, and helpful, attentive
                interest. I have used them twice and would use them again`
              </p>
              <footer className='blockquote-footer'>
                <cite>John Robertson</cite>
              </footer>
            </blockquote>
          </Col>
        </Row>
        <Scrollchor
          to='#goals'
          className='btn btn-warning btn-lg mr-2'
        >
          Our Goals
        </Scrollchor>
        <Scrollchor
          to='#page-top'
          className='btn btn-warning btn-lg'
        >
          <FontAwesomeIcon icon={faAngleDoubleUp} />
        </Scrollchor>
      </Container>
    </Section>
  );
}

export default Testimonials;