import { useCallback } from 'react';
import { useDispatch } from 'react-redux';
import {
  ADD_MESSAGE_FAILURE,
  ADD_MESSAGE_START,
  ADD_MESSAGE_SUCCESS,
} from './messageTypes';
import axios from 'axios';

export const useMessageActions = () => {
  const dispatch = useDispatch();
  const addMessage = useCallback(newMessage => {
    dispatch({ type: ADD_MESSAGE_START });
    axios.post('http://localhost:5000/api/messages', newMessage)
      .then(() => dispatch({ type: ADD_MESSAGE_SUCCESS }))
      .catch(error => dispatch(
        { type: ADD_MESSAGE_FAILURE, payload: error.response }));
  }, [dispatch]);

  return {addMessage};
};