import React, { useState } from "react";

const LoanForm = ({ loan }) => {
  const [formData, setFormData] = useState({ name: "", income: "", businessType: "" });

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    alert("Application Submitted!");
  };

  return (
    <div className="loan-form">
      <h2>Apply for {loan.name}</h2>
      <form onSubmit={handleSubmit}>
        <input type="text" name="name" placeholder="Your Name" onChange={handleChange} required />
        <input type="number" name="income" placeholder="Monthly Income" onChange={handleChange} required />
        <input type="text" name="businessType" placeholder="Business Type" onChange={handleChange} required />
        <button type="submit">Submit Application</button>
      </form>
    </div>
  );
};

export default LoanForm;
