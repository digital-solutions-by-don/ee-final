import createReducer from '../utils/createReducer';
import {
  GET_CURRENT_USER_FAILURE,
  GET_CURRENT_USER_START,
  GET_CURRENT_USER_SUCCESS,
} from './userTypes';

const initialState = {
  user: {},
  isLoading: false,
  errors: null,
};

const getCurrentUserStart = (state, payload) => ({
  ...state,
  user: {},
  isLoading: true,
  errors: null,
});

const getCurrentUserSuccess = (state, payload) => ({
  ...state,
  user: payload,
  isLoading: false,
  errors: null,
});

const getCurrentUserFail = (state, payload) => ({
  ...state,
  user: {},
  isLoading: false,
  errors: payload,
});

export default createReducer(initialState, {
  [GET_CURRENT_USER_START]: getCurrentUserStart,
  [GET_CURRENT_USER_SUCCESS]: getCurrentUserSuccess,
  [GET_CURRENT_USER_FAILURE]: getCurrentUserFail,
});