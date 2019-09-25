import { useCallback } from 'react';
import { useDispatch } from 'react-redux';
import { useLocalStorage } from '../../hooks/useLocalStorage';
import { axiosWithAuth } from '../utils/axiosConfig';
import {
  GET_CURRENT_USER_FAILURE,
  GET_CURRENT_USER_START,
  GET_CURRENT_USER_SUCCESS,
} from './userTypes';

export const useUserActions = () => {
  const dispatch = useDispatch();
  const tokenService = useLocalStorage('ee-login-token');

  const getCurrentUser = useCallback(() => {
    dispatch({ type: GET_CURRENT_USER_START });
    axiosWithAuth(tokenService.getLocalStorage())
      .get('/users/user')
      .then(res => dispatch({type: GET_CURRENT_USER_SUCCESS, payload: res.data}))
      .catch(err => {
        tokenService.removeLocalStorage();
        dispatch({type: GET_CURRENT_USER_FAILURE, payload: err.response})
      });
  }, [dispatch, tokenService]);

  return {getCurrentUser}
};