import React from 'react';
import { Container, Navbar } from 'react-bootstrap';
import Scrollchor from 'react-scrollchor';

function Navigation () {
  return (
    <Navbar
      bg='primary'
      variant='dark'
      expand='lg'
      fixed='top'
      className='text-uppercase'
    >
      <Container className='justify-content-center mb-md-2 mb-lg-0'>
        <Navbar.Toggle
          aria-controls='navbar'
          className='navbar-toggler-right border=0'
        />
        <Navbar.Collapse
          id='navbar'
          className='text-center justify-content-center flex-column-md text-secondary'
        >
          <Scrollchor
            className='d-block d-lg-none shadow  nav-link text-light mr-0 font-weight-bold  navbar-brand'
            to='#page-top'
          >
            Emergency Electric Inc
          </Scrollchor>
          <Scrollchor
            to='#page-top'
            className=' nav-link text-secondary small'
          >
            Home
          </Scrollchor>
          <Scrollchor
            to='#about'
            className=' nav-link text-secondary small'
          >
            About
          </Scrollchor>

          <Scrollchor
            to='#page-top'
            className='d-none d-lg-block shadow  nav-link text-light mr-0 font-weight-bold navbar-brand'
          >
            Emergency Electric Inc
          </Scrollchor>
          <Scrollchor
            to='#testimonials'
            className=' nav-link text-secondary small'
          >
            Testimonials
          </Scrollchor>

          <Scrollchor
            to='#contact'
            className=' nav-link text-secondary small'
          >
            Contact
          </Scrollchor>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
}

export default Navigation;