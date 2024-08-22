# Electronic Voting System

## Overview

The **Electronic Voting System** is a Java-based application designed to facilitate a secure and transparent voting process. It ensures that each vote is cast fairly and without the possibility of tampering, addressing the need for integrity in voting systems. This application prevents multiple votes from the same individual, maintains voter anonymity, and provides real-time results.

## Features

### Voter Registration

- **Register New Voters:** Users can register with their voter ID, name, and a password.  
- **Validation:** Ensures that each voter ID is unique and that all fields are correctly filled out.  
- **One-Time Registration:** Voters can only register once, preventing duplicate registrations.  

### Voting Process

- **Secure Login:** Voters must log in using their voter ID and password to cast their vote.  
- **Candidate Selection:** Voters can choose from a list of predefined candidates.  
- **One Person, One Vote:** Once a voter has cast their vote, they cannot vote again, ensuring that each voter can only vote once.  
- **Vote Anonymity:** The system ensures that no one can trace back which candidate a voter has selected.  

### Results Display

- **Real-Time Vote Counting:** The system counts votes in real-time and provides up-to-date results.  
- **Leading Candidate Notification:** Displays which candidate is currently leading and by how many votes.  
- **Final Results:** Shows the total number of votes for each candidate once the voting is complete.  

## Security Features

- **Authentication:** Voters must authenticate themselves using their unique voter ID and password.  
- **One-Person-One-Vote Policy:** Ensures that each voter can only vote once, eliminating the possibility of multiple votes from the same person.  
- **Data Integrity:** Votes cannot be altered once cast, ensuring that the results are accurate and fair.  
- **Anonymity:** The system does not link voter IDs with their selected candidates, preserving voter anonymity.  

## Installation

1. **Clone the Repository:**
   ```sh
   git clone https://github.com/your-username/electronic-voting-system.git

2. **Navigate to the Project Directory:**
   ```sh
   cd electronic-voting-system

3. **Compile the Java Files:**
   ```sh
   javac ElectronicVotingSystem.java
   
4. **Run the Application:**
   ```sh
   java ElectronicVotingSystem

## How to Use

#### Register as a Voter:

Run the application and select the "Register Voter" option.
Enter your voter ID, name, and password.

#### Cast a Vote:

Log in using your voter ID and password.
Choose your preferred candidate from the list and cast your vote.

#### View Results:

Select the "Show Results" option to see the current vote tally and the leading candidate.

## Contributions

Contributions to improve the Electronic Voting System are welcome. You can contribute by:

- Reporting bugs

- Suggesting new features

- Submitting pull requests
