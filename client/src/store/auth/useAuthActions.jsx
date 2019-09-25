import { useCallback } from 'react';
import { useDispatch } from 'react-redux';
import { useLocalStorage } from '../../hooks/useLocalStorage';
import { axiosLogin, axiosNoAuth } from '../utils/axiosConfig';
import {
  LOGIN_FAILURE,
  LOGIN_START,
  LOGIN_SUCCESS,
  REGISTER_FAILURE,
  REGISTER_START,
  REGISTER_SUCCESS,
  TOGGLE_AUTH_MESSAGE,
} from './authTypes';

export const useAuthActions = () => {
  const dispatch = useDispatch();
  const tokenService = useLocalStorage('ee-login-token');

  const login = useCallback(({ username, password }) => {
    dispatch({ type: LOGIN_START });
    axiosLogin()
      .post('/login',
        `grant_type=password&username=${username}&password=${password}`)
      .then(res => {
        tokenService.setLocalStorage(res.data.access_token);
        dispatch({ type: LOGIN_SUCCESS });
      })
      .catch(err => {
        tokenService.removeLocalStorage();
        dispatch({ type: LOGIN_FAILURE, payload: err.response });
      });
  }, [dispatch, tokenService]);

  const register = useCallback(credentials => {
    dispatch({ type: REGISTER_START });
    console.log(credentials);
    axiosNoAuth()
      .post('/auth/register', credentials)
      .then(() => dispatch({ type: REGISTER_SUCCESS }))
      .catch(
        err => dispatch({ type: REGISTER_FAILURE, payload: err.response }));
  }, [dispatch]);

  const toggleAuthMessage = useCallback(() => {
    dispatch({ type: TOGGLE_AUTH_MESSAGE });
  }, [dispatch]);

  return { login, register, toggleAuthMessage };
};