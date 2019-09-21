import { applyMiddleware, combineReducers, createStore } from 'redux';
import { composeWithDevTools } from 'redux-devtools-extension';
import thunk from 'redux-thunk';
import logger from 'redux-logger';
import messages from './message/messageReducer';
import auth from './auth/authReducer';
const rootReducer = combineReducers({ auth, messages });

const middleware = [thunk, logger];
const enhancers = applyMiddleware(...middleware);

export default createStore(rootReducer, composeWithDevTools(enhancers));