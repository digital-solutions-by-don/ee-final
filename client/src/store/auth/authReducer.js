import createReducer from '../utils/createReducer';
import {
  LOGIN_FAILURE,
  LOGIN_START,
  LOGIN_SUCCESS,
  LOGOUT_FAILURE,
  LOGOUT_START,
  LOGOUT_SUCCESS,
  REGISTER_FAILURE,
  REGISTER_START,
  REGISTER_SUCCESS, TOGGLE_AUTH_MESSAGE,
} from './authTypes';

const initialState = {
  isLoading: false,
  isRegisterSuccess: false,
  isAuth: false,
  errors: null,
};

const authActionStart = (state, payload) => ({
  ...state,
  isLoading: true,
  isAuth: false,
  isRegisterSuccess: false,
  errors: null,
});

const authActionFail = (state, payload) => {
  return ({
    ...state,
    isLoading: false,
    isAuth: false,
    isRegisterSuccess: false,
    errors: payload,
  });
};

const authLoginSuccess = (state, payload) => ({
  ...state,
  isLoading: false,
  isAuth: true,
  isRegisterSuccess: false,
  errors: null,
});

const authRegisterSuccess = (state, payload) => ({
  ...state,
  isLoading: false,
  isAuth: false,
  isRegisterSuccess: true,
  errors: null,
});

const authLogoutSuccess = (state, payload) => ({
  ...state,
  isLoading: false,
  isAuth: false,
  isRegisterSuccess: false,
  errors: null,
});

const authToggleMessage = (state, payload) => ({...state, errors: null});

export default createReducer(initialState, {
  [LOGIN_START]: authActionStart,
  [LOGIN_SUCCESS]: authLoginSuccess,
  [LOGIN_FAILURE]: authActionFail,
  [REGISTER_START]: authActionStart,
  [REGISTER_SUCCESS]: authRegisterSuccess,
  [REGISTER_FAILURE]: authActionFail,
  [LOGOUT_START]: authActionStart,
  [LOGOUT_SUCCESS]: authLogoutSuccess,
  [LOGOUT_FAILURE]: authActionFail,
  [TOGGLE_AUTH_MESSAGE]: authToggleMessage
});
