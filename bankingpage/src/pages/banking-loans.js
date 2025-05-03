import React, { useState } from "react";
import LoanCard from "../components/LoanCard";
import LoanFilter from "../components/LoanFilter";
import LoanForm from "../components/LoanForm";
import "../styles/bankingLoans.css";

const loansData = [
  { id: 1, name: "Government Business Loan", interest: "5%", eligibility: "Women-led businesses", description: "Low-interest loan for women entrepreneurs." },
  { id: 2, name: "Private Bank MSME Loan", interest: "8%", eligibility: "Small businesses", description: "Loan for expanding small businesses." },
];

const BankingLoans = () => {
  const [loans, setLoans] = useState(loansData);
  const [selectedLoan, setSelectedLoan] = useState(null);

  const handleFilter = (filterType) => {
    if (filterType === "low-interest") {
      setLoans(loansData.filter((loan) => loan.interest === "5%"));
    } else {
      setLoans(loansData);
    }
  };

  return (
    <div className="banking-loans">
      <h1>Banking & Loan Options</h1>
      
      <LoanFilter onFilter={handleFilter} />

      <div className="loan-list">
        {loans.map((loan) => (
          <LoanCard key={loan.id} loan={loan} onSelect={setSelectedLoan} />
        ))}
      </div>

      {selectedLoan && <LoanForm loan={selectedLoan} />}
    </div>
  );
};

export default BankingLoans;
