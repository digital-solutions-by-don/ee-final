import { useCallback, useState } from 'react';

export const useLocalStorage = (key) => {
  const [localStorageKey] = useState(key);

  const testLocalStorage = useCallback(() => {
    return !!localStorage.getItem(localStorageKey);
  }, [localStorageKey]);

  const getLocalStorage = useCallback(
    () => JSON.parse(localStorage.getItem(localStorageKey)), [localStorageKey]);

  const setLocalStorage = useCallback(
    value => localStorage.setItem(localStorageKey, JSON.stringify(value)),
    [localStorageKey]);

  const removeLocalStorage = useCallback(
    () => localStorage.removeItem(localStorageKey), [localStorageKey]);

  return {
    testLocalStorage,
    getLocalStorage,
    setLocalStorage,
    removeLocalStorage,
  };
};