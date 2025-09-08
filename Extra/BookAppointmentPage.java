package pages;

import java.util.Map;

import org.openqa.selenium.By;

import factory.DriverFactory;
import utils.ElementUtils;
import utils.WaitUtils;

public class BookAppointmentPage {
	
	ElementUtils util = new ElementUtils(DriverFactory.getDriver());
	WaitUtils waitUtil = new WaitUtils(DriverFactory.getDriver(),5);
	private By appointmentschedulingMenu = By.id("appointmentschedulingui-homeAppLink-appointmentschedulingui-homeAppLink-extension");
	private By manageAppointmentMenu =By.id("appointmentschedulingui-manageAppointments-app");
	private By patientNameField =By.id("patient-search");
	private By searchDataTable = By.cssSelector("table#patient-search-results-table");
	private By searchData = By.cssSelector("table#patient-search-results-table tbody tr td");
//	private By patientName = By.xpath("//ul[@id='breadcrumbs']/li[last()]");
	private By selectServiceType = By.xpath("//input[@ng-model='appointmentType']");
//	private By selectServiceTypeDropDown = By.xpath("//a[normalize-space()='']");
	private By timeSlotIcon = By.xpath("//i[@ng-click='startDateOptions.open($event)']");
//	private By selectDate = By.xpath("//span[normalize-space()='']");
	public void clickAppointmentSchedulingModule() {
		util.doClick(appointmentschedulingMenu);
	}
	
	public void clickManageAppointment() {
		util.doClick(manageAppointmentMenu);
	}
	
	public void enterPatientName(Map<String, String> data) {
		util.doSendKeys(patientNameField, data.get("patientName"));
	}
	
	public void serachPatientRecord() throws InterruptedException {
		waitUtil.waitForElementVisible(searchDataTable);
		Thread.sleep(5000);
		waitUtil.waitForElementClickable(searchData);
		util.doClick(searchData);
		Thread.sleep(5000);
	}
	
	public void selectServiceSlot(Map<String,String> data) {
		By selectServiceTypeDropDown = By.xpath("//a[normalize-space()='" + data.get("sessionType") + "']");
		By selectDate = By.xpath("//span[normalize-space()='"+data.get("date") +"']");
		util.doSendKeys(selectServiceType, data.get("sessionType"));
		util.doClick(selectServiceTypeDropDown);
		util.doClick(timeSlotIcon);
		util.doClick(selectDate);
	}

}





