import React from 'react';
import {render} from 'react-dom';

import {Provider} from 'react-redux';
import store from './store';

import {BrowserRouter as Router} from 'react-router-dom';
import App from './components/App';

import './scss/emergency_electric.scss';

const application = <Provider store={store}><Router><App /></Router></Provider>
const rootDocument = document.getElementById('root');

render(application, rootDocument);