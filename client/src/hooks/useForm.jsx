import { useState } from 'react';

export const useForm = (initialState, callBack) => {
  const [formValues, setFormValues] = useState(initialState);

  const handleSubmit = e => {
    e.preventDefault();
    callBack();
    setFormValues(initialState);
  };

  const handleChange = ({ target: { name, value } }) => setFormValues(
    { ...formValues, [name]: value });

  const resetForm = () => setFormValues(initialState);

  return [formValues, handleChange, handleSubmit, resetForm];
};