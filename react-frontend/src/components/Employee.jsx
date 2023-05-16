import { useEffect, useState } from 'react';
import EmployeeService from '../services/EmployeeService';

const Employee = () => {
	const [employee, setEmployee] = useState({});
	const [department, setDepartment] = useState({});
	const [organization, setOrganization] = useState({});
	const [loading, setLoading] = useState(false);

	useEffect(() => {
		EmployeeService.getEmployeeById().then((res) => {
			setEmployee(res.data.employee);
			setDepartment(res.data.department);
			setOrganization(res.data.organization);
		});
		setLoading(false);
	}, []);

	if (loading) {
		return <div>Loading...</div>;
	}

	return (
		<div>
			<div className="card col-md-6 mt-5 offset-md-3">
				<h3 className="text-center card-header">Employee Details</h3>
				<div className="card-body">
					<div className="row">
						<p>
							<strong>Employee First Name :</strong> {employee.firstName}
						</p>
					</div>
					<div className="row">
						<p>
							<strong>Employee Last Name :</strong> {employee.lastName}
						</p>
					</div>
					<div className="row">
						<p>
							<strong>Employee Email:</strong> {employee.email}
						</p>
					</div>
				</div>
				<h3 className="text-center card-header">Department Details</h3>
				<div className="card-body">
					<div className="row">
						<p>
							<strong>Department Name :</strong> {department.departmentName}
						</p>
					</div>
					<div className="row">
						<p>
							<strong>Department Code :</strong> {department.departmentCode}
						</p>
					</div>
					<div className="row">
						<p>
							<strong>Department Description :</strong> {department.departmentDescription}
						</p>
					</div>
				</div>
				<h3 className="text-center card-header">Organization Details</h3>
				<div className="card-body">
					<div className="row">
						<p>
							<strong>Organization Name : {organization.organizationName}</strong>
						</p>
					</div>
					<div className="row">
						<p>
							<strong>Organization Code : {organization.organizationCode}</strong>
						</p>
					</div>
					<div className="row">
						<p>
							<strong>Organization Description : {organization.organizationDescription}</strong>
						</p>
					</div>
				</div>
			</div>
		</div>
	);
};
export default Employee;
