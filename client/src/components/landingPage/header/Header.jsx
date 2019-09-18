import React from 'react';
import Scrollchor from 'react-scrollchor';
import { Button, Container } from 'react-bootstrap';
import { Section } from '../../customStyles/Section';

function Header () {
  return (
    <header>
      <Section
        header
        className='d-flex'
        id='page-top'
      >
        <Container className='text-center my-auto'>
          <h1 className='mb-1 text-primary'>Emergency Electric Inc</h1>
          <h3 className='mb-5 text-primary'>24 Hour Service | Licensed and
            Insured
            | Residential and Commercial</h3>
          <Scrollchor
            className='btn btn-info btn-lg mr-4'
            to='#about'
          >
            Find Out More
          </Scrollchor>
          {/* TODO: Switch to Link Component from the Router */}
          <Button
            href='/apply'
            variant='success'
            size='lg'
          >
            Apply Now
          </Button>
        </Container>
      </Section>
    </header>
  );
}

export default Header;