import React from 'react';
import { Container } from 'react-bootstrap';
import Scrollchor from 'react-scrollchor';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faAngleDoubleUp } from '@fortawesome/free-solid-svg-icons';
import { Section } from '../../customStyles/Section';

function Goals () {
  return (
    <Section
      className='bg-warning text-secondary text-center'
      id='goals'
    >
      <Container>
        <h2 className='mb-5'>Our Goals</h2>
        <p className='lead mb-5'>
          We are committed to excellence. Our goal is to exceed your
          expectations. Using our years of experience and expertise and by
          providing a dynamic and skilled team, we will ensure your projects are
          a complete success. Our primary measure of success is customer
          satisfaction. We define customers as employees, partners and clients.
          Our intent is to earn and maintain the respect and trust of everyone
          we come in contact with when representing Emergency Electric Inc.
        </p>
        <Scrollchor
          to='#contact'
          className='btn btn-outline-light btn-lg mr-2'
        >
          Contact Us
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

export default Goals;