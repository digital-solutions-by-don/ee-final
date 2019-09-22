import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import { Field, Form, withFormik } from 'formik';
import * as Yup from 'yup';
import { Section } from '../customStyles/Section';
import {
  Button,
  Card,
  Col,
  Container,
  Form as BootStrapForm,
  Row,
} from 'react-bootstrap';
import logo from '../../images/EmergencyElectricLogo.svg';
import { useSelector } from 'react-redux';

function Login2 ({ values, errors, touched, match: { url }, history: { push } }) {
  const [isRegister, setIsRegister] = useState(false);
  const isRegisterSuccess = useSelector(state => state.auth.isRegisterSuccess);
  const isAuth = useSelector(state => state.auth.isAuth);
  const apiErrors = useSelector(state => state.auth.errors);
  useEffect(() => {
    if (url === '/register') {
      setIsRegister(true);
    } else {
      setIsRegister(false);
    }
  }, [url]);

  useEffect(() => {
    if (isRegisterSuccess) {
      push('/login');
    }
  }, [isRegisterSuccess, push]);

  useEffect(()=> {
    if (isAuth) {
      push('/dashboard')
    }
  }, [isAuth, push]);

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
          <Card.Header className='text-center'>{isRegister
            ? 'Register'
            : 'Login'}</Card.Header>
          <Card.Body>
            {isRegisterSuccess && <span className='text-success small'>You have been successfully registered!  Please login in to continue.</span>}
            <Form>
              <BootStrapForm.Group as={Row}>
                <Col>
                  <BootStrapForm.Label sm='2'>Username</BootStrapForm.Label>
                  <Field
                    name='username'
                    type='text'
                    placeholder='Username'
                    className='form-control'
                  />
                  {touched.username && errors.username &&
                  <span className='text-danger small'>{errors.username}</span>}
                  {apiErrors && apiErrors.data && apiErrors.data.detail &&
                  <span className='text-danger small'>{apiErrors.data.detail}</span>}
                </Col>
              </BootStrapForm.Group>
              <BootStrapForm.Group as={Row}>
                <Col>
                  <BootStrapForm.Label sm='2'>Password</BootStrapForm.Label>
                  <Field
                    name='password'
                    type='password'
                    placeholder='Password'
                    className='form-control'
                  />
                  {touched.password && errors.password &&
                  <span className='text-danger small'>{errors.password}</span>}
                </Col>
              </BootStrapForm.Group>
              <Row>
                <Col>
                  <Button
                    variant='primary'
                    className='mr-2'
                    type='submit'
                  >Submit</Button>
                </Col>
              </Row>
            </Form>
          </Card.Body>
          <Card.Footer className='text-center'>
            {isRegister ? <Link to='/login'>Click Here to Login</Link> :
              <Link to='/register'>Click here to Register</Link>}
          </Card.Footer>
        </Card>
      </Container>
    </Section>
  );
}

const LoginWithFormik = withFormik({
  mapPropsToValues ({ username, password }) {
    return {
      username: username || '',
      password: password || '',
    };
  },
  validationSchema: Yup.object()
    .shape({
      username: Yup.string()
        .required('Username is required')
        .min(5, 'Username must be at least 5 characters long'),
      password: Yup.string()
        .required('Password is required')
        .min(5, 'Password must be at least 5 characters long'),
    }),
  handleSubmit (values, formikBag) {
    if (formikBag.props.match.url === '/register') {
      formikBag.props.register(values);
    } else {
      formikBag.props.login(values);
    }
    formikBag.resetForm({ username: '', password: '' });
  },
})(Login2);

export default LoginWithFormik;