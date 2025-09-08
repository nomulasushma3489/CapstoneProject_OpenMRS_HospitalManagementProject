Feature: Booking an appointment
	Background: As an OpenMRS user I want to test login and book an appointment So that the system works as expected

Scenario: Book an appointment for a registered patient
	Given the user is logged into OpenMRS to book an appointment
	And the user navigates to the Appointment Scheduling module 
	And the user navigates to Manage Appointments
	When the user searches for a registered patient by name 
	| patientName| John Doe |
	And the user selects the patient from the results
	And the user chooses an available service type and time slot
	|serviceType| Dermatology|
	|slot       | 15         |
	And the user clicks on the Book Appointment button
	Then the appointment should be successfully created
	And a confirmation message should be displayed
	And the booked appointment should appear in the patient’s appointment list