import React, { useContext } from 'react';
import { Section } from '../../customStyles/Section';
import { Button, Col, Container, Form, Row } from 'react-bootstrap';
import Scrollchor from 'react-scrollchor';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faAngleDoubleUp } from '@fortawesome/free-solid-svg-icons';
import { useForm } from '../../../hooks/useForm';
import { ActionsContext } from '../../../contexts/ActionsContext';

function Contact () {
  const [values, handleChange, handleSubmit, handleReset] = useForm({
    firstName: '',
    lastName: '',
    contact: '',
    subject: '',
    message: '',
  }, submitMessage);
  const { messageActions: { addMessage } } = useContext(ActionsContext);

  function submitMessage () {
    addMessage(values);
  }
  const {firstName, lastName, contact, subject, message} = values;
  return (
    <Section
      className='bg-light text-dark'
      id='contact'
    >
      <Container>
        <h3 className='mb-1 text-center'>Contact Us</h3>
        <h2 className='mb-5 text-center'>Send Us a Message!</h2>
        <Form onSubmit={handleSubmit}>
          <Form.Group controlId='formContact'>
            <Row className='mb-2'>
              <Col
                md={6}
                className='mb-sm-2 mb-md-0'
              >
                <Form.Control
                  required
                  value={firstName}
                  type='text'
                  placeholder='First Name'
                  name='firstName'
                  onChange={handleChange}
                />
                <Form.Control.Feedback type='invalid'>Required</Form.Control.Feedback>
              </Col>
              <Col md={6}>
                <Form.Control
                  required
                  name='lastName'
                  value={lastName}
                  type='text'
                  placeholder='Last Name'
                  onChange={handleChange}
                />
                <Form.Control.Feedback type='invalid'>Required</Form.Control.Feedback>
              </Col>
            </Row>
            <Form.Control
              required
              className='mb-2'
              type='text'
              value={contact}
              name='contact'
              placeholder='Contact'
              onChange={handleChange}
            />
            <Form.Control.Feedback type='invalid'>Please provide a valid email
              address</Form.Control.Feedback>
            <Form.Control
              required
              name='subject'
              value={subject}
              type='text'
              className='mb-2'
              placeholder='Subject'
              onChange={handleChange}
            />
            <Form.Control.Feedback type='invalid'>Required</Form.Control.Feedback>
            <Form.Control
              as='textarea'
              className='mb-2'
              rows={4}
              placeholder='Enter Message Here'
              required
              name='message'
              value={message}
              onChange={handleChange}
            />
            <Button
              type='submit'
              variant='warning'
              className='mr-2'
              size='lg'
            >
              Send Message
            </Button>
            <Button
              type='button'
              variant='outline-warning'
              size='lg'
              onClick={handleReset}
            >
              Clear Form
            </Button>

            <Scrollchor
              to='#page-top'
              className='btn btn-warning btn-lg float-right'
            >
              <FontAwesomeIcon icon={faAngleDoubleUp} />
            </Scrollchor>
          </Form.Group>
        </Form>
      </Container>
    </Section>
  );
}

export default Contact;