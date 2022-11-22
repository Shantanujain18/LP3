//SPDX-License-Identifier: MIT
// Solidity program to implement
// the above approach
pragma solidity >= 0.7.0;

// Build the Contract
contract StudentManagmtSys
{
	struct Student
	{
		int ID;
		string fName;
		string lName;
		int marks;
	}


	address owner;
	Student[] public data;
	uint public total;
	modifier onlyOwner
	{
		require(owner == msg.sender);
		_;
	}
	constructor()
	{
		owner=msg.sender;
	}
    function addNewRecords(int _ID,
						string memory _fName,
						string memory _lName,
						int _marks) public onlyOwner
	{
		data.push(Student(_ID,_fName,_lName,_marks));
		total=data.length;
	}
	

}

