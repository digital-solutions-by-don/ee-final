import { useCallback } from 'react';
import { useDispatch } from 'react-redux';
import {
  ADD_MESSAGE_FAILURE,
  ADD_MESSAGE_START,
  ADD_MESSAGE_SUCCESS,
  TOGGLE_MESSAGE,
} from './messageTypes';
import {axiosNoAuth as axios} from '../utils/axiosConfig';

export const useMessageActions = () => {
  const dispatch = useDispatch();
  const addMessage = useCallback(newMessage => {
    dispatch({ type: ADD_MESSAGE_START });
    axios().post('/messages', newMessage)
      .then(() => dispatch({ type: ADD_MESSAGE_SUCCESS }))
      .catch(error => dispatch(
        { type: ADD_MESSAGE_FAILURE, payload: error.response }));
  }, [dispatch]);

  const toggleMessage = useCallback(() => dispatch({ type: TOGGLE_MESSAGE }),
    [dispatch]);

  return { addMessage, toggleMessage };
};