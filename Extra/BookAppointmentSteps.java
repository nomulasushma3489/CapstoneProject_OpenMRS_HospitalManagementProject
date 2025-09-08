package stepdefinitions;

import java.util.Map;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddPatientPage;
import pages.AddServiceTypePage;
import pages.BookAppointmentPage;
import pages.DashBoardPage;
import pages.LoginPage;
import utils.AppLogger;
import utils.ExcelUtils;

public class BookAppointmentSteps {
	
	WebDriver driver = DriverFactory.getDriver();
	private static final Logger log = AppLogger.get(AddServiceTypeSteps.class);
	LoginPage loginPage = new LoginPage();
	LoginSteps loginSteps = new LoginSteps();
	DashBoardPage dashboardPage = new DashBoardPage();
	AddPatientPage patientPage = new AddPatientPage();
	AddServiceTypePage addServiceType = new AddServiceTypePage();
	BookAppointmentPage bookAppointmentPage = new BookAppointmentPage();
	ExcelUtils excelUtil = new ExcelUtils();
	
	@Given("the user is logged into OpenMRS to book an appointment")
	public void the_user_is_logged_into_open_mrs_to_book_an_appointment() {
		driver.get(excelUtil.getCellData(0, 1));
	    loginPage.login("admin", "Admin123", "Registration Desk");
	    loginPage.clickLogin();
	    log.info("Logged in successfully and navigated to home page");
	}
	@And("the user navigates to the Appointment Scheduling module")
	public void the_user_navigates_to_the_appointment_scheduling_module() {
		bookAppointmentPage.clickAppointmentSchedulingModule();
		log.info("user navigates to Appointment Scheduling Module");
	}
	@And("the user navigates to Manage Appointments")
	public void the_user_navigates_to_manage_appointments() {
		bookAppointmentPage.clickManageAppointment();
		log.info("user navigates to Manage Appointments");
	}
	@When("the user searches for a registered patient by name")
	public void the_user_searches_for_a_registered_patient_by_name(io.cucumber.datatable.DataTable dataTable) {
		Map<String,String > data = dataTable.asMap(String.class,String.class);
		bookAppointmentPage.enterPatientName(data);
	}
	@When("the user selects the patient from the results")
	public void the_user_selects_the_patient_from_the_results() throws InterruptedException {
		bookAppointmentPage.serachPatientRecord();
	}
	@When("the user chooses an available service type and time slot")
	public void the_user_chooses_an_available_service_type_and_time_slot(io.cucumber.datatable.DataTable dataTable) {
		Map<String,String > data = dataTable.asMap(String.class,String.class);
		bookAppointmentPage.selectServiceSlot(data);
	}
	@When("the user clicks on the Book Appointment button")
	public void the_user_clicks_on_the_book_appointment_button() {
	    
	}
	@Then("the appointment should be successfully created")
	public void the_appointment_should_be_successfully_created() {
	    
	}
	@Then("a confirmation message should be displayed")
	public void a_confirmation_message_should_be_displayed() {
	    
	}
	@Then("the booked appointment should appear in the patient’s appointment list")
	public void the_booked_appointment_should_appear_in_the_patient_s_appointment_list() {
	    
	}
	
	
	
	
	
	

}
