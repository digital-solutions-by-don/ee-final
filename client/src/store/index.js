import { applyMiddleware, combineReducers, createStore } from 'redux';
import { composeWithDevTools } from 'redux-devtools-extension';
import thunk from 'redux-thunk';
import logger from 'redux-logger';
import messages from './message/messageReducer';
import auth from './auth/authReducer';
import user from './user/userReducer';

const rootReducer = combineReducers({ auth, messages, user });

const middleware = [thunk, logger];
const enhancers = applyMiddleware(...middleware);

export default createStore(rootReducer, composeWithDevTools(enhancers));