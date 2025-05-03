import React from "react";

const LoanFilter = ({ onFilter }) => {
  return (
    <div className="loan-filter">
      <button onClick={() => onFilter("low-interest")}>Low Interest Loans</button>
      <button onClick={() => onFilter("all")}>All Loans</button>
    </div>
  );
};

export default LoanFilter;
