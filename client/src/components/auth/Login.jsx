import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import { Button, Card, Col, Container, Form, Row } from 'react-bootstrap';
import logo from '../../images/EmergencyElectricLogo.svg';
import { useForm } from '../../hooks/useForm';
import { Section } from '../customStyles/Section';

function Login ({ match: { url } }) {
  const [register, setRegister] = useState(false);
  const [formValues, handleChange, handleSubmit, resetForm] = useForm({
    username: '',
    password: '',
  }, doSubmit);

  useEffect(() => {
    if (url === '/register') {
      setRegister(true);
    } else {
      setRegister(false);
    }
  }, [url]);

  function doSubmit () {
    console.log(formValues);
  }

  const { username, password } = formValues;
  return (
    <Section header>
      <Container
        fluid
        className='w-50 d-flex justify-content-center align-items-center mt-5'
      >
        <Card className='shadow'>
          <Card.Img
            variant='top'
            src={logo}
          />
          <Card.Header className='text-center'>{register
            ? 'Register'
            : 'Login'}</Card.Header>
          <Card.Body>
            <Form onSubmit={handleSubmit}>
              <Form.Group as={Row}>
                <Col>
                  <Form.Label
                    sm='2'
                  >Username</Form.Label>
                  <Form.Control
                    value={username}
                    onChange={handleChange}
                    name='username'
                  />
                </Col>
              </Form.Group>
              <Form.Group as={Row}>
                <Col>
                  <Form.Label
                    sm='2'
                  >Password</Form.Label>
                  <Form.Control
                    value={password}
                    onChange={handleChange}
                    name='password'
                    type='password'
                  />
                </Col>
              </Form.Group>
              <Row>
                <Col>
                  <Button
                    variant='primary'
                    type='submit'
                    className='mr-2'
                  >
                    Submit
                  </Button>
                  <Button
                    variant='outline-primary'
                    type='button'
                    onClick={resetForm}
                  >
                    Clear
                  </Button>
                </Col>
              </Row>
            </Form>
          </Card.Body>
          <Card.Footer className='text-center'>
            {register ? <Link to='/login'>Click here to Login</Link> :
              <Link to='/register'>Click here to Register</Link>}
          </Card.Footer>
        </Card>
      </Container>
    </Section>
  );
}

export default Login;