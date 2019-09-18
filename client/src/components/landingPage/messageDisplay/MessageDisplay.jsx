import React, { useContext } from 'react';
import { Alert, Button } from 'react-bootstrap';
import { useSelector } from 'react-redux';
import { ActionsContext } from '../../../contexts/ActionsContext';

function MessageDisplay () {
  const isSuccess = useSelector(state => state.messages.isSuccess);
  const errors = useSelector(state => state.messages.errors);
  const { messageActions: { toggleMessage } } = useContext(ActionsContext);
  const variant = isSuccess ? 'success' : errors ? 'danger' : '';
  const message = isSuccess ? 'Message sent successfully' : errors
    ? 'Message was not sent, please try again.'
    : '';
  return (
    <div className='text-center'>
      <Alert
        variant={variant}
        className='mb-0'
      >
        {message}
        <Button
          variant={`outline-${variant}`}
          size='sm'
          className='ml-2'
          onClick={toggleMessage}
        >
          Dismiss
        </Button>
      </Alert>
    </div>
  );
}

export default MessageDisplay;