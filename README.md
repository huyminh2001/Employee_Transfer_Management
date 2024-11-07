# ABC Technologies Employee Transfer Management System

This application manages employee transfer information, generates transfer-related documents, and allows authorized users to search, update, and create transfer records. The system is designed for ABC Technologies Ltd., aiming to streamline employee transfer processes, centralize data, and improve accessibility for management and employees.

## Project Overview

**Current Scenario**: Employee transfer records are maintained manually with inconsistent formats, creating inefficiencies in retrieving, updating, and communicating information. The current process is time-consuming as information is scattered across departments, and transfer notifications rely on circulars.

**Proposed Solution**: A centralized system that allows:
- Centralized access to all transfer records.
- Role-based access for system administrators and employees.
- Streamlined functions for generating documents and reports related to employee transfers.

## System Features

1. **User Login**  
   - **Employees**: Limited access for request submission and status updates.
   - **System Administrators**: Full access for managing transfers and generating reports.

2. **Transfer Management**  
   - **Search Transfer Records**: Search based on multiple fields, including:
      - Employee Number, Employee Name, From/To Location, From/To Project, From/To Department, and more.
   - **Update and Create Transfers**: Update existing records or create new transfer entries.
   - **Employee Transfer Requests**: Employees can submit transfer requests via a dedicated form.
   - **Transfer Approvals**: Approvals required from authorized personnel.

3. **Allowance Calculation**  
   - Generate allowances based on transfer location and employee post.

4. **Document Generation**  
   - **Transfer Letters**: Generate official transfer letters for each transfer.
   - **Reports**: Create reports for:
      - Transfers within specific time spans.
      - Transfers related to specific projects.

5. **Logout**  
   - Ensures secure access to the system by ending the session.

## Database Structure

The **Employee Master Record** table stores the following fields, among others:
- **Employee Information**: Employee Number, Employee Name, Role, Work Experience.
- **Project and Department Information**: Current Project, Current Department, Transfer Project, Transfer Department.
- **Location and Dates**: Current Location, Transfer Location, Transfer Relieving Date, Transfer Joining Date.
- **Management Information**: Reporting Manager.

## Usage Instructions

1. **Login**: Access the application with user-specific credentials.
2. **Search Records**: Use the search tool to filter transfer records by relevant parameters.
3. **Create or Update Transfer Records**: Fill in necessary details for new or existing records.
4. **Generate Reports**: Use the reporting tool to analyze transfer data by month, project, or location.
5. **Request Transfers (Employees)**: Submit transfer requests for review.
6. **Calculate Allowances**: Automatically calculate transfer allowances based on policy.
7. **Logout**: Securely log out from the system.
