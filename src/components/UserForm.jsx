import React, { useState } from 'react';

function UserForm() {
  const [formData, setFormData] = useState({
    name: '',
    balance: ''
  });

  const handleChange = (e) => {
    const { name, value } = e.target;

    setFormData((prev) => ({
      ...prev,
      [name]: value
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log('Submitted:', formData);
    // You could send it to backend here if needed
  };

  return (
    <form onSubmit={handleSubmit} style={{ padding: '1rem', maxWidth: '300px' }}>
      <div style={{ marginBottom: '1rem' }}>
        <label>Name: </label>
        <input
          type="text"
          name="name"
          value={formData.name}
          onChange={handleChange}
          required
        />
      </div>
      <div style={{ marginBottom: '1rem' }}>
        <label>Balance: </label>
        <input
          type="number"
          name="balance"
          value={formData.balance}
          onChange={handleChange}
          required
        />
      </div>
      <button type="submit">Submit</button>
    </form>
  );
}

export default UserForm;