import createReducer from '../utils/createReducer';
import {
  ADD_MESSAGE_FAILURE,
  ADD_MESSAGE_START,
  ADD_MESSAGE_SUCCESS,
} from './messageTypes';

const initialState = {
  isSuccess: false,
  isLoading: false,
  errors: null,
};

const addMessageStart = (state, payload) => ({
  ...state,
  isLoading: true,
  isSuccess: false,
  errors: null,
});
const addMessageSuccess = (state, payload) => ({
  ...state,
  isLoading: false,
  isSuccess: true,
});
const addMessageFailure = (state, payload) => ({
  ...state,
  isLoading: false,
  isSuccess: false,
  errors: payload,
});
export default createReducer(initialState, {
  [ADD_MESSAGE_START]: addMessageStart,
  [ADD_MESSAGE_SUCCESS]: addMessageSuccess,
  [ADD_MESSAGE_FAILURE]: addMessageFailure,
});