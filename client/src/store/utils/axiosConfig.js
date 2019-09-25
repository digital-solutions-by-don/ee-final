import axios from 'axios';

import {
  DEVELOPMENT_URL,
  OAUTHCLIENT,
  OAUTHSECRET,
} from '../../secrets/secrets';

const loginCredentials = `${OAUTHCLIENT}:${OAUTHSECRET}`;

export const axiosNoAuth = () => axios.create({
  baseURL: DEVELOPMENT_URL,
});

export const axiosLogin = () => axios.create({
  baseURL: DEVELOPMENT_URL,
  headers: {
    'Authorization': `Basic ${btoa(loginCredentials)}`,
    'Content-Type': 'application/x-www-form-urlencoded',
  },
});

export const axiosWithAuth = token => axios.create({
  baseURL: DEVELOPMENT_URL,
  headers: {
    'Authorization': `Bearer ${token}`,
  },
});
