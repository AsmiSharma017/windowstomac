import React from "react";

const LoanCard = ({ loan, onSelect }) => {
  return (
    <div className="loan-card" onClick={() => onSelect(loan)}>
      <h3>{loan.name}</h3>
      <p><b>Interest Rate:</b> {loan.interest}</p>
      <p><b>Eligibility:</b> {loan.eligibility}</p>
      <p>{loan.description}</p>
      <button>Apply Now</button>
    </div>
  );
};

export default LoanCard;
